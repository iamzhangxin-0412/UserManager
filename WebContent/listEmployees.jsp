<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" /> 
  <link href="css/validate.css" rel="stylesheet" type="text/css" /> 
  <link href="css/blue.css" rel="stylesheet" type="text/css" /> 
  <link href="css/default.css" rel="stylesheet" type="text/css" /> 
  <link href="css/docs.min.css" rel="stylesheet" type="text/css" /> 
  <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen" /> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
  <script src="css/jquery-1.9.1.min.js" type="text/javascript"></script> 
  <script src="css/jquery.validate.min.js" type="text/javascript"></script> 
  <script src="css/messages_bs_zh.js" type="text/javascript"></script> 
  <script src="css/jquery.icheck.min.js" type="text/javascript"></script> 
  <script src="css/function.js" type="text/javascript"></script> 

<title>客户信息列表</title>
</head>
<body>
  <div class="bs-docs-header" id="content"> 
   <div class="container" style="font-family:'微软雅黑'">
     <h1>薪资管理系统</h1> 
    <p>客户信息列表</p> 
   </div> 
   <p>&nbsp;</p> 
   <p>&nbsp;</p> 
  </div> 
<div class="container"> 
   <div id="content"> 
	<form action="${pageContext.request.contextPath}/servlet/DelMultiServlet" id="f1" method="post">
		<div class="col-md-6 col-md-offset-3">
        <div class="panel panel-info"> 
      <div class="panel-heading"> 
         <h3 class="panel-title">基本信息</h3> 
        </div> 
          <div style="padding:10px;"> 
	<table width="100%">
		<tr>
			<td><a href="${pageContext.request.contextPath}/addEmployee.jsp">添加</a>&nbsp&nbsp<a
				href="javascript:delMulti()">删除</a></td>
		</tr>
		<tr>
			<td><c:if test="${empty em}">对不起，没有任何员工信息。</c:if> <c:if
					test="${!empty em}">
					<table width="100%" border="1">
						<tr>
							<th>选择</th>
							<th>员工号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>电话</th>
							<th>email</th>
							<th>工资</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${cs}" var="c" varStatus="vs">
							<tr>
								<td><input type="checkbox" name="ids" value="${c.id}"></td>
								<td nowrap="nowrap">${c.id}</td>
								<td nowrap="nowrap">${c.name}</td>
								<td nowrap="nowrap">${c.gender=="1"?"男":"女"}</td>
								<td nowrap="nowrap">${c.cellphone}</td>
								<td nowrap="nowrap">${c.email}</td>
								<td nowrap="nowrap">${c.salary}</td>
								<td><a
									href="${pageContext.request.contextPath}/servlet/UpdateEmployeeServletUI?employeeId=${c.id}">修改</a>&nbsp&nbsp<a
									href="javascript:delOne('${c.id}')">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if></td>
		</tr>
		<tr>
  			<td align="center">
  				<%@include file="/commons/page.jsp"%>
  			 </td>
  		</tr>
	</table>
	</form>
	<script type="text/javascript">
		function delOne(employeeId) {
			var sure = window.confirm("确定要删除吗？");
			if (sure) {
				window.location.href = "${pageContext.request.contextPath}/servlet/DelOneServlet?employeeId="
						+ employeeId;
			}
		}
		function delMulti() {
			var idsObj = document.getElementsByName("ids");//数组
			//alert(idsObj.length);
			var selected = false;//是否选择了
			for (var i = 0; i < idsObj.length; i++) {
				if (idsObj[i].checked) {
					selected = true;
					break;
				}
			}
			if (selected) {
				//选择了
				var sure = window.confirm("确定要删除吗？");
				if (sure) {
					document.getElementById("f1").submit();//提交表单
				}
			} else {
				alert("请先选择要删除的记录");
			}
		}
	</script>
  </div>
          </div>
</body>
</html>