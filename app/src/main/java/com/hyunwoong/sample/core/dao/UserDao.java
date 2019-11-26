package com.hyunwoong.sample.core.dao;

import com.hyunwoong.sample.base.Dao;
import com.hyunwoong.sample.core.dto.User;
import com.hyunwoong.sample.util.data.Firebase;

/**
 * @author : Hyunwoong
 * @when : 2019-11-25 오후 6:37
 * @homepage : https://github.com/gusdnd852
 */
public class UserDao extends Dao<User> {

    @Override public Firebase.Publisher<User> select(String key) {
        return Firebase.from("user")
                .child(key)
                .access(User.class);
    }

    @Override public void insert(User user) {
        Firebase.from("user")
                .child(key(user.getId()))
                .access(User.class)
                .upload(user);
    }

    @Override public void delete(String key) {
        Firebase.from("user")
                .child(key)
                .access(User.class)
                .upload(null);
    }
}
