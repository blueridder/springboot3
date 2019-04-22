package com.ywyt.springboot3.entity;

import java.io.Serializable;

/**
 * @author xiejin
 * @date 2019/4/22 16:00
 */
public class User implements Serializable {

    private String userName ;
    private Integer age ;
    private Integer userId ;

    private static final long serialVersionUID = 6799536921259923154L;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", userId=" + userId +
                '}';
    }
}
