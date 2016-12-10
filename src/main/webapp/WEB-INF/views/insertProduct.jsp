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
        <h1>產品管理系統</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6"style="top: 200px;">
				<form method="post" action="insertProduct" id="insertForm">
					<div class="form-group">
						類別:<select class="form-control" name="category">
  						<option>政治</option>
  						<option>商業理財</option>
  						<option>文學</option>
  						
						</select>
					</div>
					<div class="form-group">
						<label>書名:</label>
						<input type="text" name="name"  required>
						
					</div>
				
					<div class="form-group">
						<label>出版社:</label>
						<input type="text" name="company" required>
						
					</div>
					<div class="form-group">
						<label>ISBN:</label>
						<input type="number" name="product_id" required>
					
					</div>
					<div class="form-group">
						<label>作者:</label>
						<input type="text" name="author" required>
						
					</div>
					<div class="form-group">
						<label>譯者:</label>
						<input type="text" name="translator"required>
						
							<div class="form-group">
						<label>價錢:</label>
						<input type="number" name="price" required>
					
					</div>
					</div>
					<div class="form-group">
						<label>庫存量:</label>
						<input type="number" name="inventory" placeholder="0" min="0" required>
					
					</div>
					<div class="form-group">
						<label>安全存量:</label>
						<input type="number" name="safeInventory" placeholder="0" required>
					
					</div>
					
					
			  		<button type="submit" class="btn btn-default">新增</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div><!-- /.container -->
	    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
    <script src="<c:url value="/resources/js/additional-methods.js" />"></script>
    <script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>
	<script>
	$("#insertForm").validate();
	</script>
    
</body>
</html>
