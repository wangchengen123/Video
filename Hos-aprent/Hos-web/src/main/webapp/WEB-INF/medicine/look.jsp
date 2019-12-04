<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查看-- -2015</title>
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
				window.location.href="${pageContext.request.contextPath}/medicine/list";
		 });
    });
    </script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">药品编号</td>
        <td>${drug.drugNum }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">图片</td>
        <td><img src="1.png"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">进价</td>
        <td>${drug.purchasPrice }元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">售价</td>
        <td>${drug.salePrice }元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td>${drug.drugName }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品类型</td>
        <td>${drug.drugType }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">简单描述</td>
        <td>${drug.simpleDetail }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产日期</td>
        <td>${drug.prodecedDate }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">保质期</td>
        <td>${drug.expirationDate }月</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">过期日期</td>
        <td>${drug.qualityDate }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">详细描述</td>
        <td>${drug.detail }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产厂商</td>
        <td>${drug.manufacture }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">服用说明</td>
        <td>${drug.useInfor }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">库存</td>
        <td>${drug.totalStock }袋</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">剩余量</td>
        <td>${drug.surplus }袋</td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${drug.noted }</td>
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