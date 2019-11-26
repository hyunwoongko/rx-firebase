package com.hyunwoong.sample.core.viewmodel;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.BaseViewModel;
import com.hyunwoong.sample.core.activity.SignInActivity;
import com.hyunwoong.sample.core.activity.SignUpActivity;
import com.hyunwoong.sample.core.model.User;
import com.hyunwoong.sample.util.data.Data;
import com.hyunwoong.sample.util.view.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/gusdnd852
 */
public class SignInViewModel extends BaseViewModel {
    public Data<String> id = new Data<>();
    public Data<String> pw = new Data<>();
    public Data<Boolean> stay = new Data<>(false);

    @OnXML(resid = R.layout.sign_in)
    public void signIn(SignInActivity activity) {
        User user = new User();
        user.setId(id.get());
        user.setPw(pw.get());

        if (activity.check(user))
            activity.cachedSignIn(stay.get(), user);
    }

    @OnXML(resid = R.layout.sign_in)
    public void moveToSignUp(SignInActivity activity) {
        activity.move(SignUpActivity.class);
    }
}
