package com.hyunwoong.sample.core.model;

import androidx.core.util.Consumer;

import com.hyunwoong.sample.base.Dao;
import com.hyunwoong.sample.util.Cache;
import com.hyunwoong.sample.util.Firebase;

/**
 * @author : Hyunwoong
 * @when : 2019-11-22 오후 12:09
 * @homepage : https://github.com/gusdnd852
 */
public class UserDao extends Dao<UserDto> {

    public void select(Consumer<UserDto> after, boolean cache) {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(UserDto.class)
                .select(user -> {
                    if (cache) Cache.user = user;
                    after.accept(user);
                });
    }

    public void insert(UserDto user) {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(UserDto.class)
                .insert(user);
    }

    public void delete() {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(UserDto.class)
                .delete();
    }
}
