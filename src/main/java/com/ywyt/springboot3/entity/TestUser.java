package com.ywyt.springboot3.entity;

/**
 * @author xiejin
 * @date 2019/9/8 12:33
 */
public class TestUser {

    private Integer id ;
    private String name ;
    private String roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "TestUserMapper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleid='" + roleid + '\'' +
                '}';
    }
}
