package com.ywyt.springboot3.filter;

import com.ywyt.springboot3.exception.LoginException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiejin
 * @date 2019/9/7 15:02
 */
@WebFilter(urlPatterns = "/access/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException,LoginException {
        System.out.println("doFilter loginFilter");

        //获取前端传来的参数，并在数据库或者其它地方进行验证
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //验证的内容
        String username = request.getParameter("username");
        if (username.equals("admin")) {
            //验证通过dofilter
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //请求重定向
//            request.setAttribute("username",username);
//            response.sendRedirect("/error/login?username="+username);
            //请求转发
            request.setAttribute("username",username);
            request.getRequestDispatcher("/error/login").forward(request,response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }
}
