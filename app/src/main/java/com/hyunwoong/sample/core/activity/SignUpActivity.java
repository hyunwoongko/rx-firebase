package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.component.BaseActivity;
import com.hyunwoong.sample.core.task.SignInTask;
import com.hyunwoong.sample.core.task.SignUpTask;
import com.hyunwoong.sample.core.viewmodel.SignUpViewModel;
import com.hyunwoong.sample.data.entity.UserEntity;
import com.hyunwoong.sample.databinding.SignUpView;
import com.hyunwoong.sample.di.TaskFactory;
import com.hyunwoong.sample.util.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 12:51
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpActivity extends BaseActivity<SignUpView, SignUpViewModel> {

    private SignUpTask signUpTask = TaskFactory.createTask(this, SignUpTask.class);

    @Override protected int injectView() {
        return R.layout.signup_view;
    }

    @Override protected Class<SignUpViewModel> injectViewModel() {
        return SignUpViewModel.class;
    }

    @OnXML(resid = R.layout.signup_view)
    public void signUp() {
        UserEntity user = new UserEntity();
        user.setId(viewModel.getId());
        user.setPw(viewModel.getPw());
        user.setName(viewModel.getName());

        signUpTask.signUp(user);
    }
}
