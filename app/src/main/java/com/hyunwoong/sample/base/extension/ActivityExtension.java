package com.hyunwoong.sample.base.extension;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.hyunwoong.sample.R;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:11
 * @homepage : https://github.com/gusdnd852
 */
public abstract class ActivityExtension extends AppCompatActivity {
    protected void getPermission(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    public void startActivityAndFinish(Class<? extends Activity> activity) {
        startActivity(activity);
        finish();
    }
}
