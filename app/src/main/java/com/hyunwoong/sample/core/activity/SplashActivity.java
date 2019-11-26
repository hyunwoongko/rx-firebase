package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.base.BaseActivity;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.core.viewmodel.SplashViewModel;
import com.hyunwoong.sample.databinding.SplashView;
import com.hyunwoong.sample.util.data.Cache;
import com.hyunwoong.sample.util.data.RxFirebase;
import com.hyunwoong.sample.util.others.Strings;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashActivity extends BaseActivity<SplashView, SplashViewModel> {

    public boolean isRemembered() {
        String remembered = preference().getString("id");
        return remembered != null;
    }

    public void delayAndMove(int mills) {
        handler.postDelayed(() ->
                moveAndFinish(SignInActivity.class), mills);
    }

    public void signIn(User user) {
        RxFirebase.signIn()
                .success(u -> moveAndFinish(MainActivity.class))
                .fail(u -> toast("로그인에 실패했습니다."))
                .subscribe(user);
    }

    public void autonomousSignIn() {
        String id = preference().getString("id");

        RxFirebase.from("user")
                .child(Strings.key(id))
                .access(User.class)
                .next(Cache::copyUser)
                .next(this::signIn)
                .subscribe();
    }
}
