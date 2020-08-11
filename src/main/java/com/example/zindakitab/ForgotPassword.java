package com.example.zindakitab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button b1=findViewById(R.id.btn_forgot);
        Button b2=findViewById(R.id.btn_login);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginactivity();
            }
        });
    }

    public void loginactivity(){
        Intent intent = new Intent();
        intent.setClass(this, Login.class);
        startActivity(intent);
        this.finish();
    }
}