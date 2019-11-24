package com.hyunwoong.sample.core.controller;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.core.model.UserDto;
import com.hyunwoong.sample.core.service.AuthService;
import com.hyunwoong.sample.core.service.CheckService;
import com.hyunwoong.sample.core.service.DBService;
import com.hyunwoong.sample.core.view.SplashView;
import com.hyunwoong.sample.databinding.SplashBinding;
import com.hyunwoong.sample.util.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashController extends Controller<SplashBinding, SplashView> {

    private AuthService auth = new AuthService(this);
    private CheckService check = new CheckService(this);
    private DBService db = new DBService(this);

    public boolean isRemembered() {
        String remembered = preference().getString("id");
        return !check.isEmpty(remembered);
    }

    private void delayAndMove(int mills) {
        handler.postDelayed(() -> moveAndFinish(SignInController.class), mills);
    }

    private void autonomousSignIn() {
        db.of(UserDto.class).select(user ->
                auth.signIn(user, this::updateView), true);
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            moveAndFinish(MainController.class);
        } else {
            toast("로그인에 실패했습니다.");
        }
    }

    @OnXML(resid = R.layout.splash)
    public void splash() {
        if (isRemembered()) autonomousSignIn();
        else delayAndMove(2500);
    }
}
