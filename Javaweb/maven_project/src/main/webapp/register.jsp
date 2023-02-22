<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="<%=request.getContextPath()%>/enrollServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                </td>
            </tr>
            <span id="username_err" class="err_msg">${usermsg!=null?usermsg:""}</span>
            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="img" src="<%=request.getContextPath()%>/getcode">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>
            <span id="password_err" class="err_msg">${codemsg!=null?codemsg:""}</span>
        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>
</body>
<script type="text/javascript">
    var img = document.getElementById("img")
    document.getElementById("changeImg").onclick = function () {
        img.src = "<%=request.getContextPath()%>/getcode?d=" + new Date()
    }
</script>
</html>