package com.guolianweilai.wll.mvpdemo.data.remote;

/**
 * Created by TT on 2017/6/21.
 */

public interface SimpleCallback<T> {
    void onStart();
    void onNext(T t);
    void onComplete();
}
