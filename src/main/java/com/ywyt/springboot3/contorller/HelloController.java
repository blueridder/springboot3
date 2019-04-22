package com.ywyt.springboot3.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Response;

/**
 * @author xiejin
 * @date 2019/4/22 14:01
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index")
    public ResponseEntity<String> hello() {
        String as = "hello";
        return new ResponseEntity<String>(as, HttpStatus.OK);
    }
}
