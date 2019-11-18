package com.hyunwoong.sample.util;

import androidx.lifecycle.MutableLiveData;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 2:00
 * @homepage : https://github.com/gusdnd852
 */
public class Data<T> extends MutableLiveData<T> {

    public Data() {
    }

    public Data(T t) {
        setValue(t);
    }
}
