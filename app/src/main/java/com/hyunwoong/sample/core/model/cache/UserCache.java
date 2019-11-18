package com.hyunwoong.sample.core.model.cache;

import com.hyunwoong.sample.base.model.BaseCache;
import com.hyunwoong.sample.core.model.entity.UserEntity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
public class UserCache extends BaseCache<UserEntity> {

    public static UserCache getInstance() {
        return LazyHolder.instance;
    }

    static class LazyHolder {
        static UserCache instance = new UserCache();
    }
}
