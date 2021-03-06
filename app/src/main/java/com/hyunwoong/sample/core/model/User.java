package com.hyunwoong.sample.core.model;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:13
 * @homepage : https://github.com/gusdnd852
 */
public class User {
    private String id;
    private String pw;
    private String name;

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }
}
