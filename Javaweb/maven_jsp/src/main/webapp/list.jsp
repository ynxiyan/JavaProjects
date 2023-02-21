<%@ page import="com.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: XIYAN
  Date: 2023/2/21
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--itens表示获取的数据集合、数组  var表示遍历时里面的每个对象并存储为变量--%>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}
            </td>
            <td>${student.name}
            </td>
            <td>${student.age}
            </td>
            <td>${student.sex}
            </td>
            <td>${student.state == 1?"已报道":"未报道"}
            </td>
            <td><a href="#">更新</a><a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
