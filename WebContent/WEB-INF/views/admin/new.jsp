<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>新增商品</h1>
欢迎您，${sessionScope.admin.username }
<a href="../exit" style="margin-left: 10px;">退出</a>
<h1>导航</h1>
<a href="index" style="margin-left: 10px;">首页</a>
<a href="user" style="margin-left: 10px;">用户管理</a>
<a href="commodity" style="margin-left: 10px;">商品管理</a>
<h1>新增种类</h1>
种类：<input type="text" id="cate"><br>
<button onclick="addCategory()" type="button">新增</button>
<h1>新增商品</h1>
<form action="opera/commodity/new" method="post">
	名称：<input type="text" id="name"/><br>
	分类：<select id="category">
		<c:forEach items="${categories }" var="category">
			<option value="${category.name }">${category.name }</option>
		</c:forEach>
	</select><br>
	价格：<input id="price" type="text"/><br>
	<button type="button" onclick="newcom()">新建</button><input type="reset" value="重置">	
</form>
<script type="text/javascript">
	function newcom(){
		var name = $("#name").val();
		var category = $("#category").val();
		var price = $("#price").val();
		$.getJSON('opera/commodity/new', {
			name: name,
			category: category,
			price: price
		}, function(result){
			if(result.code == 200){
				alert("新增成功");
				location.reload();
			}else{
				alert("新增失败");
			}
		})
	}
	function addCategory(){
		var category = $("#cate").val();
		$.getJSON('opera/category/new', {
			name: category
		}, function(result){
			if(result.code == 200){
				alert("新增成功");
				location.reload();
			}else{
				alert("新增失败");
			}
		})
	}
</script>
</body>
</html>