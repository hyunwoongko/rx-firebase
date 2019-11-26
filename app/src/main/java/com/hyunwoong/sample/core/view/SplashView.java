package com.hyunwoong.sample.core.view;

import com.hyunwoong.sample.R;
import com.hyunwoong.sample.base.View;
import com.hyunwoong.sample.core.controller.SplashController;
import com.hyunwoong.sample.util.view.OnXML;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 12:08
 * @homepage : https://github.com/gusdnd852
 */
public class SplashView extends View {

    @OnXML(resid = R.layout.splash)
    public void splash(SplashController ctrl) {
        if (ctrl.isRemembered()) ctrl.autonomousSignIn();
        else ctrl.delayAndMove(2500);
    }
}