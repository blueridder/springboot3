package com.ywyt.springboot3.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 订阅/发布模型
 * @author xiejin
 * @date 2019/9/14 10:29
 */
@Component
public class TopicSub {

    @JmsListener(destination = "notify.topic",containerFactory = "jmsListenerContainerTopic")
    public void subCommon1(String msg) {
        System.out.println("TopicSub1收到的报文："+msg);
    }



    //这里可以是订单系统
    @JmsListener(destination = "notify.topic",containerFactory = "jmsListenerContainerTopic")
    public void subCommon2(String msg) {
        System.out.println("TopicSub2收到的报文："+msg);
    }



    //这里可以是积分系统
    @JmsListener(destination = "notify.topic",containerFactory = "jmsListenerContainerTopic")
    public void subCommon3(String msg) {
        System.out.println("TopicSub3收到的报文："+msg);
    }
}
