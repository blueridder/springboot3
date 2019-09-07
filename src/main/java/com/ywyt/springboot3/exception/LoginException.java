package com.ywyt.springboot3.exception;

/**
 * @author xiejin
 * @date 2019/9/7 15:27
 */
public class LoginException extends RuntimeException{

    private String username;
    private String pwd;
    private String code;
    private String msg;

    public LoginException(String username, String code, String msg) {
        this.username = username;
        this.code = code;
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
