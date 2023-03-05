package com.controller.filter; /**
 * @Author: XIYAN
 * @Date: 2023/2/23 11:02
 * @注释:验证所有网页用户登录的过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //将ServletRequest转换成HttpServletRequest子对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //设置网页请求编码
        httpServletRequest.setCharacterEncoding("utf-8");
        //设置服务器响应编码
        response.setContentType("text/html;charset=utf-8");
        //放行资源\路径
        String[] paths = {"/imgs/", "/css/", "/js/", "/login.jsp", "/loginServlet", "/register.jsp", "/enrollServlet"};
        //获取当前路径
        String url = httpServletRequest.getRequestURL().toString();
        //比对路径
        for (String str : paths) {
            //判断路径中是否存在放行的资源\路径
            if (url.contains(str)) {
                //放行
                chain.doFilter(request, response);
                return;
            }
        }
        if (httpServletRequest.getSession().getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
        }
    }
}
