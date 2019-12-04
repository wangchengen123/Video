<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>首页</h1>
${springmvc }
<hr>
<h2>接收基本数据类型</h2>
<form action="${pageContext.request.contextPath }/receiveBase.do">
	id:<input type="text" name="id"><br>
	score:<input type="text" name="score"><br>
	result:<input type="text" name="result"><br>
	name:<input type="text" name="name"><br>
	<input type="submit" value="发出参数"><br>
</form>
<hr>
<h2>接收对象类型</h2>
<form action="${pageContext.request.contextPath }/receiveUser.do">
	id:<input type="text" name="id"><br>
	name:<input type="text" name="name"><br>
	score:<input type="text" name="score"><br>
	<input type="submit" value="发出参数"><br>
</form>
<hr>
<h2>接收数组类型</h2>
<form action="${pageContext.request.contextPath }/receiveArray.do">
	1<input type="checkbox" name="ids" value="11"><br>
	2<input type="checkbox" name="ids" value="22"><br>
	3<input type="checkbox" name="ids" value="33"><br>
	<input type="submit" value="发出参数"><br>
</form>
</body>
</html>