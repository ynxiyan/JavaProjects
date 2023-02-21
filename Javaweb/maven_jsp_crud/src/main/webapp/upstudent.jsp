<%--
  Created by IntelliJ IDEA.
  User: XIYAN
  Date: 2023/2/21
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<form action="/maven_jsp_crud/update" method="post" name="form">
    <input hidden="hidden" name="id" value="${studentById.id}"/>
    学生姓名：<input type="text" name="name" value="${studentById.name}"/><br>
    所在年级：<select name="grade">
    <option value="一年级" ${studentById.grade=="一年级"?"selected":""}>一年级</option>
    <option value="二年级" ${studentById.grade=="二年级"?"selected":""}>二年级</option>
</select><br>
    学生年龄：<input type="number" name="age" value="${studentById.age}"/><br>
    学生地址：<textarea name="address">${studentById.address}</textarea><br>
    排序：<input type="number" name="ordered" value="${studentById.ordered}"/><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
