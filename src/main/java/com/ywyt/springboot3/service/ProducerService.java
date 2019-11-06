package com.ywyt.springboot3.service;

import javax.jms.Destination;

/**
 * @author xiejin
 * @date 2019/9/13 22:57
 */
public interface ProducerService {
    /**
     * 执行消息队列还有消息
     * @param destination
     * @param msg
     */
    void sendMessage(Destination destination, final String msg);

    /**
     * 使用默认消息队列，发送消息
     * @param msg
     */
    void sendMessage(final String msg);

    void publish(String msg);
}
