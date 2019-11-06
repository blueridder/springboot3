package com.ywyt.springboot3.service.impl;

import com.ywyt.springboot3.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author xiejin
 * @date 2019/9/13 23:00
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;  //用来发送消息到broker

    /**
     * 发送消息，destination是发送到的队列，message是待发送的消息
     * @param destination
     * @param msg
     */
    @Override
    public void sendMessage(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination, msg);

    }

    @Override
    public void sendMessage(String msg) {
        jmsMessagingTemplate.convertAndSend(msg);
    }

    @Override
    public void publish(String msg) {
        jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
