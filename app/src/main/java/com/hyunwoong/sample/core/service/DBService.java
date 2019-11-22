package com.hyunwoong.sample.core.service;

import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.base.Dao;
import com.hyunwoong.sample.base.Dto;
import com.hyunwoong.sample.base.Service;
import com.hyunwoong.sample.core.model.UserDao;
import com.hyunwoong.sample.core.model.UserDto;
import com.hyunwoong.sample.util.Cache;

/**
 * @author : Hyunwoong
 * @when : 2019-11-22 오후 2:52
 * @homepage : https://github.com/gusdnd852
 */
@SuppressWarnings("unchecked")
public class DBService extends Service {

    private final static String daoPackage = UserDao.class.getPackage().getName();
    private final static String dtoPackage = UserDto.class.getPackage().getName();
    private static DBService instance;

    public synchronized static DBService getInstance(Controller controller) {
        if (instance == null)
            instance = new DBService(controller);
        return instance;
    }

    private DBService(Controller owner) {
        super(owner);
    }

    private <T extends Dto> Dao<T> singleton(Class<T> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = clazz.getName().replaceAll(dtoPackage, daoPackage) + "Dao";
        if (!Cache.dao.containsKey(className)) {
            Dao<T> dao = (Dao<T>) Class.forName(className).newInstance();
            Cache.setDao(dao, className);
        }
        return Cache.dao.get(className);
    }

    public <T extends Dto> Dao<T> of(Class<T> clazz) {
        try {
            return singleton(clazz);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}
