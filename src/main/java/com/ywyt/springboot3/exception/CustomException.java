package com.ywyt.springboot3.exception;

/**
 * @author xiejin
 * @date 2019/9/7 11:26
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomException {

    private static final Logger logger = LoggerFactory.getLogger(CustomNumberEditor.class);

    @ExceptionHandler(value = Exception.class)
    public Object handlerException(Exception e, HttpServletRequest request) {
        logger.error(request.getRequestURL().toString(),e.getCause());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 100);
        resultMap.put("msg", e.getCause());
        resultMap.put("url", request.getRequestURL());
        return resultMap;
    }

    @ExceptionHandler(value = MyException.class)
    public Object handlerMyException(MyException e) {
        logger.error(e.getMsg());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error.html");
        mv.addObject("code", e.getCode());
        mv.addObject("msg", e.getMsg());
        return mv;
    }


    @ExceptionHandler(value = LoginException.class)
    public Object handlerLoginException(LoginException e) {
        logger.error(e.getMsg());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error.html");
        mv.addObject("code", e.getCode());
        mv.addObject("msg", e.getMsg());
        return mv;
    }

}
