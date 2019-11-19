package com.hyunwoong.sample.core.activity;

import android.view.View;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.core.model.entity.UserEntity;
import com.hyunwoong.sample.core.task.SignInTask;
import com.hyunwoong.sample.core.viewmodel.SignInViewModel;
import com.hyunwoong.sample.databinding.SignInView;
import com.hyunwoong.sample.di.TaskFactory;
import com.hyunwoong.sample.util.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */
public class SignInActivity extends BaseActivity<SignInView, SignInViewModel> {

    private SignInTask signInTask = TaskFactory.createTask(this, SignInTask.class);

    @Override
    protected int injectView() {
        return R.layout.signin_view;
    }

    @Override
    protected Class<SignInViewModel> injectViewModel() {
        return SignInViewModel.class;
    }

    @OnXML(resid = R.layout.signin_view)
    public void signIn() {
        UserEntity user = new UserEntity();
        user.setId(viewModel.getId().getValue());
        user.setPw(viewModel.getPw().getValue());

        signInTask.signIn(user, viewModel.getStay());
    }

    @OnXML(resid = R.layout.signin_view)
    public void moveToSignUp() {
        startActivity(SignUpActivity.class);
    }
}
