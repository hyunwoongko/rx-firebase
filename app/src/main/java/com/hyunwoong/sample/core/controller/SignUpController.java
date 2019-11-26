package com.hyunwoong.sample.core.controller;

import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.core.view.SignUpView;
import com.hyunwoong.sample.databinding.SignUpBinding;
import com.hyunwoong.sample.util.data.RxFirebase;
import com.hyunwoong.sample.util.others.Strings;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 12:51
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpController extends Controller<SignUpBinding, SignUpView> {

    public boolean check(User user) {
        if (Strings.empty(user.getId())) return hideAndToast("아이디를 입력해주세요.");
        else if (Strings.empty(user.getPw())) return hideAndToast("비밀번호를 입력해주세요.");
        else if (user.getPw().length() < 6) return hideAndToast("비밀번호는 6자 이상이여야 합니다.");
        else if (Strings.empty(user.getName())) return hideAndToast("이름을 입력해주세요.");
        else return true;
    }

    public void storeUserInformation(User user) {
        RxFirebase.from("user")
                .child(Strings.key(user.getId()))
                .access(User.class)
                .upload(user);
    }

    public void signUp(User user) {
        this.showProgress();
        RxFirebase.signUp()
                .success(this::storeUserInformation)
                .success(u -> hideAndToast("회원가입에 성공했습니다."))
                .success(u -> moveAndFinish(SignInController.class))
                .fail(u -> hideAndToast("회원가입에 실패했습니다."))
                .subscribe(user);
    }

}
