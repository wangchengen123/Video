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
<div >
	<a href="${pageContext.request.contextPath }/user/add" >新增员工</a>
	<table class="table table-hover">
  		<tr>
  			<td>员工编号</td>
  			<td>姓名</td>
  			<td>职位</td>
  			<td>工资</td>
  			<td>佣金</td>
  			<td>部门名称</td>
  			<td>领导名称</td>
  			<td>雇佣日期</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach items="${lists }" var="u">
  			<tr>
  				
  				<td>${u.empno }</td>
  				<td>${u.ename }</td>
  				<td>${u.job }</td>
  				<td>${u.mgr }</td>
  				<td>${u.sal }</td>
  				<td>${u.deptno }</td>
  				<td>${u.comm }</td>
  				<td>
  					<fmt:formatDate value="${u.hiredate }" pattern="yyyy-MM-dd "/>
  				</td>
  				<td>
  					<a  href="<c:url value="/user/select?id=${u.empno }"/> ">修改</a>|
  					<a  href="<c:url value="/user/delete?id=${u.empno }"/>">删除</a>
  				</td>
  			</tr>
  		</c:forEach>
	</table>
</div>
</body>
</html>