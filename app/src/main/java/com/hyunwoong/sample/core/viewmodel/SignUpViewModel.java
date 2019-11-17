package com.hyunwoong.sample.core.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 12:51
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpViewModel extends ViewModel {
    private MutableLiveData<String> id = new MutableLiveData<>();
    private MutableLiveData<String> pw = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();

    public String getId() {
        return id.getValue();
    }

    public String getPw() {
        return pw.getValue();
    }

    public String getName() {
        return name.getValue();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public void setPw(String pw) {
        this.pw.setValue(pw);
    }

    public void setName(String name) {
        this.name.setValue(name);
    }
}
