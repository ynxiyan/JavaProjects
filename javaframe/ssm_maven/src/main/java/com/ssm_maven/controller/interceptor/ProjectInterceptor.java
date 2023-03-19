package com.ssm_maven.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: XIYAN
 * @Date: 2023/3/16 15:02
 * @注释:SpringMVC拦截器
 */
//声明该类为SpringMVC的容器bean
@Component
public class ProjectInterceptor implements HandlerInterceptor {
    /**
     * 原始方法调用前执行的操作
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //true表示放行原始操作、false表示终止原始操作
        System.out.println("拦截器测试");
        return true;
    }

    /**
     * 原始方法调用后执行的操作
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 原始方法调用完成后执行的操作
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
