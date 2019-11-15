package com.hyunwoong.sample.core.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/gusdnd852
 */
public class SignInViewModel extends ViewModel {
    private MutableLiveData<String> id;
    private MutableLiveData<String> pw;

    public String getId() {
        return id.getValue();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public String getPw() {
        return pw.getValue();
    }

    public void setPw(String pw) {
        this.pw.setValue(pw);
    }
}
