package com.ywyt.springboot3.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 资源加载，例如redis，mysql，缓存数据等加载
 * @author xiejin
 * @date 2019/9/7 17:41
 */
@WebListener
public class CustomContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("===================contextInitialized========================");
        //这里可以做一个非阻塞的线程来加载
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("===================contextDestroyed========================");
    }
}
