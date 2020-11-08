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
<h1>商品管理</h1>
欢迎您，${sessionScope.admin.username }
<a href="../exit" style="margin-left: 10px;">退出</a>
<h1>导航</h1>
<a href="index" style="margin-left: 10px;">首页</a>
<a href="user" style="margin-left: 10px;">用户管理</a>
<a href="commodity" style="margin-left: 10px;">商品管理</a>
<h1>操作</h1>
<button type="button" onclick="window.location.href='new'">新增</button>
<h1>商品列表</h1>
<div style="height: 400px;width: 500px;overflow: auto">
<c:forEach items="${commodities }" var="commodity">
<div style="margin-top: 40px;border:1px solid #000;heigth: 100px;width: 400px;padding: 10px">
<div>商品名称：${commodity.name}
商品种类：${commodity.category}
商品价格：${commodity.price}</div>
<div style="margin-top: 20px;">
	<button type="button" onclick="window.location.href='../commodity/info/${commodity.id}'">详情</button>
	<button type="button" onclick="delect(${commodity.id})">删除</button>
</div>
</div>
</c:forEach>
</div>
<script type="text/javascript">
	function delect(id){
		$.getJSON('opera/commodity/delete', {id: id}, function(result){
			if(result.code == 200){
				alert("删除成功");
				location.reload();
			}else{
				alert("删除失败");
			}
		})
	}
</script>
</body>
</html>