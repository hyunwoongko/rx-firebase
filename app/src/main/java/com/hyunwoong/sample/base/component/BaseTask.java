package com.hyunwoong.sample.base.component;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:12
 * @homepage : https://github.com/gusdnd852
 */

public abstract class BaseTask {

    protected ToastNavigator toast;
    protected DialogNavigator dialog;
    protected MoveNavigator move;
    protected MoveNavigator moveAndFinish;
    protected FinishNavigator finish;

    public BaseTask(TaskBuilder builder) {
        this.toast = builder.toast;
        this.dialog = builder.dialog;
        this.move = builder.move;
        this.moveAndFinish = builder.moveAndFinish;
        this.finish = builder.finish;
    }

    public static TaskBuilder builder() {
        return new TaskBuilder();
    }

    public static class TaskBuilder {

        private ToastNavigator toast;
        private DialogNavigator dialog;
        private MoveNavigator move;
        private MoveNavigator moveAndFinish;
        private FinishNavigator finish;

        public TaskBuilder setToast(ToastNavigator toast) {
            this.toast = toast;
            return this;
        }

        public TaskBuilder setDialog(DialogNavigator dialog) {
            this.dialog = dialog;
            return this;
        }

        public TaskBuilder setMove(MoveNavigator move) {
            this.move = move;
            return this;
        }

        public TaskBuilder setMoveAndFinish(MoveNavigator moveAndFinish) {
            this.moveAndFinish = moveAndFinish;
            return this;
        }

        public TaskBuilder setFinish(FinishNavigator finish) {
            this.finish = finish;
            return this;
        }

        public <T extends BaseTask> T build(Class<T> clazz)
                throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return clazz.getDeclaredConstructor(TaskBuilder.class).newInstance(this);
        }
    }

    @FunctionalInterface
    public interface ToastNavigator {
        void show(String msg);
    }

    @FunctionalInterface
    public interface DialogNavigator {
        void show(String title, String msg, Runnable action);
    }

    @FunctionalInterface
    public interface MoveNavigator {
        void move(Class<? extends BaseActivity> clazz);
    }

    @FunctionalInterface
    public interface FinishNavigator {
        void finish();
    }
}
