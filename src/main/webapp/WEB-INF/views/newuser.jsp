<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<h1>
	管理員登入介面
</h1>
<P>  輸入帳號密碼 </P>
<form action="newuser" method ="post">
	帳號:<input type="text" name ="name"/></br>
	電話:<input type="text" name ="phone"/></br>
	地址:<input type="text" name ="address"/></br>
	密碼:<input type="password" name ="password"/></br>

	<button type="submit" class="btn btn-danger">登入</button>
	<label class="label label-warning">${message} ${account.username}</label>
</form>

</body>
</html>