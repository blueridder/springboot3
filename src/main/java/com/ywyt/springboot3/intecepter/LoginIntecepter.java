package com.ywyt.springboot3.intecepter;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiejin
 * @date 2019/9/7 18:03
 */
public class LoginIntecepter implements HandlerInterceptor {

    /**
     * 进入controller方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //数据校验，通过request和response去数据拿数据
        //登录的时候可以校验是否已登录
        System.out.println("LoginIntecepter====>preHandle");
//        String token = request.getParameter("access_token");
//        response.getWriter().print("fail");
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    /**
     * 调用完controller方法之后，视图渲染之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntecepter====>postHandle");
    }

    /**
     * 整个完成之后，通常用于资源清理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("LoginIntecepter====>afterCompletion");
    }
}
