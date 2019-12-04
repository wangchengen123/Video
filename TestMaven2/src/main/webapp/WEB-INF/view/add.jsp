<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
</head>
<body>
<div >
	<form action="${pageContext.request.contextPath }/user/add" method="post">
	<table class="table table-hover">
		<tr>
			<td>员工编号</td>
			<td>
				<input type="text" name="empno" placeholder="请输入编号">
			</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="ename" placeholder="请输入姓名">
			</td>
		</tr>
		<tr>
			<td>职位</td>
			<td>
				<input type="text" name="job" placeholder="请输入职位">
			</td>
		</tr>
		<tr>
			<td>工资</td>
			<td>
				<input type="text" name="mgr" placeholder="请输入工资">
			</td>
		</tr>
		<tr>
			<td>佣金</td>
			<td>
				<input type="text" name="sal" placeholder="请输入佣金">
			</td>
		</tr>
		<tr>
			<td>部门名称</td>
			<td>
				<input type="text" name="deptno" placeholder="请输入部门名称">
			</td>
		</tr>
		<tr>
			<td>领导名称</td>
			<td>
				<input type="text" name="comm" placeholder="请输入领导名称">
			</td>
		</tr>
		<tr>
			<td>雇佣日期</td>
			<td>
				<div class="layui-inline">
					<div class="layui-input-inline">
        				<input type="text" class="layui-input" id="test1" name="hiredate" placeholder="yyyy-MM-dd">
      				</div>
      			</div>
			</td>
		</tr>
		
	</table>
	<span>${msg }</span>
	<input type="submit" value="新增">
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