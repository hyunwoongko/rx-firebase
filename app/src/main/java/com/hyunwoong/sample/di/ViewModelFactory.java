package com.hyunwoong.sample.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;

import com.hyunwoong.sample.base.activity.MVVMActivity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:20
 * @homepage : https://github.com/gusdnd852
 */

public class ViewModelFactory {

    public static <M extends ViewModel> M createViewModel(MVVMActivity owner, Class<M> clazz) {
        return new ViewModelProvider(owner, new NewInstanceFactory()).get(clazz);
    }
}
