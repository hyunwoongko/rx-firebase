package com.hyunwoong.sample.core.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.base.task.BaseTask;
import com.hyunwoong.sample.core.activity.SignInActivity;
import com.hyunwoong.sample.core.model.entity.UserEntity;
import com.hyunwoong.sample.util.Firebase;
import com.hyunwoong.sample.util.StringChecker;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 1:07
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpTask extends BaseTask {

    public SignUpTask(BaseActivity owner) {
        super(owner);
    }

    private void insertDatabase(Task<AuthResult> task, UserEntity user) {
        if (task.isSuccessful()) {
            Firebase.reference("user")
                    .child(Firebase.uid())
                    .access(UserEntity.class)
                    .insert(user);
        }
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            toast("회원가입에 성공했습니다.");
            moveAndFinish(SignInActivity.class);
        } else {
            toast("회원가입에 실패했습니다.");
        }
    }

    public void signUp(UserEntity user) {
        String id = user.getId();
        String pw = user.getPw();
        String name = user.getName();
        showProgress();

        if (StringChecker.isEmpty(id))
            hideAndToast("이이디를 입력해주세요");
        else if (StringChecker.isEmpty(pw))
            hideAndToast("비밀번호를 입력해주세요");
        else if (StringChecker.isShort(pw, 6))
            hideAndToast("비밀번호는 최소 6자 이상입니다");
        else if (StringChecker.isEmpty(name))
            hideAndToast("이름을 입력해주세요");

        else Firebase.auth()
                    .createUserWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(task -> {
                        insertDatabase(task, user);// 1. Insert Database
                        updateView(task); // 2. Update View
                    });
    }
}
