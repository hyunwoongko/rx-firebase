package com.hyunwoong.sample.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.hyunwoong.sample.BR;
import com.hyunwoong.sample.base.viwemodel.BaseViewModel;
import com.hyunwoong.sample.di.ViewModelFactory;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 3:42
 * @homepage : https://github.com/gusdnd852
 */
public abstract class MVVMActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    protected V view;

    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = DataBindingUtil.setContentView(this, injectView());
        viewModel = ViewModelFactory.createViewModel(this, injectViewModel());
        view.setLifecycleOwner(this);
        view.setVariable(BR.viewModel, viewModel);
        view.setVariable(BR.activity, this);
    }

    protected abstract int injectView();

    protected abstract Class<VM> injectViewModel();

}
