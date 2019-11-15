package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.component.BaseActivity;
import com.hyunwoong.sample.core.task.SignInTask;
import com.hyunwoong.sample.core.viewmodel.SignInViewModel;
import com.hyunwoong.sample.data.entity.UserEntity;
import com.hyunwoong.sample.databinding.SignInView;
import com.hyunwoong.sample.di.TaskFactory;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */
public class SignInActivity extends BaseActivity<SignInView, SignInViewModel> {

    private SignInTask signInTask = TaskFactory.createTask(this, SignInTask.class);

    @Override
    protected int injectView() {
        return R.layout.view_signin;
    }

    @Override
    protected Class<SignInViewModel> injectViewModel() {
        return SignInViewModel.class;
    }

    public void signIn() {
        signInTask.signIn(UserEntity.builder()
                .id(viewModel.getId())
                .pw(viewModel.getPw())
                .build());
    }
}
