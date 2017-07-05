package com.project.verbosetech.findout.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.verbosetech.findout.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by this pc on 08-06-17.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Button sign_up;
    TextView sign_in;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_in = (TextView) findViewById(R.id.sign_in);
        sign_up = (Button) findViewById(R.id.sign_up_button);

        //setting click listeners
        sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.sign_in:

                //sign_in button click
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                finish();
                break;
            case R.id.sign_up_button:

                //sign_up button click
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                finish();
                break;

        }

    }
}
