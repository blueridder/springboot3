package com.ywyt.springboot3.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xiejin
 * @date 2019/9/6 11:37
 */
@Component
@ConfigurationProperties(prefix = "emp")
public class Emp {
    private String lastName;
    private Integer age;
    private Double salary;
    private Boolean boss;
    private Date birthday;
    private Map<String,Object> map;
    private List<String> list;
    private Forte forte;
    private List<Forte> forteList;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Forte getForte() {
        return forte;
    }

    public void setForte(Forte forte) {
        this.forte = forte;
    }

    public List<Forte> getForteList() {
        return forteList;
    }

    public void setForteList(List<Forte> forteList) {
        this.forteList = forteList;
    }
}
