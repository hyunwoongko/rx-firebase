package com.hyunwoong.sample.core.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.hyunwoong.sample.base.component.BaseTask;
import com.hyunwoong.sample.core.activity.SignInActivity;
import com.hyunwoong.sample.data.entity.UserEntity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 1:07
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpTask extends BaseTask {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    public SignUpTask(TaskBuilder builder) {
        super(builder);
    }

    private boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    private void insertDatabase(Task<AuthResult> task, UserEntity user) {
        if (task.isSuccessful()) {
            FirebaseDatabase.getInstance()
                    .getReference("user")
                    .child(auth.getUid())
                    .setValue(user);
        }
    }


    private void updateView(Task<AuthResult> task) {
        if (task.isSuccessful()) {
            toast.show("회원가입에 성공했습니다.");
            moveAndFinish.move(SignInActivity.class);
        } else {
            toast.show("회원가입에 실패했습니다.");
        }
    }

    public void signUp(UserEntity user) {
        String id = user.getId();
        String pw = user.getPw();
        String name = user.getName();

        if (isEmpty(id)) toast.show("이이디를 입력해주세요");
        else if (isEmpty(pw)) toast.show("비밀번호를 입력해주세요");
        else if (isEmpty(name)) toast.show("이름을 입력해주세요");

        else auth.createUserWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(task -> {
                        insertDatabase(task, user); // 1. Insert Data to Database
                        updateView(task); // 2. Update View
                    });
    }
}
