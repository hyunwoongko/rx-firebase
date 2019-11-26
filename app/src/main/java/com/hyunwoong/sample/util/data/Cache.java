package com.hyunwoong.sample.util.data;

import com.hyunwoong.sample.core.model.User;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 7:23
 * @homepage : https://github.com/gusdnd852
 */
@SuppressWarnings("unchecked")
public class Cache {
    private static User user = new User();

    public static void copyUser(User user) {
        Cache.user = user;
    }

    public static User readUser() {
        return Cache.user;
    }
}
