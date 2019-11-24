package com.hyunwoong.sample.core.service;

import com.hyunwoong.sample.base.Controller;
import com.hyunwoong.sample.base.Service;
import com.hyunwoong.sample.core.model.UserDto;

/**
 * @author : Hyunwoong
 * @when : 2019-11-22 오후 12:27
 * @homepage : https://github.com/gusdnd852
 */
public class CheckService extends Service {
    private int minPw = 6;

    public CheckService(Controller owner) {
        super(owner);
    }

    public enum Component {
        id, pw, name
    }

    public boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    public boolean isShort(String str, int min) {
        return str.length() < min;
    }

    public boolean isOk(UserDto user, Component... components) {
        for (Component component : components) {
            if (component.equals(Component.id) && isEmpty(user.getId())) {
                hideAndToast(" 아이디를 입력해주세요.");
                return false;
            }
            if (component.equals(Component.pw) && isEmpty(user.getPw())) {
                hideAndToast(" 비밀번호를 입력해주세요.");
                return false;
            }
            if (component.equals(Component.pw) && isShort(user.getPw(), minPw)) {
                hideAndToast(" 비밀번호는 최소 " + minPw + "자 이상이여야 합니다.");
                return false;
            }
            if (component.equals(Component.name) && isEmpty(user.getName())) {
                hideAndToast(" 이름을 입력해주세요.");
                return false;
            }
        }

        return true;
    }
}
