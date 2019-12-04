<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-md-8" style="margin-left: 180px; ">
	添加用户<a href="${pageContext.request.contextPath }/user/add" class="glyphicon glyphicon-plus"></a>
	<table class="table table-hover">
  		<tr>
  			<td>编号</td>
  			<td>用户名</td>
  			<td>密码</td>
  			<td>生日</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach items="${lists }" var="u">
  			<tr>
  				<td>${u.id }</td>
  				<td>${u.name }</td>
  				<td>${u.password }</td>
  				<td>
  					<fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd "/>
  				</td>
  				<td>
  					<a class="glyphicon glyphicon-pencil" href="<c:url value="/user/select?id=${u.id }"/> "></a>|
  					<a class="glyphicon glyphicon-trash" href="<c:url value="/user/delete?id=${u.id }"/>"></a>
  				</td>
  			</tr>
  		</c:forEach>
	</table>
</div>
</body>
</html>