package com.example.finalproject;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedIn(boolean loggedin){
        editor.putBoolean("loggedInMode",loggedin);
        editor.commit();
    }

    public boolean loggenIn(){
        return prefs.getBoolean("loggedInMode",false);
    }
}
