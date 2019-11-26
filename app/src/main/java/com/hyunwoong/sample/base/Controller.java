package com.hyunwoong.sample.base;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;

import com.hyunwoong.sample.BR;
import com.hyunwoong.sample.R;
import com.hyunwoong.sample.util.data.Preference;

import java.lang.reflect.ParameterizedType;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 3:42
 * @homepage : https://github.com/gusdnd852
 */
@SuppressWarnings("unchecked")
public abstract class Controller<B extends ViewDataBinding, V extends View> extends AppCompatActivity {

    protected B binding;
    protected V view;
    protected Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, readXml());
        view = createView();
        binding.setLifecycleOwner(this);
        binding.setVariable(BR.view, view);
        binding.setVariable(BR.controller, this);
    }

    private int readXml() {
        try {
            ActivityInfo activityInfo = getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);

            Bundle metaData = activityInfo.metaData;
            String fileName = metaData.getString("layout");
            String simpleName = fileName.split("/")[2].split("\\.")[0];
            return getResources().getIdentifier(simpleName, "layout", getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    private V createView() {
        try {
            String className = ((ParameterizedType) getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[1]
                    .toString()
                    .split(" ")[1];

            Class<V> clazz = (Class<V>) Class.forName(className);
            NewInstanceFactory factory = new NewInstanceFactory();
            return new ViewModelProvider(this, factory).get(clazz);
        } catch (Exception e) {
            return null;
        }
    }

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

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void move(Class<? extends android.app.Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    public void moveAndFinish(Class<? extends android.app.Activity> activity) {
        move(activity);
        finish();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void dialog(String title, String msg, Runnable positive) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("확인", (dialog, which) -> positive.run())
                .setNegativeButton("취소", (dialog, which) -> {
                })
                .setCancelable(false)
                .create()
                .show();
    }

    public void showProgress() {
        view.showProgress();
    }

    public void hideProgress() {
        view.hideProgress();
    }

    public boolean hideAndToast(String msg) {
        hideProgress();
        toast(msg);
        return false;
    }
}
