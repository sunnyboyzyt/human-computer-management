<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>心理社会状况</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 公共样式 结束 -->
  </head>
  
 <body>
		<div class="cBody">
			<form id="addForm" class="layui-form" action="">
				<div class="layui-col-md6">
					 <div class="layui-form-item">
					<div class="layui-form-item">
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">心里社会状况编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled="disabled" style="background-color: #F2F2F2"  id="mentalsocietyid" name="mentalsocietyid" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				   <div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">自我概念</label>
						<div class="layui-input-inline">
							<input type="text" id="self" name="self" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">认知功能</label>
						<div class="layui-input-inline">
							<input type="text" id="knowability" name="knowability" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">情绪</label>
						<div class="layui-input-inline">
							<input type="tetx" id="mood" name="mood" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">对疾病的认识</label>
						<div class="layui-input-inline">
							<input type="text" id="sickknow" name="sickknow" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">应激与应对</label>
						<div class="layui-input-inline">
							<input type="text" id="stress" name="stress" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					
				</div>
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">价值观与信念</label>
						<div class="layui-input-inline">
							<input type="text" id="belief" name="belief" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">职业状况</label>
						<div class="layui-input-inline">
							<input type="text" id="career" name="career" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">生活与居住环境</label>
						<div class="layui-input-inline">
							<input type="text" id="environment" name="environment" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">家庭关系</label>
						<div class="layui-input-inline">
							<input type="text" id="familyrelationship" name="familyrelationship" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">病人编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled="disabled" style="background-color: #F2F2F2" id="patientid" name="patientid" required lay-verify="required"  class="layui-input">
						</div>
					</div>
				</div>	
				<div class="layui-form-item layui-hide">
			      <input type="button" lay-submit lay-filter="layuiadmin-app-form-submit" id="layuiadmin-app-form-submit" value="确认添加">
			      <input type="button" lay-submit lay-filter="layuiadmin-app-form-edit" id="layuiadmin-app-form-edit" value="确认编辑">
			    </div>
			</form>	
		</div>
 
<script type="text/javascript">
 layui.use(['table','jquery','form','layer'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var form=layui.form;
  var layer = layui.layer;
  
    //监听提交,添加事件
    form.on('submit(layuiadmin-app-form-submit)', function(data){
      var field = data.field; //获取提交的字段
      var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引  
			
			var mentalsocietyid=$("#mentalsocietyid").val().trim();
		    var self=$("#self").val().trim();
			var knowability=$("#knowability").val().trim();
			var mood=$("#mood").val().trim();
			var sickknow=$("#sickknow").val().trim();
			var stress=$("#stress").val().trim();
			var career=$("#career").val().trim();
			var belief =$("#belief ").val().trim();
			var environment=$("#environment").val().trim();
			var familyrelationship=$("#familyrelationship").val().trim();
			var patientid=$("#patientid").val().trim();		
			
			 var param = "?mentalsocietyid=" + mentalsocietyid + "&self=" +self + "&knowability=" +knowability + "&mood=" +mood + "&sickknow=" +sickknow + 
			 "&stress=" +stress + "&career=" +career + "&belief=" +belief + "&environment=" +environment + "&familyrelationship=" +familyrelationship + 
			 "&patientid=" +patientid;
			//alert(param)
			$.ajax({
				url:"MentalSociety/modifychiefMental" + param,
				type:"POST",
				data:null,
				dataType : "json",
				xhrFields :{
					withCredentials: true
				},
				contentType:'application/json;charset=UTF-8',
				success:function(e){
					//alert(e.msg)
					if(e.code == 10001){
						layer.msg(e.msg,{icon:6}); 
					}else{
						layer.msg(e.msg,{icon:5});
					}
					
					setTimeout(function(){
						parent.layui.table.reload('LAY-app-content-list'); //重载表格
     					parent.layer.close(index); //再执行关闭 
						parent.layui.table.reload('MentalSociety'); //重载表格
					},1*1000)
				},
				error:function(e){
					layer.msg(e.msg,{icon:5});
				}
			})
      	return false;
    });
});
</script>
 
	</body>
</html>
