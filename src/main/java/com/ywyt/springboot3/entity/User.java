package com.ywyt.springboot3.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiejin
 * @date 2019/4/22 16:00
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private String userName;
    private Integer age;
    private Integer userId;
    //    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String headingPath;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getHeadingPath() {
        return headingPath;
    }

    public void setHeadingPath(String headingPath) {
        this.headingPath = headingPath;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", userId=" + userId +
                ", createtime=" + createtime +
                '}';
    }
}
