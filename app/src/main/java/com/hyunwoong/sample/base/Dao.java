package com.hyunwoong.sample.base;

import androidx.core.util.Consumer;

import java.io.Serializable;

/**
 * @author : Hyunwoong
 * @when : 2019-11-22 오후 12:14
 * @homepage : https://github.com/gusdnd852
 */
public abstract class Dao<T> implements Serializable, Cloneable {
// Data Access Object

    public abstract void select(Consumer<T> getter, boolean cache);

    public abstract void insert(T t);

    protected abstract void delete();

}