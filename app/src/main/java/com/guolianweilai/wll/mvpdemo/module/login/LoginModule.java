package com.guolianweilai.wll.mvpdemo.module.login;

import com.guolianweilai.wll.mvpdemo.data.local.PreferencesManager;
import com.guolianweilai.wll.mvpdemo.data.remote.ApiManager;
import com.guolianweilai.wll.mvpdemo.utils.Validator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TT on 2017/6/21.
 */
@Module
public class LoginModule {
    private final LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    LoginView provideLoginView() {
        return loginView;
    }


    @Provides
    Validator provideValidator(){
        return new Validator();
    }

    @Provides
    LoginPresenter provideLoginPresenter(Validator validator, ApiManager apiManager, PreferencesManager preferencesManager) {
        return new LoginPresenter(loginView,validator,apiManager,preferencesManager);
    }
}
