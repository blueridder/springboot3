package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author xiejin
 * @date 2019/9/13 23:15
 */
@RestController
@RequestMapping(value = "vedio")
public class VedioController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "send")
    public ResponseEntity<String> vedio(String content) {
        Destination destination = new ActiveMQQueue("vedio.queue");
        producerService.sendMessage(destination, content);
        return new ResponseEntity<String>(content, HttpStatus.OK);
    }

    @RequestMapping(value = "common")
    public ResponseEntity<String> common(String msg) {
        producerService.publish(msg);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

}
