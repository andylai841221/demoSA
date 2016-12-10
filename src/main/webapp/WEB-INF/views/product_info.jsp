<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">


<title>Bookstore</title>
</head>
<body>



	<%@include file="navbar.jspf"%>

	<div class="container">

		<div class="row">



			<div class="row">
				<div class="col-md-6 col-lg-5" style="top: 450px;">
					<img class="img-rounded" style="width: 450px; height: 450px"
						src="${product.path}">

				</div>
				<div class="col-md-3 col-lg-4" style="top: 450px;">
					<div class="clearfix">
						<h1 class="setofont">${product.product_id}</h1>
					</div>
					<div class="clearfix well well-sm">
						<ul>
						<li>ISBN:${product.product_id}</li>
							<li>類型：${product.category}</li>
							<li>書名：${product.name}</li>
							<li>作者：${product.author}</li>
							<li>譯者：${product.translator}</li>
							<li>發行公司：${product.company}</li>
							<li>發行日期：${product.rel_date}</li>
							<li>定價：<em>${product.price}</em>元
							</li>
							<li>優惠價：<strong> <b>${product.discount_price}</b></strong>元
							</li>
							<li>優惠期限：${product.discount_date} 止</li>
						</ul>
					</div>
					
					<div class="clearfix">
						<a href="add?id=${product.product_id}"
							onclick="window.location.reload()"
							class="glyphicon glyphicon-thumbs-up btn-lg btn-primary"><span>放入購物車</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>