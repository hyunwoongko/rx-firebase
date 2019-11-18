package com.hyunwoong.sample.base.task;

import com.hyunwoong.sample.base.activity.BaseActivity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 4:01
 * @homepage : https://github.com/gusdnd852
 */
public interface Navigator {
    void move(Class<? extends BaseActivity> activity);

    void finish();

    void moveAndFinish(Class<? extends BaseActivity> activity);

    void requestPermissions(String... permissions);

    void toast(String msg);

    void dialog(String title, String msg, Runnable action);

    void showProgress();

    void hideProgress();

    void hideAndToast(String msg);
}
