package com.hyunwoong.sample.core.activity;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.component.BaseActivity;
import com.hyunwoong.sample.core.task.SignInTask;
import com.hyunwoong.sample.core.viewmodel.SignInViewModel;
import com.hyunwoong.sample.data.entity.UserEntity;
import com.hyunwoong.sample.databinding.SignInViewBinding;
import com.hyunwoong.sample.di.TaskFactory;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */
public class SignInActivity extends BaseActivity<SignInViewBinding, SignInViewModel> {

    private SignInTask signInTask = TaskFactory.createTask(this, SignInTask.class);

    @Override
    protected int injectView() {
        return R.layout.sign_in_view;
    }

    @Override
    protected Class<SignInViewModel> injectViewModel() {
        return SignInViewModel.class;
    }

    public void signIn() {
        UserEntity user = new UserEntity();
        user.setId(viewModel.getId());
        user.setPw(viewModel.getPw());

        signInTask.signIn(user);
    }
}
