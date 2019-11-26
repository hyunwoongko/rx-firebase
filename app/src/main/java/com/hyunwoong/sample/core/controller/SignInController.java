package com.hyunwoong.sample.core.controller;

import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.core.view.SignInView;
import com.hyunwoong.sample.databinding.SignInBinding;
import com.hyunwoong.sample.util.data.Cache;
import com.hyunwoong.sample.util.data.Firebase;
import com.hyunwoong.sample.util.others.Strings;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */
public class SignInController extends Controller<SignInBinding, SignInView> {

    public boolean check(User user) {
        if (Strings.empty(user.getId())) return hideAndToast("아이디를 입력해주세요.");
        else if (Strings.empty(user.getPw())) return hideAndToast("비밀번호를 입력해주세요.");
        else return true;
    }

    public void staySignedIn(boolean stay, User user) {
        if (stay) {
            preference().setString("id", user.getId());
            preference().setString("pw", user.getPw());
        } else {
            preference().setString("id", null);
            preference().setString("pw", null);
        }
    }

    public void signIn(boolean stay, User user) {
        Firebase.signIn()
                .success(u -> this.staySignedIn(stay, u))
                .success(u -> moveAndFinish(MainController.class))
                .fail(u -> hideAndToast("로그인에 실패했습니다."))
                .subscribe(user);
    }

    public void cachedSignIn(boolean stay, User user) {
        String id = user.getId();

        Firebase.from("user")
                .child(Strings.key(id))
                .access(User.class)
                .next(Cache::copyUser)
                .next(u -> signIn(stay, user))
                .subscribe();
    }
}