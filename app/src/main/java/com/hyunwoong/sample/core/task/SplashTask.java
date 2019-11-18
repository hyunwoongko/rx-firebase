package com.hyunwoong.sample.core.task;

import android.os.Handler;

import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.base.task.BaseTask;
import com.hyunwoong.sample.core.activity.SignInActivity;


/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashTask extends BaseTask {

    public SplashTask(BaseActivity owner) {
        super(owner);
    }

    public void splash() {
        new Handler().postDelayed(() ->
                moveAndFinish(SignInActivity.class), 3000);
    }
}
