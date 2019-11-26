package com.hyunwoong.sample.core.viewmodel;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.BaseViewModel;
import com.hyunwoong.sample.core.activity.SignUpActivity;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.util.data.Data;
import com.hyunwoong.sample.util.view.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 12:51
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpViewModel extends BaseViewModel {
    public Data<String> id = new Data<>();
    public Data<String> pw = new Data<>();
    public Data<String> name = new Data<>();

    @OnXML(resid = R.layout.sign_up)
    public void signUp(SignUpActivity activity) {
        User user = new User();
        user.setId(id.get());
        user.setPw(pw.get());
        user.setName(name.get());

        if (activity.check(user))
            activity.signUp(user);
    }
}
