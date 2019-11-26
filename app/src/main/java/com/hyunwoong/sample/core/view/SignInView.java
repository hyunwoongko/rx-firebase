package com.hyunwoong.sample.core.view;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.View;
import com.hyunwoong.sample.core.controller.SignInController;
import com.hyunwoong.sample.core.controller.SignUpController;
import com.hyunwoong.sample.core.dto.User;
import com.hyunwoong.sample.util.data.Data;
import com.hyunwoong.sample.util.view.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/gusdnd852
 */
public class SignInView extends View {
    public Data<String> id = new Data<>();
    public Data<String> pw = new Data<>();
    public Data<Boolean> stay = new Data<>(false);

    @OnXML(resid = R.layout.sign_in)
    public void signIn(SignInController ctrl) {
        User user = new User();
        user.setId(id.get());
        user.setPw(pw.get());

        if (ctrl.check(user)){
            this.showProgress();
            ctrl.cachedSignIn(stay.get(), user);
        }
    }

    @OnXML(resid = R.layout.sign_in)
    public void moveToSignUp(SignInController ctrl) {
        ctrl.move(SignUpController.class);
    }
}
