package com.hyunwoong.sample.core.viewmodel;

import com.hyunwoong.sample.base.viwemodel.BaseViewModel;
import com.hyunwoong.sample.util.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/gusdnd852
 */
public class SignInViewModel extends BaseViewModel {
    private Data<String> id = new Data<>();
    private Data<String> pw = new Data<>();

    public String getId() {
        return id.getValue();
    }

    public String getPw() {
        return pw.getValue();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public void setPw(String pw) {
        this.pw.setValue(pw);
    }
}
