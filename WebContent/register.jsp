<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<form action="register" method="post">
	用户名：<input type="text" name="username" /><br>
	密码：<input type="password" name="password" /><br>
	年龄：<input type="text" name="age" /><br>
	性别：<input type="radio" name="gender" value="1" />男
		<input type="radio" name="gender" value="0" />女<br>
	<input type="submit" value="注册"><input type="reset" value="重置">
</form>
</body>
</html>