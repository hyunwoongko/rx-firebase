package com.hyunwoong.sample.base;

import androidx.lifecycle.ViewModel;

import com.hyunwoong.sample.util.data.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 2:33
 * @homepage : https://github.com/gusdnd852
 */
public abstract class View extends ViewModel {
    public Data<Integer> progressBar = new Data<>(android.view.View.GONE);

    public void showProgress() {
        this.progressBar.setValue(android.view.View.VISIBLE);
    }

    public void hideProgress() {
        this.progressBar.setValue(android.view.View.GONE);
    }
}
