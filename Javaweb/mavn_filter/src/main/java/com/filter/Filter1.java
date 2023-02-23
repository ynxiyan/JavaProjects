package com.filter; /**
 * @Author: XIYAN
 * @Date: 2023/2/23 10:21
 * @注释:实现filter过滤器接口
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//什么路径可以访问该filter
@WebFilter("/*")
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        //获取过滤器的FilterName
        System.out.println(config.getFilterName());
        //获取初始化参数中的参数
        System.out.println(config.getInitParameter(""));
        //application
        ServletContext servletContext = config.getServletContext();

    }

    public void destroy() {
    }

    //执行方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //放行
        chain.doFilter(request, response);
    }
}
