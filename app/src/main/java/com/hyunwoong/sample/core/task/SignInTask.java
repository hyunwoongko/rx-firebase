package com.hyunwoong.sample.core.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hyunwoong.sample.base.component.BaseTask;
import com.hyunwoong.sample.core.activity.MainActivity;
import com.hyunwoong.sample.core.activity.SignInActivity;
import com.hyunwoong.sample.data.entity.UserEntity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/tgusdnd852
 */
public class SignInTask extends BaseTask {
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    public SignInTask(TaskBuilder builder) {
        super(builder);
    }

    private boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    private void updateView(Task<AuthResult> task) {
        if (task.isSuccessful()) {
            moveAndFinish.move(MainActivity.class);
        } else {
            toast.show("로그인에 실패했습니다.");
        }
    }

    public void signIn(UserEntity user) {
        String id = user.getId();
        String pw = user.getPw();

        if (isEmpty(id)) toast.show("이이디를 입력해주세요");
        else if (isEmpty(pw)) toast.show("비밀번호를 입력해주세요");
        else auth.signInWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(this::updateView);
    }
}
