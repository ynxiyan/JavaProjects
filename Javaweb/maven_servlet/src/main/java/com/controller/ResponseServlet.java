package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/19 16:26
 * @注释:
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Response1")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应状态码
        response.setStatus(302); //302(重定向)
        //设置响应的网页类型
        //response.setHeader("Content-Type","text/html;charset=ISO-8859-1");
        response.setContentType("text/html;charset=ISO-8859-1");
        response.sendRedirect(request.getContextPath() + "/Response2");
        //向浏览器响应数据(字符)
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("responseServlet");
//        //向浏览器响应数据（字节）
        //从硬盘读取文件到servlet中
        FileInputStream fileInputStream = new FileInputStream("");
        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
//        //声明数组存储文件字节
//        byte[] bytes = new byte[1024];
//        //声明整型变量存储字节长度（为-1说明字节长度读取完毕）
//        int b = 0;
//        //通过循环读取输入流里的数据并将读到的字节放在b里判断
//        while ((b = fileInputStream.read(bytes)) != -1) {
//            //从数组下标为0的元素中通过b获取到的长度读取字节并写入到浏览器（输出流）
//            outputStream.write(bytes,0,b);
//        }
        //向浏览器响应数据(使用IOutils)
        IOUtils.copy(fileInputStream, outputStream);
        //关闭输入流
        fileInputStream.close();

    }
}
