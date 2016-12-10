<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    

    <title>產品管理</title>
</head>
<body>
<table class="table">
				  	<tr>
				  		<th>編號</th>
				  		<th>類別</th>
				  		<th>描述</th>
				  		<th>庫存量</th>				  		
				  		<th>圖片</th>
				  		<th></th>
				  		
				  	</tr>
				  	<c:forEach items="${productList}" var="product">
					  	<tr>
					  		<td>${product.id}</td>
					  		<td>${product.category}</td>
					  		<td>${product.desc}</td>
					  		<td>${product.inventory}</td>
					  		<td>${product.reorderPoint}</td>
					  		<td><img src="resources\fileUpload\<c:out value="${product.id}"/>.jpg" width="30%"></td>
					  		<td><a class="btn btn-default" href="add?id=${product.id}">取消</a></td>
					  	</tr>
				  	</c:forEach>				  	
				</table><a class="btn btn-default" href="add?id=${product.id}">結帳</a>
</body>
</html>