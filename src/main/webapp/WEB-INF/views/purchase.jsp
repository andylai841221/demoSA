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
        <h1>DVD</h1>
        <p class="lead">Viewing Pleasure</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-12">
			<a class="btn btn-primary" href="checkout?id=${product.id}">結帳</a>
				<table class="table">
				  	<tr>
				  		<th>產品編號  </th><th>類別</th>
				  	</tr>
				  	<c:forEach items="${purchase}" var="product">
					  	<tr>
					  		<td>${product.album_id}</td>
					  		<td>${product.category}</td>					  		
					  		<td><a class="btn btn-sm btn-danger deleteBtn" href="?id=${product.album_id}">到貨</a></td>
					  	</tr>
				  	</c:forEach>
				</table>
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