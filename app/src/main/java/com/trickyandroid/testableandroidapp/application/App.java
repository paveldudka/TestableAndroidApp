package com.trickyandroid.testableandroidapp.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by paveldudka on 3/7/15.
 */
public class App extends Application {

    private AppGraph component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = AppComponent.Initializer.init();
    }

    public void setDiConfig(DiConfiguration config) {
        component = AppComponent.Initializer.init(config);
    }

    public static App getInstance(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppGraph getAppGraph() {
        return component;
    }
}
