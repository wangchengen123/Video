<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>录入住院信息-- -2015</title>
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
				window.location.href="index.html";
		 });
    });
    </script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td><input type="text" name="pname" value="输入病历号回车自动带出挂号人信息"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>黄飞鸿</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td>身份证</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td>42068325467876</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td>423423432</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td>13126576456</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td><input type="radio" name="pname0" value="" checked/>否&nbsp;&nbsp;&nbsp;<input type="radio" name="pname0" value=""/>是</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td><input type="radio" name="pname" value="" checked/>男&nbsp;&nbsp;&nbsp;<input type="radio" name="pname" value=""/>女</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>33</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td><input type="radio" name="pname1" value="" checked/>初诊&nbsp;&nbsp;&nbsp;<input type="radio" name="pname1" value=""/>复诊</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td><select><option>急诊科</option><option>骨科</option><option>血液科</option></select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td><select><option>程俊</option><option>欧阳雨露</option><option>王博</option></select></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>暂无  以上信息为输入病历号自动带出来的</td>
	</tr>
    <tr>
        <td width="10%" class="tableleft">护理</td>
        <td><input type="text" name="pname" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">床位号</td>
        <td><input type="text" name="pname" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">缴费押金</td>
        <td><input type="text" name="pname" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">病情</td>
        <td><textarea></textarea></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
                                                                                            
</body>
</html>