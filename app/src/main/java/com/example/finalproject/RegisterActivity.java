package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText email,password,rePassword;
    Button goToSignIn, signUpBtn;
    DBHelper DB;
    static Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        rePassword = findViewById(R.id.inputRePassword);
        goToSignIn = findViewById(R.id.goTosignIn);
        signUpBtn = findViewById(R.id.signUp);
        DB = new DBHelper(this);
        session = new Session(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                String userRePassword = rePassword.getText().toString();

                if(userEmail.equals("") || userPassword.equals("") || userRePassword.equals("")){
                    Toast.makeText(RegisterActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }else{
                    if(userPassword.equals(userRePassword)){
                        Boolean checkUser = DB.checkUsersEmail(userEmail);
                        if(checkUser==false){
                            Boolean insert = DB.insertData(userEmail,userPassword);
                            if(insert==true){
                                session.setLoggedIn(true);
                                Toast.makeText(RegisterActivity.this,"REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this,"REGISTRATION FAILED",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this,"User already exists! Please sign in",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"Passwords not matching",Toast.LENGTH_SHORT).show();
                    }
                    }
                }
        });

        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}