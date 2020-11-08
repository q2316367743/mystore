<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>首页</h1>
欢迎您，${sessionScope.admin.username }
<a href="../exit" style="margin-left: 10px;">退出</a>
<h1>导航</h1>
<a href="index" style="margin-left: 10px;">首页</a>
<a href="user" style="margin-left: 10px;">用户管理</a>
<a href="commodity" style="margin-left: 10px;">商品管理</a>
</body>
</html>