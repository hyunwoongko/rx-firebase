package com.hyunwoong.sample.data.cache;

import com.hyunwoong.sample.base.component.BaseCache;
import com.hyunwoong.sample.data.entity.UserEntity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
public class UserCache extends BaseCache<UserEntity> {

    public static UserCache getInstance() {
        return LazyHolder.instance;
    }

    @Override protected Class<UserEntity> injectModel() {
        return UserEntity.class;
    }

    static class LazyHolder {
        static UserCache instance;
    }
}
