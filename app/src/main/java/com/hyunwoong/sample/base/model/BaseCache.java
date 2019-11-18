package com.hyunwoong.sample.base.model;


/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
public abstract class BaseCache<E extends BaseEntity> {
    protected E data;

    public E read() {
        return data;
    }

    public void copy(E data) {
        this.data = data;
    }
}