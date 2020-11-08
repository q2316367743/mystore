<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的商城</title>
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<style type="text/css">
.right {
	float: left;
	width: 20%;
	position: relative;
	display: block;
	box-sizing: border-box;
	height: 400px;
	overflow: auto;
}
</style>
</head>
<body>
	<h1>个人中心</h1>
	<c:choose>
		<c:when test="${sessionScope.user != null }">
欢迎您，${sessionScope.user.username }
<a href="my" style="margin-left: 10px;">个人中心</a>
			<a href="exit" style="margin-left: 10px;">退出</a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">登录</a>
			<a href="register.jsp" style="margin-left: 10px;">注册</a>
		</c:otherwise>
	</c:choose>
	<h2>导航</h2>
	<a href="index" style="margin-left: 10px;">首页</a>
	<a href="category/default" style="margin-left: 10px;">分类</a>
	<a href="search" style="margin-left: 10px;">搜索</a>
	<div>
		<div class="right">
			<h2>个人信息</h2>
			用户名：<input type="text" id="username" value="${user.username }"><br>
			密码：<input type="password" id="password" value="${user.password }"><br>
			性别：<input type="radio" value="1" name="gender" ${user.gender ? 'checked' : '' }>男
				 <input type="radio" value="0" name="gender" ${!user.gender ? 'checked' : '' }>女<br>
			年龄：<input type="text" id="age" value="${user.age}"><br>
			余额：<input type="text" disabled="disabled" value="${user.money}"><br>
			<button type="button" onclick="update()">修改</button>
			<button id="layout" type="button" onclick="layout()">注销</button>
		</div>
		<div class="right">
			<h2>购物车信息</h2>
			<c:forEach items="${commodities }" var="commodity">
				<div style="margin-top: 40px;border:1px solid #000;heigth: 100px;width: 80%;padding: 10px">
				<div>商品名称：${commodity.name}<br>
				商品种类：${commodity.category}<br>
				商品价格：${commodity.price}</div>
				<div style="margin-top: 20px;">
					<button type="button" onclick="window.location.href='commodity/info/${commodity.id}'">详情</button>
					<button type="button" onclick="window.location.href='commodity/pay?id=${commodity.id}'">购买</button>
				</div>
				</div>
			</c:forEach>
		</div>
		<div class="right">
			<h2>购买记录</h2>
			<c:forEach items="${records }" var="record">
				<div style="margin-top: 40px;border:1px solid #000;heigth: 100px;width: 80%;padding: 10px">
				<div>商品名称：${record.name}<br>
				商品种类：${record.category}<br>
				商品价格：${record.price}</div>
				<div style="margin-top: 20px;">
					<button type="button" onclick="window.location.href='commodity/info/${record.id}'">详情</button>
				</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
		function update(){
			var username = $("#username").val();
			var password = $("#password").val();
			var age = $("#age").val();
			var gender = $("input[name='gender']:checked").val();
			$.getJSON('user/update', {
				username: username,
				password: password,
				age: age,
				gender: gender
			},function(result){
				if(result.code == 200){
					alert("修改成功，请重新登录")
					window.location.href = 'login.jsp'
				}else{
					alert("修改失败，请重试")
					location.reload()
				}
			})
		}
		function layout(){
			var string = $("#layout").text();
			if(string == '注销'){
				$("#layout").attr('style', 'color: red;')
				$("#layout").text("确认注销？")
			}
			if(string == '确认注销？'){
				$.getJSON('user/layout',function(result){
					if(result.code == 200){
						alert("注销成功");
						window.location.href = 'index';
					}else{
						alert("注销失败");
					}
				})
			}
		}
	</script>
</body>
</html>