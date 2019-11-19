package com.hyunwoong.sample.core.viewmodel;

import com.hyunwoong.sample.base.viwemodel.BaseViewModel;
import com.hyunwoong.sample.util.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 2:01
 * @homepage : https://github.com/gusdnd852
 */
public class MainViewModel extends BaseViewModel {

    private Data<String> id = new Data<>();
    private Data<String> pw = new Data<>();
    private Data<String> name = new Data<>();

    public Data<String> getId() {
        return id;
    }

    public Data<String> getPw() {
        return pw;
    }

    public Data<String> getName() {
        return name;
    }
}
