<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<form action="login" method="post">
	用户名：<input type="text" name="username" /><br>
	密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /><br>
	<input type="submit" value="登录" />
	<input type="reset" value="重置" />
</form>
	还没有账号？<a href="register.jsp">立即注册</a>
</body>
</html>