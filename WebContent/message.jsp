<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,abbr,address,cite,code,del,dfn,em,img,ins,kbd,q,samp,small,strong,sub,sup,var,b,i,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,input,textarea,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,figcaption,figure,footer,header,hgroup,menu,nav,section,summary,time,mark,audio,video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
	list-style:none;
	font-family:"微软雅黑";
}
div#titlebox {width:100%; margin:0 auto;text-align: center;height:600px;position:relative;}
div#titlebox_header{width:900px;height: 200px;margin:0 auto;text-align: center;position:relative;;z-index: 999;
margin-top:100px;
line-height:200px;}

</style>
</head>
<body>
<div id="titlebox">
  <div id="titlebox_header">${message }&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}">返回</a></div>
</div>
</body>
</html>