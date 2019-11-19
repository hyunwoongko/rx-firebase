package com.hyunwoong.sample.core.task;

import android.os.Handler;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.base.task.BaseTask;
import com.hyunwoong.sample.core.activity.MainActivity;
import com.hyunwoong.sample.core.activity.SignInActivity;
import com.hyunwoong.sample.core.model.cache.UserCache;
import com.hyunwoong.sample.core.model.entity.UserEntity;
import com.hyunwoong.sample.util.Firebase;
import com.hyunwoong.sample.util.StringChecker;


/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashTask extends BaseTask {

    public SplashTask(BaseActivity owner) {
        super(owner);
    }

    private void moveScreen() {
        new Handler().postDelayed(() ->
                moveAndFinish(SignInActivity.class), 2500);
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            moveAndFinish(MainActivity.class);
        } else {
            toast("로그인에 실패했습니다.");
        }
    }

    private void processAutonomousSignIn() {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(UserEntity.class)
                .select(u -> {
                    UserCache.getInstance().copy(u); // copy to cache
                    Firebase.auth() // autonomous signed in
                            .signInWithEmailAndPassword(u.getId(), u.getPw())
                            .addOnCompleteListener(this::updateView);
                });
    }

    public void splash() {
        String remembered = preference().getString("id");

        if (StringChecker.isEmpty(remembered)) moveScreen();
        else processAutonomousSignIn();
    }
}
