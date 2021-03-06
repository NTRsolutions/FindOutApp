package com.project.verbosetech.findout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.project.verbosetech.findout.R;

/**
 * Created by this pc on 08-06-17.
 */

public class SplashActivity extends AppCompatActivity {

    private int SPLASH_TIME_OUT=1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                    Intent i = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(i);
                    // close this activity
                    finish();

            }
        }, SPLASH_TIME_OUT);
    }

}
