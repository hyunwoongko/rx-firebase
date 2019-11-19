package com.hyunwoong.sample.base.task;

import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.util.Preference;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */

public abstract class BaseTask extends NavigatorTask implements Navigator {

    public BaseTask(BaseActivity owner) {
        super(owner);
    }

    public void move(Class<? extends BaseActivity> activity) {
        navigator.move(activity);
    }

    public void moveAndFinish(Class<? extends BaseActivity> activity) {
        navigator.moveAndFinish(activity);
    }

    public void finish() {
        navigator.finish();
    }

    public void requestPermissions(String... permissions) {
        navigator.requestPermissions(permissions);
    }

    public Preference preference() {
        return navigator.preference();
    }

    public void toast(String msg) {
        navigator.toast(msg);
    }

    public void dialog(String title, String msg, Runnable action) {
        navigator.dialog(title, msg, action);
    }

    public void showProgress() {
        navigator.showProgress();
    }

    public void hideProgress() {
        navigator.hideProgress();
    }

    public void hideAndToast(String msg) {
        navigator.hideAndToast(msg);
    }
}
