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
<style type="text/css">
.left1 {
	float: left;
	width: 60%;
	position: relative;
	display: block;
	box-sizing: border-box;
	height: 400px;
	overflow: auto;
}
.left2 {
	float: left;
	width: 40%;
	position: relative;
	display: block;
	box-sizing: border-box;
	height: 400px;
	overflow: auto;
}
.all {
	float: left;
	position: relative;
	display: block;
	box-sizing: border-box;
	margin-top: 40px;
	width: 20%;
	border:1px solid #000;
	padding: 10px;
	height: 180px;
}
</style>
</head>
<body>
<h1>用户管理</h1>
欢迎您，${sessionScope.admin.username }
<a href="../exit" style="margin-left: 10px;">退出</a>
<h1>导航</h1>
<a href="index" style="margin-left: 10px;">首页</a>
<a href="user" style="margin-left: 10px;">用户管理</a>
<a href="commodity" style="margin-left: 10px;">商品管理</a>
<h1>用户列表</h1>
<c:forEach items="${users }" var="user">
<div class="all">
	<div class="left1">
		<h2>${user.id }</h2>
		用户名：${user.username}<br>
		密码：${user.password}<br>
		性别：${user.gender ? '男' : '女'}<br>
		年龄：${user.age }
	</div>
	<div style="margin-top: 20px;"  class="left2">
		<button id="delect" type="button" onclick="delect(${user.id})">删除</button>
	</div>
</div>
</c:forEach>
</body>
<script type="text/javascript">
	function delect(id){
		var string = $("#delect").text();
		if(string == '删除'){
			$("#delect").attr('style', 'color: red;')
			$("#delect").text("确认删除？")
		}
		if(string == '确认删除？'){
			$.getJSON('opera/user/delete', {id: id}, function(result){
				if(result.code == 200){
					alert("删除成功");
					location.reload();
				}else{
					alert("删除失败");
				}
			})
		}
	}
</script>
</html>