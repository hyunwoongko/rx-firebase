package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.core.task.SplashTask;
import com.hyunwoong.sample.core.viewmodel.SplashViewModel;
import com.hyunwoong.sample.databinding.SplashView;
import com.hyunwoong.sample.di.TaskFactory;
import com.hyunwoong.sample.util.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashActivity extends BaseActivity<SplashView, SplashViewModel> {

    private SplashTask splashTask = TaskFactory.createTask(this, SplashTask.class);

    @Override
    protected int injectView() {
        return R.layout.splash_view;
    }

    @Override
    protected Class<SplashViewModel> injectViewModel() {
        return SplashViewModel.class;
    }

    @OnXML(resid = R.layout.splash_view)
    public void splash() {
        splashTask.splash();
    }
}
