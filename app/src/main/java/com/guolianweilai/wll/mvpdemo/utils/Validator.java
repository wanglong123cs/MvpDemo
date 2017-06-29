package com.guolianweilai.wll.mvpdemo.utils;

import android.text.TextUtils;

/**
 * Created by TT on 2017/6/21.
 */

public class Validator {
    public Validator() {

    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    public boolean validPassword(String password) {
        return !TextUtils.isEmpty(password);
    }
}
