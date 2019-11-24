package com.hyunwoong.sample.core.controller;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.core.model.UserDto;
import com.hyunwoong.sample.core.service.AuthService;
import com.hyunwoong.sample.core.service.CheckService;
import com.hyunwoong.sample.core.service.CheckService.Component;
import com.hyunwoong.sample.core.service.DBService;
import com.hyunwoong.sample.core.view.SignInView;
import com.hyunwoong.sample.databinding.SignInBinding;
import com.hyunwoong.sample.util.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */
public class SignInController extends Controller<SignInBinding, SignInView> {

    private AuthService auth = new AuthService(this);
    private CheckService check = new CheckService(this);
    private DBService db = new DBService(this);

    private void staySignedIn(Task<AuthResult> task, UserDto user, Data<Boolean> stay) {
        if (task.isSuccessful()) {
            if (stay.getValue()) {
                preference().setString("id", user.getId());
                preference().setString("pw", user.getPw());
            } else {
                preference().setString("id", null);
                preference().setString("pw", null);
            }
        }
    }


    private boolean checkUser(UserDto user) {
        return check.isOk(user, Component.id, Component.pw);
    }
}