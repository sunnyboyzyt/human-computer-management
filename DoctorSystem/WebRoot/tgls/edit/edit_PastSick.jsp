<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>既往病史</title>
    
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
						<label class="layui-form-label"style="width:100px;">编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled="disabled" style="background-color: #F2F2F2"  id="pastsickid" name="pastsickid" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				    <div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">健康状况</label>
						<div class="layui-input-inline">
							<input type="text" id="pasthealth" name="pasthealth" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
      					<label class="layui-form-label"style="width:100px;">时间</label>
	      				<div class="layui-input-inline">
	       					<input type="text" class="layui-input" id="test1">
	      				</div>
     				</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">主要变现</label>
						<div class="layui-input-inline">
							<input type="text" id="realization" name="realization" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">诊疗经过</label>
						<div class="layui-input-inline">
							<input type="text" id="medical" name="medical" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">转归情况</label>
						<div class="layui-input-inline">
							<input type="text" id="returnsituation" name="returnsituation" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-col-md6">
					
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">有无外伤史</label>
						<div class="layui-input-inline">
							<input type="text" id="istrauma" name="istrauma" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">手术史</label>
						<div class="layui-input-inline">
							<input type="text" id="issurgery" name="issurgery" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">住院经历</label>
						<div class="layui-input-inline">
							<input type="text" id="hospital" name="hospital" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					 <div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">病人编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled="disabled" style="background-color: #F2F2F2"  id="patientid" name="patientid" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				 <div class="layui-form-item layui-hide">
			        <input type="button" lay-submit lay-filter="layuiadmin-app-form-submit" id="layuiadmin-app-form-submit" value="确认添加">
			        <input type="button" lay-submit lay-filter="layuiadmin-app-form-edit" id="layuiadmin-app-form-edit" value="确认编辑">
			    </div>
			</form>	
		</div>
		
<script>  //日期生成
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test1' //指定元素
  });
});
</script>

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
			
			var pastsickid=$("#pastsickid").val().trim();
		    var pasthealth=$("#pasthealth").val().trim();
			var date=$("#test1").val().trim();
			var realization=$("#realization").val();
			var medical=$("#medical").val().trim();
			var returnsituation=$("#returnsituation").val().trim();
			var istrauma=$("#istrauma").val().trim();
			var issurgery=$("#issurgery").val().trim();
			var hospital=$("#hospital").val();
			var patientid=$("#patientid").val().trim();	
			
			 var param = "?pastsickid=" + pastsickid + "&pasthealth=" +pasthealth + "&date=" +date + "&realization=" +realization + "&medical=" +medical + 
			 "&returnsituation=" +returnsituation + "&istrauma=" +istrauma + "&issurgery=" +issurgery + "&hospital=" +hospital + "&patientid=" +patientid;
			//alert(param)
			$.ajax({
				url:"PastSick/modifyPastSick" + param,
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
						parent.layui.table.reload('PastSick'); //重载表格
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
