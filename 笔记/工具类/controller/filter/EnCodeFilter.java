package com.controller.filter; /**
 * @Author: XIYAN
 * @Date: 2023/2/23 11:11
 * @注释:设置所有网页编码的过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EnCodeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //将ServletRequest转换成HttpServletRequest子对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //放行资源\路径
        String[] paths = {"/imgs/", "/css/", "/js/", "/login.jsp", "/loginServlet", "/register.jsp", "/enrollServlet"};
        //获取当前路径
        String url = httpServletRequest.getRequestURL().toString();
        //比对路径
        for (String str : paths) {
            //判断路径中是否存在放行的资源\路径
            if (url.contains(str)) {
                chain.doFilter(request, response);
            }
        }
        //将ServletResponse转换成HttpServletResponse子对象
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //设置页面请求的编码
        httpServletRequest.setCharacterEncoding("utf-8");
        //设置服务器响应的编码
        httpServletResponse.setContentType("text/html;charset=utf-8");
        //放行
        chain.doFilter(request, response);
    }
}
