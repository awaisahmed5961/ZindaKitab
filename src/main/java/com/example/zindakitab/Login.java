package com.example.zindakitab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1=findViewById(R.id.btnlogin);
        Button b2=findViewById(R.id.btngosignup);
        Button b3=findViewById(R.id.btn_forgot_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loguser=findViewById(R.id.logemailtxt);
                EditText logpass=findViewById(R.id.logpasstxt);
                Data d = Data.getInstance();
//                if(validate()){
//                    if(d.login(loguser.getText().toString(),logpass.getText().toString())){
//                        loguser.setText("");
//                        logpass.setText("");
//                        login();
//                    }
//                    else{
//                        dailogmsg("Incorrect Email or Password!");
//                    }
//                }
                login();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotpassword();
            }
        });

    }

    public void dailogmsg(String msg){
        AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void login(){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }


    public void signup(){
        Intent intent = new Intent();
        intent.setClass(this,Signup.class);
        startActivity(intent);
        this.finish();
    }

    public void forgotpassword(){
        Intent intent = new Intent();
        intent.setClass(this, ForgotPassword.class);
        startActivity(intent);
        this.finish();
    }


    public boolean validate(){
        boolean isvalid=true;
        String emailPattern = "^[A-Za-z0-9._\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";
        EditText logemail=findViewById(R.id.logemailtxt);
        EditText logpass=findViewById(R.id.logpasstxt);
        if(logemail.getText().toString().equals("")) {
            logemail.setError("Enter email");
            isvalid=false;
        }
        else if(!logemail.getText().toString().trim().matches(emailPattern)){
            logemail.setError("Invalid email");
            isvalid=false;
        }
        if(logpass.getText().toString().equals("")){
            logpass.setError("Enter password");
            isvalid=false;
        }
        return isvalid;
    }

    private static long back_pressed;

    @Override
    public void onBackPressed()
    {
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}