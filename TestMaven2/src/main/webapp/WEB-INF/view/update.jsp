<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mydate.js"></script>
<script type="text/javascript">
// 页面加载完成事件
window.onload=function(){ 
	var strtime = "${user.hiredate}";
	var time = myFormatDate(strtime);
	document.getElementById("test1").value=time;
} 

</script>
<body>
<div >
	<form action="${pageContext.request.contextPath }/user/update" method="post">
	<table class="table table-hover">
	
		<tr>
			<td>员工编号</td>
			<td>
				<input type="hidden" name = "id" value="${user.empno }">
				<input type="text" name="empno" value="${user.empno }">
			</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="ename" value="${user.ename }">
			</td>
		</tr>
		<tr>
			<td>职位</td>
			<td>
				<input type="text" name="job" value="${user.job }">
			</td>
		</tr>
		<tr>
			<td>工资</td>
			<td>
				<input type="text" name="mgr" value="${user.mgr }">
			</td>
		</tr>
		<tr>
			<td>佣金</td>
			<td>
				<input type="text" name="sal" value="${user.sal }">
			</td>
		</tr>
		<tr>
			<td>部门名称</td>
			<td>
				<input type="text" name="deptno" value="${user.deptno }">
			</td>
		</tr>
		<tr>
			<td>领导名称</td>
			<td>
				<input type="text" name="comm" value="${user.comm }">
			</td>
		</tr>
		<tr>
			<td>雇佣日期</td>
			<td>
				<div class="layui-inline">
					<div class="layui-input-inline">
        				<input type="text" class="layui-input" id="test1" name="hiredate" value="${user.hiredate }">
      				</div>
      			</div>
			</td>
		</tr>
	</table>
	<span>${msg }</span>
	<input type="submit" value="修改">
	</form>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script>
layui.use('laydate', function(){
	 var laydate = layui.laydate;
	//常规用法
	  laydate.render({
	    elem: '#test1'
	  });
});
</script>
</div>
</body>
</html>