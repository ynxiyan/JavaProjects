<%--
  Created by IntelliJ IDEA.
  User: XIYAN
  Date: 2023/2/21
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/maven_jsp_crud/addstudent.jsp">添加</a>
<table border="1px">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年级</th>
        <th>年龄</th>
        <th>地址</th>
        <th>状态</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.grade}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <c:if test="${student.status==1}">
                <td><a href="/maven_jsp_crud/status?id=${student.id}">启用</a></td>
            </c:if>
            <c:if test="${student.status==0}">
                <td><a href="/maven_jsp_crud/status?id=${student.id}">关闭</a></td>
            </c:if>
            <td><a href="/maven_jsp_crud/get?id=${student.id}">修改</a></td>
            <td><a href="/maven_jsp_crud/del?id=${student.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
