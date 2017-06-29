package com.guolianweilai.wll.mvpdemo.app;

import android.app.Application;
import android.content.Context;

import com.guolianweilai.wll.mvpdemo.di.AppComponent;
import com.guolianweilai.wll.mvpdemo.di.AppModule;
import com.guolianweilai.wll.mvpdemo.di.DaggerAppComponent;

/**
 * Created by TT on 2017/6/21.
 */

public class App extends Application {

    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }



}
