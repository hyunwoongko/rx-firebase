package com.hyunwoong.sample.base.activity;

import android.app.Activity;
import android.content.Intent;

import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.viwemodel.BaseViewModel;
import com.hyunwoong.sample.util.Preference;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 3:44
 * @homepage : https://github.com/gusdnd852
 */
public abstract class ExtendedActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends MVVMActivity<V, VM> {

    public void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    public Preference preference() {
        return Preference.getInstance(this);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    public void startActivityAndFinish(Class<? extends Activity> activity) {
        startActivity(activity);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }
}
