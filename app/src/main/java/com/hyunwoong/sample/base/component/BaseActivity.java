package com.hyunwoong.sample.base.component;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import com.hyunwoong.sample.BR;
import com.hyunwoong.sample.base.extension.UIExtension;
import com.hyunwoong.sample.di.ViewModelFactory;


/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:11
 * @homepage : https://github.com/gusdnd852
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends ViewModel>
        extends UIExtension {

    protected V view;
    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = DataBindingUtil.setContentView(this, injectView());
        viewModel = ViewModelFactory.createViewModel(this, injectViewModel());
        view.setVariable(BR.viewModel, viewModel);
        view.setVariable(BR.activity, this);
    }

    protected abstract int injectView();

    protected abstract Class<VM> injectViewModel();
}
