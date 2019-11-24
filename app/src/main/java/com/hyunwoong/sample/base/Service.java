package com.hyunwoong.sample.base;

import com.hyunwoong.sample.util.Preference;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 3:47
 * @homepage : https://github.com/gusdnd852
 */
public abstract class Service {
    private Controller controller;

    public Service(Controller controller) {
        this.controller = controller;
    }

    public void move(Class<? extends Controller> activity) {
        controller.move(activity);
    }

    public void moveAndFinish(Class<? extends Controller> activity) {
        controller.moveAndFinish(activity);
    }

    public void finish() {
        controller.finish();
    }

    public void requestPermissions(String... permissions) {
        controller.requestPermissions(permissions);
    }

    public Preference preference() {
        return controller.preference();
    }

    public void toast(String msg) {
        controller.toast(msg);
    }

    public void dialog(String title, String msg, Runnable action) {
        controller.dialog(title, msg, action);
    }

    public void showProgress() {
        controller.showProgress();
    }

    public void hideProgress() {
        controller.hideProgress();
    }

    public void hideAndToast(String msg) {
        controller.hideAndToast(msg);
    }
}
