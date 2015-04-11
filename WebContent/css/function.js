String.prototype.len = function()
{ 
    return this.replace(/[^\x00-\xff]/g, "xx").length; 
} 
$(document).ready(function() {
			//聚焦第一个输入框
			
			//为inputForm注册validate函数
			$.validator.addMethod("mobile", function(value, element) { 
				var length = value.length; 
				var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(14[0-9]{1})|(18[0-9]{1}))+\d{8})$/ ;
				return this.optional(element) || (length == 11 && mobile.test(value)); 
				}, "手机格式错误");
			$.validator.addMethod("chinese", function(value, element) {  
				var chinese = /^[\u4e00-\u9fa5]+$/;  
				return (chinese.test(value)) || this.optional(element);  
				}, "只能输入中文");
			$("#inputForm").validate({
				rules : {
					sid : {
// 检查学号是否存在待完成 TODO
//						remote : {
//							url : "studentController.do?getStuinfo&type=vail&callback=?",
//							type : "get",
//							dataType : "jsonp",
//							data : {
//								sid : function() {
//									return $("#sid").val();
//								}
//							}
//						}
						maxlength:10,
						minlength:10
					},
					hobbies : {
						maxlength : 50
					}
				},
				
				messages: {
					sid: {
						//remote: "学号不存在",
						maxlength:"学号不正确",
						minlength:"学号不正确"
					}
				}
			});

			$('.radio').iCheck({
				checkboxClass: 'icheckbox_square-blue',
				radioClass: 'iradio_square-blue',
				increaseArea: '20%' // optional
			});
			$('#sex1').iCheck('check');
			
			$("#major").append("<option>通信工程</option>  <option>广播电视工程</option>  <option>通信技术</option>"); 
			
			$("#department").change(function(){
			major($("#department").val())
			});
			
			$("#cet").change(function(){
				if($("#cet").val()=='其他'){
					$("#cet").attr("name","ceto");
					$("#ceto").attr("name","cet");
					$("#ceto").attr("type","text");
					$("#cetd").removeClass("invisible hidden");
					$("#cetd").css("display","none");
					$("#cetd").addClass("help-block");
					$("#cetd").slideDown();
					
				}else{
					$("#cetd").slideUp();
					$("#cet").attr("name","cet");
					$("#ceto").attr("name","ceto");
					$("#ceto").attr("type","hidden");
					$("#cetd").addClass("invisible hidden");
					$("#cetd").removeClass("help-block");
				}
			});
			$("#cct").change(function(){
				if($("#cct").val()=='其他'){
					$("#cct").attr("name","ccto");
					$("#ccto").attr("name","cct");
					$("#ccto").attr("type","text");
					$("#cctd").removeClass("invisible hidden");
					$("#cctd").css("display","none");
					$("#cctd").addClass("help-block");
					$("#cctd").slideDown();
					
				}else{
					$("#cctd").slideUp();
					$("#cct").attr("name","cct");
					$("#ccto").attr("name","ccto");
					$("#ccto").attr("type","hidden");
					$("#cctd").addClass("invisible hidden");
					$("#cctd").removeClass("help-block");
				}
			});
			$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0,
		endDate: "1999-12-31"
    });
		

		
	$("#sid").blur(function(){
	$("#name").attr("readonly","readonly");
	$.getJSON("studentController.do?getStuinfo&sid="+$("#sid").val(),function(result){
	  if(result =='registed'){
		 $("#sid").val('该学号已报名，只可修改信息！');
	  }else{
		  if(result!=false){
		      $("#name").val(result.name);
			  if(result.sex=='男'){
			     $('#sex1').iCheck('check');
				 $('#sex1').iCheck('enable');
				 $('#sex2').iCheck('disable');
			  }else if(result.sex=='女'){
				 $('#sex2').iCheck('check');
				 $('#sex2').iCheck('enable');
				 $('#sex1').iCheck('disable');
			  }
			  $("#department").empty().append("<option>"+result.department+"</option>");
			  $("#major").empty().append("<option>"+result.major+"</option>");
			  $("#grade").val(result.grade).attr("readonly","readonly");
			  $("#classno").val(result.classno).attr("readonly","readonly");
			  }else{
			  $("#name").val('').removeAttr("readonly","readonly");
			  $("#department").empty().append("<option>通信工程系</option><option>计算机科学系</option><option>工商管理系</option><option>外国语言文学系</option><option>自动化系</option><option>电子工程系</option><option>管理工程系</option>"); 
			  $("#major").empty().append("<option>通信工程</option>  <option>广播电视工程</option>  <option>通信技术</option>"); 
			  $("#grade").val('').removeAttr("readonly","readonly");
			  $("#classno").val('').removeAttr("readonly","readonly");
			   $('#sex1').iCheck('enable');
			   $('#sex2').iCheck('enable');
			  ;}
	  }
	  
  });
});

});

$(document).ready(function() {
	$("#remodify_btn").click(function() {
		$("#inputForm").attr('action','enrolController.do?enrolReg');
		$("#inputForm").submit();
	});

});

function major(str){
$("#major").empty();
	switch(str){
		case '通信工程系':
			$("#major").append("<option>通信工程</option>  <option>广播电视工程</option>  <option>通信技术</option>"); 
			break;
		case '计算机科学系':
			$("#major").append("<option>计算机科学与技术</option><option>网络工程</option><option>软件工程</option><option>数字媒体技术</option><option>物联网工程</option><option>计算机应用技术</option><option>计算机网络技术</option>"); 
			break;
		case '工商管理系':
			$("#major").append("<option>工商管理</option><option>市场营销</option><option>财务管理</option><option>工商企业管理</option>"); 
			break;
		case '外国语言文学系':
			$("#major").append("<option>英语</option><option>德语</option>"); 
			break;
		case '自动化系':
			$("#major").append("<option>电气工程及其自动化</option><option>自动化</option><option>电气工程与自动化</option><option>机械设计制造及其自动化</option><option>轨道交通信号与控制</option><option>机械电子工程</option><option>电气自动化技术</option>"); 
			break;
		case '电子工程系':
			$("#major").append("<option>电子信息工程</option><option>电子信息科学与技术</option><option>应用电子技术</option>"); 
			break;
		case '管理工程系':
			$("#major").append("<option>信息管理与信息系统</option><option>工程管理</option>"); 
			break;
		 }
}
