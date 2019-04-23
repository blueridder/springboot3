package com.ywyt.springboot3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xiejin
 * @date 2019/4/23 17:19
 */


@Aspect
@Component
public class LogAspectHandler {

    @Pointcut("execution(* com.ywyt.springboot3.contorller..*.*(..))")
    public void pointCut(){};
}
