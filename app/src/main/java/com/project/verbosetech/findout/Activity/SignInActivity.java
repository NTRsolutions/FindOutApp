package com.project.verbosetech.findout.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.project.verbosetech.findout.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by this pc on 05-06-17.
 */

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    Button login;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        login=(Button)findViewById(R.id.login_button);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.login_button:startActivity(new Intent(SignInActivity.this,MainActivity.class));
                finish();
                break;
        }
    }
}
