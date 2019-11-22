package com.hyunwoong.sample.core.service;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.base.Service;
import com.hyunwoong.sample.core.model.UserDto;
import com.hyunwoong.sample.util.Firebase;

/**
 * @author : Hyunwoong
 * @when : 2019-11-22 오후 12:20
 * @homepage : https://github.com/gusdnd852
 */
public class AuthService extends Service {
    private static AuthService instance;

    public synchronized static AuthService getInstance(Controller controller) {
        if (instance == null)
            instance = new AuthService(controller);
        return instance;
    }

    private AuthService(Controller owner) {
        super(owner);
    }

    public void signIn(UserDto user, OnCompleteListener<AuthResult> listener) {
        Firebase.auth()
                .signInWithEmailAndPassword(user.getId(), user.getPw())
                .addOnCompleteListener(listener);
    }

    public void signUp(UserDto user, OnCompleteListener<AuthResult> listener) {
        Firebase.auth()
                .createUserWithEmailAndPassword(user.getId(), user.getPw())
                .addOnCompleteListener(listener);
    }
}
