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
<%--jstl标签--%>
<%--导入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--if--%>
<c:if test="${a == 1}"><h4>a=1</h4></c:if>
<c:if test="${a != 1}"><h4>a!=1</h4></c:if>
</body>
</html>
