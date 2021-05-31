package com.mrq.library.Z_setting;

import android.app.Application;

import com.mrq.library.Logger.AndroidLogAdapter;
import com.mrq.library.Logger.Logger;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());

    }
}
