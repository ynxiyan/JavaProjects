package com.controller.code; /**
 * @Author: XIYAN
 * @Date: 2023/2/22 17:18
 * @注释:获取验证码
 */

import com.utils.CodeUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getcode")
public class GetCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        //生成验证码
        String code = CodeUtils.outputVerifyImage(150, 50, outputStream, 4);
        request.getSession().setAttribute("code", code);
    }
}
