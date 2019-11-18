package com.hyunwoong.sample.base.viwemodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.hyunwoong.sample.util.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 2:33
 * @homepage : https://github.com/gusdnd852
 */
public class BaseViewModel extends ViewModel {
    private Data<Integer> progressBar = new Data<>(View.GONE);

    public Data<Integer> getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(Data<Integer> progressBar) {
        this.progressBar = progressBar;
    }

    public void showProgress() {
        this.progressBar.setValue(View.VISIBLE);
    }

    public void hideProgress() {
        this.progressBar.setValue(View.GONE);
    }
}
