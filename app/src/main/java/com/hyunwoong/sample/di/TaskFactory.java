package com.hyunwoong.sample.di;

import com.hyunwoong.sample.base.component.BaseActivity;
import com.hyunwoong.sample.base.component.BaseTask;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:54
 * @homepage : https://github.com/gusdnd852
 */
public class TaskFactory {

    public static <T extends BaseTask> T createTask(BaseActivity owner, Class<T> clazz) {
        try {
            System.out.println(clazz);
            return BaseTask.builder()
                    .setToast(owner::toast)
                    .setDialog(owner::dialog)
                    .setMove(owner::startActivity)
                    .setMoveAndFinish(owner::startActivityAndFinish)
                    .setFinish(owner::finish)
                    .build(clazz);

        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
