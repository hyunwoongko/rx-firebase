package com.hyunwoong.sample.di;

import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.base.task.BaseTask;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:54
 * @homepage : https://github.com/gusdnd852
 */
public class TaskFactory {

    public static <T extends BaseTask> T createTask(BaseActivity owner, Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor(BaseActivity.class)
                    .newInstance(owner);

        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
