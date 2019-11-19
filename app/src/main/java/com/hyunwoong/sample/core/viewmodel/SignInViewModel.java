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
    private Data<Boolean> stay = new Data<>();

    public Data<String> getId() {
        return id;
    }

    public Data<String> getPw() {
        return pw;
    }

    public Data<Boolean> getStay() {
        return stay;
    }

    public void setId(Data<String> id) {
        this.id = id;
    }

    public void setPw(Data<String> pw) {
        this.pw = pw;
    }

    public void setStay(Data<Boolean> stay) {
        this.stay = stay;
    }
}
