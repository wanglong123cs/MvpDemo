package com.guolianweilai.wll.mvpdemo.di;

import com.guolianweilai.wll.mvpdemo.module.login.LoginComponent;
import com.guolianweilai.wll.mvpdemo.module.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TT on 2017/6/21.
 */
@Singleton
@Component(modules = {AppModule.class,ApiModule.class})
public interface AppComponent {
    LoginComponent plus(LoginModule loginModule);
}
