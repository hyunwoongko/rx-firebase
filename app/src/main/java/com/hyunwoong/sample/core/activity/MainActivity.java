package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.component.BaseActivity;
import com.hyunwoong.sample.core.viewmodel.MainViewModel;
import com.hyunwoong.sample.databinding.MainView;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 1:59
 * @homepage : https://github.com/gusdnd852
 */
public class MainActivity extends BaseActivity<MainView, MainViewModel> {
    @Override protected int injectView() {
        return R.layout.main_view;
    }

    @Override protected Class<MainViewModel> injectViewModel() {
        return MainViewModel.class;
    }
}
