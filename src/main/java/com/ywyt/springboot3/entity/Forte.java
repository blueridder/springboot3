package com.ywyt.springboot3.entity;

import java.io.Serializable;

/**
 * @author xiejin
 * @date 2019/9/6 11:39
 */
public class Forte implements Serializable{
    private static final long serialVersionUID = -2913811054397570792L;
    private String name ;
    private Integer time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
