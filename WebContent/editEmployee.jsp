<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>编辑薪资信息</title>
</head>
<body style="text-align: center;">
  <div class="bs-docs-header" id="content"> 
   <div class="container" style="font-family:'微软雅黑'">
     <h1>薪资管理系统</h1> 
    <p>编辑薪资信息</p> 
   </div> 
   <p>&nbsp;</p> 
   <p>&nbsp;</p> 
  </div> 
  <div class="container"> 
   <div id="content"> 
    	<form action="${pageContext.request.contextPath}/servlet/UpdateEmployeeServlet" method="post">
    		<input type="hidden" name="id" value="${employee.id }"/>
		<div class="col-md-6 col-md-offset-3">
        <div class="panel panel-info"> 
        <div class="panel-heading"> 
         <h3 class="panel-title">基本信息</h3> 
        </div> 
          <div style="padding:10px;"> 
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">员工号</label> 
              <div class="col-sm-6">
    					<input type="text" class="form-control required"  disabled="disabled" name="id" value="${employee.id }"/>
              </div>
             </div> 
            </div>
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">姓名</label> 
              <div class="col-sm-6">
    					<input type="text" class="form-control required"  name="name" value="${formBean.name}${employee.name}"/>
              </div>
             </div> 
            </div>
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">性别</label> 
              <div class="col-sm-6">
    					<input  class="form-inline help-inline" type="radio" name="gender" value="1" ${employee.gender=="1"?"checked='checked'":""}${formBean.gender=="1"?"checked='checked'":""}/>男
    					<input  class="form-inline help-inline" type="radio" name="gender" value="0" ${employee.gender=="0"?"checked='checked'":""}${formBean.gender=="0"?"checked='checked'":""}/>女
              </div>
             </div> 
            </div>
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">生日(yyyy-MM-dd)</label> 
              <div class="col-sm-6">
    					<input type="text"  class="form-control required"  name="birthday" value="${formBean.birthday}${employee.birthday}"/>${formBean.errors.birthday}
              </div>
             </div> 
            </div>
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">电话</label> 
              <div class="col-sm-6">
    					<input type="text"  class="form-control required"  name="cellphone" value="${formBean.cellphone}${employee.cellphone}"/>
              </div>
             </div> 
            </div>
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">邮箱</label> 
              <div class="col-sm-6">
    					<input type="text" class="form-control required"  name="email" value="${formBean.email}${employee.email}"/>
              </div>
             </div> 
            </div>
    		<div class="control-group">
             <div class="row">
                <label class="col-sm-3 control-label" for="sid">薪水</label> 
              <div class="col-sm-6">
    					<input type="text"  class="form-control required"  name="salary" value="${formBean.salary}"/>
              </div>
             </div> 
            </div>
      <div class="clearfix" style=""></div> 
      <div  style="text-align:center"> 
       <div class="form-actions" style="margin-top:12px">
    					<input  class="btn btn-danger  btn-lg " type="submit" value="保存"/>
       </div>
      </div>
            </div>
          </div>
        </div>
        </fieldset>
    	</form>
        </div>

  </body>
</html>