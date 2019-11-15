package com.hyunwoong.sample.base.extension;

import android.app.AlertDialog;
import android.widget.Toast;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:11
 * @homepage : https://github.com/gusdnd852
 */
public abstract class UIExtension extends ActivityExtension {

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
}
