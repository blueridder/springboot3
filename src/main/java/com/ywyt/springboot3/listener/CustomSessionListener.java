package com.ywyt.springboot3.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author xiejin
 * @date 2019/9/7 17:47
 */
@WebListener
public class CustomSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("===============sessionCreated=======================");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("===============sessionDestroyed=======================");
    }
}
