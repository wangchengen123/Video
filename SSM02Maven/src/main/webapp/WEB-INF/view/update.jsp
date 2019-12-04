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
// alert(${user.id});
// 页面加载完成事件
window.onload=function(){ 
	var strtime = "${user.birthday}";
	var time = myFormatDate(strtime);
	document.getElementById("test1").value=time;
} 

</script>
<body>
<div class="col-md-5" style="margin-left: 180px; ">
	<form action="${pageContext.request.contextPath }/user/update" method="post">
	<table class="table table-hover">
	
		<tr>
			<td>用户名</td>
			<td>
				<!-- 利用隐藏的输入框,携带id -->
				<input type="hidden" name = "id" value="${user.id }">
				<input type="text" name="name" value="${user.name }">
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="text" name="password" value="${user.password }">
			</td>
		</tr>
		<tr>
			<td>生日</td>
			<td>
				<div class="layui-inline">
					<div class="layui-input-inline">
        				<input type="text" class="layui-input" id="test1" name="birthday" value="${user.birthday }">
      				</div>
      			</div>
			</td>
		</tr>
	</table>
	<span>${msg }</span>
	<input type="submit" value="提交">
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