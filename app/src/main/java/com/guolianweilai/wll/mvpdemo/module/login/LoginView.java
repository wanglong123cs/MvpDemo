package com.guolianweilai.wll.mvpdemo.module.login;

import com.guolianweilai.wll.mvpdemo.data.remote.model.User;
import com.guolianweilai.wll.mvpdemo.module.base.BaseLoadView;

/**
 * Created by TT on 2017/6/21.
 */

public interface LoginView extends BaseLoadView{
    void canLogin(boolean canLogin);
    void showUser(User user);
}
