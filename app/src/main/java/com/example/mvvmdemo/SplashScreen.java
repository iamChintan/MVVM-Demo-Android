package com.example.mvvmdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        InIt();
    }

    private void InIt() {
         animationView = findViewById(R.id.animation);

         animationView.addAnimatorListener(new Animator.AnimatorListener() {
             @Override
             public void onAnimationStart(@NonNull Animator animator) {

             }

             @Override
             public void onAnimationEnd(@NonNull Animator animator) {
                 GoTOMain();
             }

             private void GoTOMain() {

                 Intent i = new Intent(SplashScreen.this, MainActivity.class);
                 startActivity(i);
                 finish();
             }

             @Override
             public void onAnimationCancel(@NonNull Animator animator) {

             }

             @Override
             public void onAnimationRepeat(@NonNull Animator animator) {

             }
         });
    }
}