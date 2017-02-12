package com.leeway.simplemvp;

import android.app.Application;

import com.leeway.simplemvp.di.AppComponent;
import com.leeway.simplemvp.di.DaggerAppComponent;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
