package com.example.mvvmdemo;


import static com.example.mvvmdemo.BR.userEmail;
import static com.example.mvvmdemo.BR.userPassword;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class LogInViewModel extends BaseObservable {
    private User user;

    private String LoginSuccess = "LogIn Success";
    private String LoginFail = "LogIn Failed";

    @Bindable
    private String toastMSG ="";
    public String getToastMSG() {
        return toastMSG;
    }

    public void setToastMSG(String toastMSG) {
        this.toastMSG = toastMSG;
        notifyPropertyChanged(BR.toastMSG);
    }

    @Bindable
    public String getUserEmail(){
       return user.getEmail();
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(userEmail);
    }

    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }

    public void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(userPassword);
    }

    public LogInViewModel() {
        user = new User("","");
    }

    public void onLoginClicked(){
        if(ValidInput()){
            setToastMSG(LoginSuccess);
        }else {
            setToastMSG(LoginFail);
        }
    }

    private boolean ValidInput() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
