package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.core.model.cache.UserCache;
import com.hyunwoong.sample.core.model.entity.UserEntity;
import com.hyunwoong.sample.core.viewmodel.MainViewModel;
import com.hyunwoong.sample.databinding.MainView;
import com.hyunwoong.sample.util.OnXML;

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

    @OnXML(resid = R.layout.main_view)
    public void showInfo() {
        UserCache cache = UserCache.getInstance();
        UserEntity user = cache.read();

        viewModel.getId().setValue(user.getId());
        viewModel.getName().setValue(user.getName());
        viewModel.getPw().setValue(user.getPw());
    }
}
