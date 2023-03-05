package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:12
 * @注释:订单请求处理接口
 */

import com.alibaba.fastjson.JSON;
import com.model.Order;
import com.model.Page;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import com.utils.ParseGMT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/order/*")
public class OrderServlet extends BasicServlet {
    private final OrderService orderService = new OrderServiceImpl();

    //获取订单列表
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取学生列表
        Page<Order> list = orderService.list(pageSize, currentPage);
        String result = "fail";
        if (list.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(list);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过用户名查询订单
    public void getByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取用户名
        String name = request.getParameter("name");
        //解码
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Order newOrder = new Order();
        newOrder.setName(name);
        Page<Order> orders = orderService.getOrderByName(pageSize, currentPage, newOrder);
        String result = "fail";
        if (orders.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(orders);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过图书名称查询订单
    public void getBybook_name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取图书名称
        String book_name = request.getParameter("book_name");
        //解码
        book_name = new String(book_name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Order newOrder = new Order();
        newOrder.setBook_name(book_name);
        Page<Order> orders = orderService.getOrderByBook_name(pageSize, currentPage, newOrder);
        String result = "fail";
        if (orders.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(orders);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过订购日期查询订单
    public void getByPurchase_time(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取订购日期
        String purchase_time = request.getParameter("purchase_time");
        //解码
        purchase_time = new String(purchase_time.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //处理Date对象
        Date parseGMT = ParseGMT.parseGMT(purchase_time);
        //格式化日期时间格式
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        //将日期时间对象转为字符串
        String format = sdf.format(parseGMT);
        Order newOrder = new Order();
        newOrder.setPurchase_time(format);
        Page<Order> orders = orderService.getOrderByPurchase_time(pageSize, currentPage, newOrder);
        String result = "fail";
        if (orders.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(orders);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //批量删除订单
    public void delOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Order[] OrdersList = JSON.parseObject(readLine, Order[].class);
        //调用删除方法并返回执行结果
        String result = "";
        for (int i = 0; i < OrdersList.length; i++) {
            result = "fail";
            if (orderService.delOrderById(OrdersList[i])) {
                result = "succeed";
            }
            if ("fail".equals(result)) {
                break;
            }
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过订单序号删除订单
    public void delOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Order order = JSON.parseObject(readLine, Order.class);
        //调用删除方法并返回执行结果
        String result = "fail";
        if (orderService.delOrderById(order)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //批量修改订单状态
    public void outOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Order[] OrdersList = JSON.parseObject(readLine, Order[].class);
        //调用修改方法并返回执行结果
        String result = "";
        for (int i = 0; i < OrdersList.length; i++) {
            result = "fail";
            if (orderService.outOrderById(OrdersList[i])) {
                result = "succeed";
            }
            if ("fail".equals(result)) {
                break;
            }
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过订单序号修改订单状态
    public void outOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Order order = JSON.parseObject(readLine, Order.class);
        //调用删除方法并返回执行结果
        String result = "fail";
        if (orderService.outOrderById(order)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }
}
