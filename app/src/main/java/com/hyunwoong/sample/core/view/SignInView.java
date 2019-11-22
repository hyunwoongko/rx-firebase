package com.hyunwoong.sample.core.view;

import com.hyunwoong.sample.base.View;
import com.hyunwoong.sample.util.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:14
 * @homepage : https://github.com/gusdnd852
 */
public class SignInView extends View {
    public Data<String> id = new Data<>();
    public Data<String> pw = new Data<>();
    public Data<Boolean> stay = new Data<>(false);

}
