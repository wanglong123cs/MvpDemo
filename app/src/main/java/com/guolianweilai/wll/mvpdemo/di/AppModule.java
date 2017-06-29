package com.guolianweilai.wll.mvpdemo.di;

import android.app.Application;

import com.guolianweilai.wll.mvpdemo.data.local.PreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TT on 2017/6/21.
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }



    @Provides
    @Singleton
    public PreferencesManager provideSharedPreferences(){
        return new PreferencesManager(application);
    }




}
