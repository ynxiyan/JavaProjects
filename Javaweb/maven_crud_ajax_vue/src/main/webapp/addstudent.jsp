<%--
  Created by IntelliJ IDEA.
  User: XIYAN
  Date: 2023/2/21
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/put" method="post" name="form">
    学生姓名：<input type="text" name="name"/><br>
    所在年级：<select name="grade">
    <option value="一年级">一年级</option>
    <option value="二年级">二年级</option>
</select><br>
    学生年龄：<input type="number" name="age"/><br>
    学生地址：<textarea name="address"></textarea><br>
    排序：<input type="number" name="ordered"/><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
