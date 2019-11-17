package com.hyunwoong.sample.base.component;


/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
public abstract class BaseCache<E extends BaseEntity> {
    protected E data;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}