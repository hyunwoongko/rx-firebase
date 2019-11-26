package com.hyunwoong.sample.core.view;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.View;
import com.hyunwoong.sample.core.controller.SignUpController;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.util.data.Data;
import com.hyunwoong.sample.util.view.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 12:51
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpView extends View {
    public Data<String> id = new Data<>();
    public Data<String> pw = new Data<>();
    public Data<String> name = new Data<>();

    @OnXML(resid = R.layout.sign_up)
    public void signUp(SignUpController ctrl) {
        User user = new User();
        user.setId(id.get());
        user.setPw(pw.get());
        user.setName(name.get());

        if (ctrl.check(user)) {
            this.showProgress();
            ctrl.signUp(user);
        }
    }

}
