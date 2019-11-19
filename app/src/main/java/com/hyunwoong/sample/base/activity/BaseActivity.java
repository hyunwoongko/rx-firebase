package com.hyunwoong.sample.base.activity;

import android.app.AlertDialog;
import android.widget.Toast;

import androidx.databinding.ViewDataBinding;

import com.hyunwoong.sample.base.viwemodel.BaseViewModel;
import com.hyunwoong.sample.util.Preference;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:11
 * @homepage : https://github.com/gusdnd852
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends ExtendedActivity<V, VM> {

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void dialog(String title, String msg, Runnable positive) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("확인", (dialog, which) -> positive.run())
                .setNegativeButton("취소", (dialog, which) -> {
                })
                .setCancelable(false)
                .create()
                .show();
    }

    public void showProgress() {
        viewModel.showProgress();
    }

    public void hideProgress() {
        viewModel.hideProgress();
    }

    public void hideAndToast(String msg) {
        hideProgress();
        toast(msg);
    }
}
