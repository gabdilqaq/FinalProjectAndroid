package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {
    Handler h = new Handler();
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        session = new Session(this);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(session.loggenIn()) {
                    Intent i = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(Splashscreen.this, RegisterActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },2000);

    }
}