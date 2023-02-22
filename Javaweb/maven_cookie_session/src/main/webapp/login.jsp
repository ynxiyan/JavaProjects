<%--
  Created by IntelliJ IDEA.
  User: XIYAN
  Date: 2023/2/22
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    <table border="1" align="center">
        <tr>
            <td colspan=2>
                <center><font size=4><b>Login Page</b></font></center>
            </td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" size=25 value="${cookie.username.value}"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" size=25 value="${cookie.password.value}"></td>
        </tr>
        <tr>
            <td>code:</td>
            <td>
                <input type="text" name="code"/>
                <img id="code" src="<%=request.getContextPath()%>/getCode">
            </td>
        </tr>
        <tr>
            <td colspan=2 align=center><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    // 通过id获取元素，并执行点击事件
    document.getElementById("code").onclick = function () {
        //修改code的src图片地址
        this.src = "<%=request.getContextPath()%>/getCode?d=" + new Date();
    }
</script>
</html>
