<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
     <script type="text/javascript">
     $(function () {
		$('#newNav').click(function(){
				window.location.href="${pageContext.request.contextPath}/user/add";
		 });
    });

	
	
    function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkall");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}
		function delAll(){
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
				if(confirm("确认删除?")){
					alert("删除成功!");
				}
			}else{
				alert("请选中要删除的项");
			}
		}
    </script>
</head>
<body>


<form class="form-inline definewidth m20" action="${pageContext.request.contextPath }/user/list" method="get">    
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>
</form>


<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>用户账户</th>
        <th>真实姓名</th>
        <th>角色</th>
        <th  width="10%">操作</th>
    </tr>
    </thead>
    <c:forEach items="${lists }" var="u">
     
	     <tr>
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
            <td>${u.user_name }</td>
            <td>${u.real_name }</td>
            <td>${u.roles.roleName }</td>
            <td>
                <a href="<c:url value="/user/select?id=${u.id }" /> ">编辑</a>&nbsp;&nbsp;&nbsp;
                <a href="<c:url value="/user/delete?id=${u.id }" />">删除</a>             
            </td>
        </tr>
        </c:forEach>
 	
</table>
<table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page"></div>
  	
  	     <c:choose>
           <c:when test="${pageNum<=1 }">
               <a href='javaScript:void(0)'>上一页</a>
           </c:when>
           <c:otherwise>
              <a href='${pageContext.request.contextPath }/user/list?pageNum=${pageNum-1 }&username=${username }'>上一页</a>
           </c:otherwise>
         </c:choose>
         
          ${total } 条记录 ${pageNum } / ${pages } 页 
          
         <c:choose>
           <c:when test="${pageNum>=pages }">
               <a href='javaScript:void(0)'>下一页</a>
           </c:when>
           <c:otherwise>
              <a href='${pageContext.request.contextPath }/user/list?pageNum=${pageNum+1 }&username=${username }'>下一页</a>
           </c:otherwise>
         </c:choose>
         
         
         
        
         
         <div>
         <button type="button" class="btn btn-success" id="newNav">添加用户</button>&nbsp;&nbsp;&nbsp;
         <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">删除选中</button>
         </div>
         </th>
         </tr>
  </table>
                                                                                            
</body>
</html>