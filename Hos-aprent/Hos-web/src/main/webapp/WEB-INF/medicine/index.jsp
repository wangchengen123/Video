<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>药品查询----2015</title>
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
				window.location.href="${pageContext.request.contextPath}/medicine/add";
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
				if(confirm("确认操作?")){
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			}
		}
    </script>
</head>
<body>

<form action="${pageContext.request.contextPath }/medicine/list" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">药品名称：</td>
        <td><input type="text" name="drugName" value=""/></td>
		
        <td width="10%" class="tableleft">药品类型：</td>
        <td><select><option>中药</option><option>西药</option><option>处方</option><option>非处方</option></select></td>
    </tr>
    <tr>
		
		
		  <td colspan="4">
			<center>
				<button type="submit" class="btn btn-primary" type="button">查询</button> 
				<button type="submit" class="btn btn-primary" type="button">清空</button> 
			</center>
        </td>
    </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>药品编号</th>
        <th>药品名称</th>
        <th>药品类型</th>
        <th>简单描述</th>
        <th>状态</th>
        <th>剩余量</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${lists }" var="d">
	     <tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
            <td style="vertical-align:middle;">${d.drugNum }</td>
            <td style="vertical-align:middle;">${d.drugName }</td>
            <td style="vertical-align:middle;">${d.drugType }</td>
            <td style="vertical-align:middle;">${d.simpleDetail }</td>
            <td style="vertical-align:middle;">${d.status }</td>
            <td style="vertical-align:middle;">${d.surplus }</td>
            <td style="vertical-align:middle;"><a href="<c:url value="/medicine/select?id=${d.drugNum }"/>">更改</a>&nbsp;&nbsp;&nbsp;
           <a href="<c:url value="/medicine/sele?id=${d.drugNum }"/>">详情</a></td>
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
  				<a href='${pageContext.request.contextPath }/medicine/list?pageNum=${pageNum-1 }&drugName=${drugName }'>上一页</a>
  			</c:otherwise>
  		</c:choose>
  		
  		${total }条记录${pageNum } / ${pages }页
  		
  		<c:choose>
  			<c:when test="${pageNum>=pages }">
  				<a href='javaScript:void(0)'>下一页</a>
  			</c:when>
  			<c:otherwise>
  				<a href='${pageContext.request.contextPath }/medicine/list?pageNum=${pageNum+1}&drugName=${drugName}'>下一页</a>
  			</c:otherwise>
  			
  		</c:choose>
  	
  	
		 <div>
			<button type="button" class="btn btn-success" id="newNav">添加新药</button>
			<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
			<button type="button" class="btn btn-success" id="delPro">导出txt</button>
		 </div>
		 
		 </th></tr>
  </table>
  
                                                                                            
</body>
</html>