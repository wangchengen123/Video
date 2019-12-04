<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查看---2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Js/ckeditor/ckeditor.js"></script>
 

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
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/doctor/list";
		 });
    });
    </script>
</head>
<body>
<form action="" method="get" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${doctor.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td>${doctor.certificateType }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td>${doctor.idNum }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">手机</td>
        <td>${doctor.phone }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">座机</td>
        <td>${doctor.specialPlane }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>${doctor.sex }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>${doctor.age }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">出生年月</td>
        <td>${doctor.birther }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td>${doctor.email }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所属科室</td>
        <td>${doctor.section.seccoName }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>${doctor.education }</td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${doctor.noted }</td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
                                                                                            
</body>
</html>