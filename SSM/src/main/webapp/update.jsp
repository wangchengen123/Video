<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="update">
	真实姓名:<input type="text" name="truename" value="${user.truename }"><br>
	用户名:<input type="text" name="username" value="${user.username }"><br>
	密码:<input type="text" name="password" value="${user.password }"><br>
	工资:<input type="text" name="money" value="${user.money }"><br>
	年龄:<input type="text" name="age" value="${user.age }"><br>
		<input type="hidden" name="id" value="${user.id }">
		<input type="submit" value="提交">
</form>


</body>
</html>