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

    public Data<String> getId() {
        return id;
    }

    public void setId(Data<String> id) {
        this.id = id;
    }

    public Data<String> getPw() {
        return pw;
    }

    public void setPw(Data<String> pw) {
        this.pw = pw;
    }

    public Data<String> getName() {
        return name;
    }

    public void setName(Data<String> name) {
        this.name = name;
    }
}
