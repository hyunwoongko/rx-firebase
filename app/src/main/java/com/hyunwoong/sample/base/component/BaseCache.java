package com.hyunwoong.sample.base.component;

import lombok.Data;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
@Data
public abstract class BaseCache<E extends BaseEntity> {
    protected E data;
}