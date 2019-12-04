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
<div class="col-md-5" style="margin-left: 180px; ">
	<form action="${pageContext.request.contextPath }/user/add" method="post">
	<table class="table table-hover">
		<tr>
			<td>用户名</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="text" name="password">
			</td>
		</tr>
		<tr>
			<td>生日</td>
			<td>
				<div class="layui-inline">
					<div class="layui-input-inline">
        				<input type="text" class="layui-input" id="test1" name="birthday" placeholder="yyyy-MM-dd">
      				</div>
      			</div>
			</td>
		</tr>
		
	</table>
	<span>${msg }</span>
	<input type="submit" value="添加">
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