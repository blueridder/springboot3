package com.ywyt.springboot3.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 主要用来做统计
 * @author xiejin
 * @date 2019/9/7 17:33
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("============requestDestroyed================");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("============requestInitialized================");
    }
}
