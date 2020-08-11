package com.example.zindakitab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button b1=findViewById(R.id.btnsignup);
        Button b2=findViewById(R.id.btngologin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText full_name=findViewById(R.id.fullnametxt);
                EditText sign_email=findViewById(R.id.signemailtxt);
                EditText sign_pass=findViewById(R.id.signpasstxt);
                if(validate()) {
                    Data d = Data.getInstance();
                    if(d.signup(full_name.getText().toString(),sign_email.getText().toString(),sign_pass.getText().toString())) {
                        dailogmsg("Signup Successfully!");
                    }
                    else{
                        dailogmsg("Account Already Exist!");
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotologin();
            }
        });

    }
    public void dailogmsg(final String msg){
        final AlertDialog alertDialog = new AlertDialog.Builder(Signup.this).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if(msg.equals("Signup Successfully!")){
                            gotologin();
                        }
                    }
                });
        alertDialog.show();
    }
    public void gotologin(){
        Intent intent = new Intent();
        intent.setClass(this,Login.class);
        startActivity(intent);
        this.finish();
    }

    public boolean validate(){
        boolean isvalid=true;
        EditText full_name=findViewById(R.id.fullnametxt);
        EditText sign_email=findViewById(R.id.signemailtxt);
        EditText signpass=findViewById(R.id.signpasstxt);
        EditText confirmpass=findViewById(R.id.confirmpasstxt);
        String namePattren= "^[a-zA-Z ]*$";
        String emailPattern = "^[A-Za-z0-9._\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";
        if(full_name.getText().toString().equals("")) {
            full_name.setError("Enter full name");
            isvalid=false;
        }
        else if(!full_name.getText().toString().matches(namePattren)) {
            full_name.setError("Invalid name");
            isvalid=false;
        }
        if(sign_email.getText().toString().equals("")) {
            sign_email.setError("Enter email");
            isvalid=false;
        }
        else if(!sign_email.getText().toString().trim().matches(emailPattern)){
            sign_email.setError("Invalid email");
            isvalid=false;
        }
        if(signpass.getText().toString().equals("")){
            signpass.setError("Pick a password");
            isvalid=false;
        }
        else if(signpass.getText().length()<8 || signpass.getText().length()>12){
            signpass.setError("Password must have 8-12 characters");
            isvalid=false;
        }
        if(!confirmpass.getText().toString().equals(signpass.getText().toString())){
            confirmpass.setError("Password doesn't match");
            isvalid=false;
        }
        return isvalid;
    }

    private static long back_pressed;

    @Override
    public void onBackPressed()
    {
        gotologin();
    }

}