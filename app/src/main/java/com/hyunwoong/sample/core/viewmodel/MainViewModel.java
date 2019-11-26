package com.hyunwoong.sample.core.viewmodel;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.BaseViewModel;
import com.hyunwoong.sample.core.activity.MainActivity;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.util.data.Cache;
import com.hyunwoong.sample.util.data.Data;
import com.hyunwoong.sample.util.view.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 2:01
 * @homepage : https://github.com/gusdnd852
 */
public class MainViewModel extends BaseViewModel {
    public Data<String> greeting = new Data<>();

    @OnXML(resid = R.layout.main)
    public void showInformation(MainActivity activity) {
        User user = Cache.readUser();
        greeting.set(user.getName() + "님 환영합니다.");
    }
}
