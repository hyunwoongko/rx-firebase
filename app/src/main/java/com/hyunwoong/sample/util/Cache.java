package com.hyunwoong.sample.util;

import com.hyunwoong.sample.base.Dao;
import com.hyunwoong.sample.core.model.UserDto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
@SuppressWarnings("unchecked")
public class Cache {
    public static Map<String, Dao> dao = new ConcurrentHashMap<>();
    public static UserDto user = new UserDto();

    public static <T> Dao<T> getDao(Class<T> clazz, String key) {
        return (Dao<T>) dao.get(key);
    }

    public static <T> void setDao(Dao<T> target, String key) {
        dao.put(key, target);
    }
}
