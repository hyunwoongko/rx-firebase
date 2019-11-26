package com.hyunwoong.sample.base;

import com.hyunwoong.sample.core.dao.UserDao;
import com.hyunwoong.sample.core.dto.User;
import com.hyunwoong.sample.util.data.Cache;
import com.hyunwoong.sample.util.data.Firebase;

/**
 * @author : Hyunwoong
 * @when : 2019-11-25 오후 7:02
 * @homepage : https://github.com/gusdnd852
 */

public abstract class Dao<T> {

    public abstract Firebase.Publisher<T> select(String key);

    public abstract void insert(T t);

    public abstract void delete(String key);

    public static String key(String id) {
        return id.replaceAll("\\.", "")
                .replaceAll(" ", "");
    }

    @SuppressWarnings("unchecked")
    public static <T extends Entity> Dao<T> of(Class<T> clazz) {
        try {
            final String daoPackage = UserDao.class.getPackage().getName();
            final String dtoPackage = User.class.getPackage().getName();

            String className = clazz.getName().replaceAll(dtoPackage, daoPackage) + "Dao";
            if (!Cache.readDao().containsKey(className)) {
                Dao<T> dao = (Dao<T>) Class.forName(className).newInstance();
                Cache.readDao().put(className, dao);
            }
            return (Dao<T>) Cache.readDao().get(className);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}
