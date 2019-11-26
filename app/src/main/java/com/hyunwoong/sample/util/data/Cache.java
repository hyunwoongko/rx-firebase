package com.hyunwoong.sample.util.data;

import com.hyunwoong.sample.base.Dao;
import com.hyunwoong.sample.core.dto.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
@SuppressWarnings("unchecked")
public class Cache {
    private static Map<String, Dao> dao = new ConcurrentHashMap<>();
    private static User user = new User();

    public static Map<String, Dao> readDao() {
        return Cache.dao;
    }

    public static void copyUser(User user) {
        Cache.user = user;
    }

    public static User readUser() {
        return Cache.user;
    }
}
