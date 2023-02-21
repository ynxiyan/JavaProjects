<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: XIYAN
  Date: 2023/2/21
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%--jsp的头部指令
language属性：表示的是jsp翻译后是什么语言的文件，暂时只支持java
contentType属性：表示当前jsp返回给页面的时候是什么类型的文档，也就是源码中的response.setContentType("text/html;charset=utf-8");
pageEncoding属性：表示的是当前源码的字符集编码
import属性：用于导包和java源文件一样
errorPage属性：表示当前jsp页面运行出错时，自动跳转到的页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>HelloWord!</h4>
<%--声明脚本--%>
<%!
    //    声明脚本
    private Integer id;
    private String name;
    private static final Map<String, String> map;

    //    声明静态代码块
    static {
        map = new HashMap<String, String>();
        map.put("", "");
    }

    //    声明方法
    public void test() {
    }

    //    内部类
    public class test {

    }
%>
<%--表达式脚本--%>
<%--输出整数--%>
<%=12%>
<%--输出浮点数--%>
<%=12.1%>
<%--输出字符--%>
<%="String"%>
<%--输出集合--%>
<%=map%>
<%--输出请求参数--%>
<%--<%=request.getParameter("username")%>--%>
<%--代码脚本--%>
<%
    for (int i = 0; i < 3; i++) {
%>
<%=i%>
<%
    }
%>
</body>
</html>
