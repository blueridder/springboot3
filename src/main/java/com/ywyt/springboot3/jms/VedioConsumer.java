package com.ywyt.springboot3.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author xiejin
 * @date 2019/9/13 23:04
 */
@Component
public class VedioConsumer {

    @JmsListener(destination = "vedio.queue")
    public void receiveQueue(String msg) {
        System.out.println("VedioConsumer收到的内容为："+msg);
    }
}
