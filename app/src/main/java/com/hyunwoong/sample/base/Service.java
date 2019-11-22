package com.hyunwoong.sample.base;

import com.hyunwoong.sample.util.Preference;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 3:47
 * @homepage : https://github.com/gusdnd852
 */
public abstract class Service {
    private Navigator navigator;

    public Service(Controller owner) {
        this.navigator = new Navigator() {
            @Override public void move(Class<? extends Controller> controller) {
                owner.move(controller);
            }

            @Override public void finish() {
                owner.finish();
            }

            @Override public void moveAndFinish(Class<? extends Controller> controller) {
                owner.moveAndFinish(controller);
            }

            @Override public void requestPermissions(String... permissions) {
                owner.requestPermissions(permissions);
            }

            @Override public Preference preference() {
                return owner.preference();
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

    public void move(Class<? extends Controller> activity) {
        navigator.move(activity);
    }

    public void moveAndFinish(Class<? extends Controller> activity) {
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

    public interface Navigator {
        void move(Class<? extends Controller> controller);

        void finish();

        void moveAndFinish(Class<? extends Controller> controller);

        void requestPermissions(String... permissions);

        Preference preference();

        void toast(String msg);

        void dialog(String title, String msg, Runnable action);

        void showProgress();

        void hideProgress();

        void hideAndToast(String msg);
    }
}
