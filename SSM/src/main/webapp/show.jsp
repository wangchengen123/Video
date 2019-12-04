<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="add.jsp">添加</a>  
	<form action="show">
		<input type="text" name="truename">
		<input type="submit" value="查询">
	</form>
</body>
<table>
	<tr>
		<td>ID</td>
		<td>真实姓名</td>
		<td>用户名</td>
		<td>密码</td>
		<td>工资</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="i">
		<tr>
			<td>${i.id }</td>
			<td>${i.truename }</td>
			<td>${i.username }</td>
			<td>${i.password }</td>
			<td>${i.money }</td>
			<td>${i.age }</td>
			<td>
				<a href="selectByID?id=${i.id}">修改</a>
				<a href="delete?id=${i.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
</html>