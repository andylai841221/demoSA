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
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
        <h1>CD</h1>
        <p class="lead">Listening Pleasure</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-12" style="top: 200px;">			
				<table class="table">
				  	<tr>
				  		<th>產品編號  </th><th>書籍名稱</th><th>類別</th><th>價錢</th><th>編輯</th>
				  	</tr>
				  	<c:forEach items="${sellcart}" var="product">
					  	<tr>
					  		<td>${product.product_id}</td>
					  		<td>${product.name}</td>
					  		<td>${product.category}</td>					  		
					  		<td>${product.price}</td>
					  		<td><a class="btn btn-default" href="decart?id=${product.product_id}">取消</a></td>
					  	</tr>
				  	</c:forEach>
				</table>
				<a class="btn btn-primary" href="sellout?id=${product.product_id}">出貨</a>
			</div>
		</div>
	</div>
	

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>