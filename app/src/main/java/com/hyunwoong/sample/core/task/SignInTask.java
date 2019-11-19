package com.hyunwoong.sample.core.task;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.base.task.BaseTask;
import com.hyunwoong.sample.core.activity.MainActivity;
import com.hyunwoong.sample.core.model.cache.UserCache;
import com.hyunwoong.sample.core.model.entity.UserEntity;
import com.hyunwoong.sample.util.Data;
import com.hyunwoong.sample.util.Firebase;
import com.hyunwoong.sample.util.StringChecker;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/tgusdnd852
 */
public class SignInTask extends BaseTask {

    public SignInTask(BaseActivity owner) {
        super(owner);
    }

    private void staySignedIn(Task<AuthResult> task, UserEntity user, Data<Boolean> stay) {
        if (task.isSuccessful()) {
            if (stay.getValue()) {
                preference().setString("id", user.getId());
                preference().setString("pw", user.getPw());
            } else {
                preference().setString("id", null);
                preference().setString("pw", null);
            }
        }
    }

    private void addEntityToCache(Task<AuthResult> task, UserEntity user) {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(UserEntity.class)
                .select(u -> {
                    UserCache.getInstance().copy(u);
                    updateView(task);
                });
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            moveAndFinish(MainActivity.class);
        } else {
            toast("로그인에 실패했습니다.");
        }
    }

    public void signIn(UserEntity user, Data<Boolean> stay) {
        String id = user.getId();
        String pw = user.getPw();
        showProgress();

        if (StringChecker.isEmpty(id))
            hideAndToast("아이디를 입력해주세요");
        else if (StringChecker.isEmpty(pw))
            hideAndToast("비밀번호를 입력해주세요");

        else Firebase.auth()
                    .signInWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(task -> {
                        staySignedIn(task, user, stay); // 1. Stay Processing
                        addEntityToCache(task, user); // 2. Add Entity To Cache
                    });
    }
}
