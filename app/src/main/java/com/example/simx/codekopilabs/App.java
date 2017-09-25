package com.example.simx.codekopilabs;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by simx on 9/25/17.
 */

public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context ;
    }
}
