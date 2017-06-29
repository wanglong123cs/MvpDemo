package com.guolianweilai.wll.mvpdemo.module.login;

import dagger.Subcomponent;

/**
 * Created by TT on 2017/6/21.
 */
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    LoginActivity inject(LoginActivity loginActivity);
}
