package com.example.springboot04.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session中获取用户信息
        Object user = request.getSession().getAttribute("user");
        //request.getSession().removeAttribute("user");

        if( user == null){
            request.setAttribute("msg","没有权限请先登陆");
            //request.getRequestDispatcher("/").forward(request,response);
            request.getRequestDispatcher("/").forward(request,response);
            System.err.println("?????????");
            return false;
        }else{
            return true;
        }

    }




    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
