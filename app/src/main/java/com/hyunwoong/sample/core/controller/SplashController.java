package com.hyunwoong.sample.core.controller;

import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.core.view.SplashView;
import com.hyunwoong.sample.databinding.SplashBinding;
import com.hyunwoong.sample.util.data.Cache;
import com.hyunwoong.sample.util.data.Firebase;
import com.hyunwoong.sample.util.others.Strings;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashController extends Controller<SplashBinding, SplashView> {

    public boolean isRemembered() {
        String remembered = preference().getString("id");
        return remembered != null;
    }

    public void delayAndMove(int mills) {
        handler.postDelayed(() ->
                moveAndFinish(SignInController.class), mills);
    }

    public void signIn(User user) {
        Firebase.signIn()
                .success(u -> moveAndFinish(MainController.class))
                .fail(u -> toast("로그인에 실패했습니다."))
                .subscribe(user);
    }

    public void autonomousSignIn() {
        String id = preference().getString("id");

        Firebase.from("user")
                .child(Strings.key(id))
                .access(User.class)
                .next(Cache::copyUser)
                .next(this::signIn)
                .subscribe();
    }
}
