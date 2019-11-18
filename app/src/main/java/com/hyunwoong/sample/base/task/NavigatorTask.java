package com.hyunwoong.sample.base.task;

import com.hyunwoong.sample.base.activity.BaseActivity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 3:47
 * @homepage : https://github.com/gusdnd852
 */
public abstract class NavigatorTask {

    protected Navigator navigator;
    // there are no activity context

    public NavigatorTask(BaseActivity owner) {
        this.navigator = new Navigator() {
            @Override public void move(Class<? extends BaseActivity> activity) {
                owner.startActivity(activity);
            }

            @Override public void finish() {
                owner.finish();
            }

            @Override public void moveAndFinish(Class<? extends BaseActivity> activity) {
                owner.startActivityAndFinish(activity);
            }

            @Override public void requestPermissions(String... permissions) {
                owner.requestPermissions(permissions);
            }

            @Override public void toast(String msg) {
                owner.toast(msg);
            }

            @Override public void dialog(String title, String msg, Runnable action) {
                owner.dialog(title, msg, action);
            }

            @Override public void showProgress() {
                owner.showProgress();
            }

            @Override public void hideProgress() {
                owner.hideProgress();
            }

            @Override public void hideAndToast(String msg) {
                owner.hideAndToast(msg);
            }
        };
    }
}
