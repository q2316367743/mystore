<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的商城</title>
<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>支付</h1>
<c:choose>
<c:when test="${sessionScope.user != null }">
欢迎您，${sessionScope.user.username }
<a href="../my" style="margin-left: 10px;">个人中心</a>
<a href="../exit" style="margin-left: 10px;">退出</a>
</c:when>
<c:otherwise>
<a href="../login.jsp">登录</a>
<a href="../register.jsp" style="margin-left: 10px;">注册</a>
</c:otherwise>
</c:choose>
<h2>导航</h2>
<a href="../index" style="margin-left: 10px;">首页</a>
<a href="../category/default" style="margin-left: 10px;">分类</a>
<a href="../search" style="margin-left: 10px;">搜索</a>
<h2>支付</h2>
<h3>商品详情</h3>
<div style="margin-top: 40px;border:1px solid #000;heigth: 100px;width: 400px;padding: 10px">
<div>商品名称：${commodity.name}
商品种类：${commodity.category}
</div>
</div>
<h2>准备支付</h2>
当前账户余额：${sessionScope.user.money }<br>
商品价格：${commodity.price}<br>
<button type="button" onclick="buy(${commodity.id })">支付</button>
</body>
<script type="text/javascript">
	function buy(id){
		$.getJSON('buy', {id: id}, function(result){
			if(result.code == 200){
				alert("购买成功")
				window.location.href = '../my';
			}else{
				alert(result.message)
			}
		})
	}
</script>
</html>