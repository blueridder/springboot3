package com.ywyt.springboot3.utils;

/**
 * @author xiejin
 * @date 2019/4/23 14:34
 */
public class JsonResult {

    private String status = null;
    private Object result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
