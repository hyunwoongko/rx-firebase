package com.hyunwoong.sample.core.viewmodel;

import com.hyunwoong.sample.base.viwemodel.BaseViewModel;
import com.hyunwoong.sample.util.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 12:51
 * @homepage : https://github.com/gusdnd852
 */
public class SignUpViewModel extends BaseViewModel {
    private Data<String> id = new Data<>();
    private Data<String> pw = new Data<>();
    private Data<String> name = new Data<>();

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
