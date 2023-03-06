package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:12
 * @注释:用户请求处理接口
 */

import com.alibaba.fastjson.JSON;
import com.model.Page;
import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends BasicServlet {
    private final UserService userService = new UserServiceImpl();

    //获取用户列表
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取学生列表
        Page<User> list = userService.list(pageSize, currentPage);
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

    //通过用户名查询用户
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
        User newUser = new User();
        newUser.setName(name);
        Page<User> users = userService.getUserByName(pageSize, currentPage, newUser);
        String result = "fail";
        if (users.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(users);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过省份和城市查询用户
    public void getByProvince_city(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取省份序号
        String province_id = request.getParameter("province");
        //获取城市序号
        String city_id = request.getParameter("city");
        User newUser = new User();
        newUser.setProvince(province_id);
        newUser.setCity(city_id);
        Page<User> users = userService.getUserByProvince_city(pageSize, currentPage, newUser);
        String result = "fail";
        if (users.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(users);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过电话号码查询用户
    public void getByPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取电话号码
        String phone = request.getParameter("phone");
        User newUser = new User();
        newUser.setPhone(phone);
        Page<User> users = userService.getUserByPhone(pageSize, currentPage, newUser);
        String result = "fail";
        if (users.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(users);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过电子邮箱查询用户
    public void getByEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取电子邮箱
        String email = request.getParameter("email");
        //解码
        email = new String(email.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        User newUser = new User();
        newUser.setEmail(email);
        Page<User> users = userService.getUserByEmail(pageSize, currentPage, newUser);
        String result = "fail";
        if (users.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(users);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //新增用户
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        User user = JSON.parseObject(readLine, User.class);
        //调用新增方法并返回执行结果
        String result = "fail";
        if (userService.addUser(user)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //批量删除用户
    public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        User[] userList = JSON.parseObject(readLine, User[].class);
        //调用删除方法并返回执行结果
        String result = "";
        for (int i = 0; i < userList.length; i++) {
            result = "fail";
            if (userService.delUserById(userList[i])) {
                result = "succeed";
            }
            if ("fail".equals(result)) {
                break;
            }
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过用户序号删除用户
    public void delUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        User user = JSON.parseObject(readLine, User.class);
        //调用删除方法并返回执行结果
        String result = "fail";
        if (userService.delUserById(user)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过用户序号更新用户信息
    public void upUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        User user = JSON.parseObject(readLine, User.class);
        //调用更新方法并返回执行结果
        String result = "fail";
        if (userService.upUserById(user)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过用户序号重置用户密码
    public void reUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        User user = JSON.parseObject(readLine, User.class);
        //调用更新方法并返回执行结果
        String result = "fail";
        if (userService.reUserById(user)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }
}
