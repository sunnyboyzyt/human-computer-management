<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师学生编辑</title>
    
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
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
		</style>

  </head>
  
  <body>
		<div class="cBody">
			<form id="addForm" class="layui-form" action="">
				<div class="layui-col-md7">
				<div class="layui-form-item">
					<label class="layui-form-label" style="width:80px;">工号/学号</label>
					<div class="layui-input-inline" style="width:180px;">
						<input type="text" name="userid" id="userid" readonly  unselectable="on" style="background-color: #F2F2F2" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">性别</label>
				    <div class="layui-input-block" style="width:180px;">
				      <select name="city" lay-verify="required" id="gender">
				        <option value="0">男</option>
				        <option value="1">女</option>
				       
				      </select>
				    </div>
				  </div>
				<div class="layui-form-item">
					<label class="layui-form-label"style="width:80px;">班级</label>
					<div class="layui-input-inline" style="width:180px;">
						<input type="text" name="classid" id="classid" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"style="width:80px;">电话</label>
					<div class="layui-input-inline" style="width:180px;">
						<input type="text" name="phone" id="phone" required lay-verify="required" placeholder="例：13000000000" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block" style="width:300px;height:100px;">
						<textarea name="remarks" id="remarks" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
			<div class="layui-col-md5">
				<!-- <div class="layui-upload">
					<div class="layui-upload-list">
					    <img class="layui-upload-img" id="demo1" style="width:200px;height:200px;">
					    <p id="demoText"></p>
					  </div>
					  <button style="margin-left:20px;" type="button" class="layui-btn" id="test1">上传图片</button>
					</div>  -->
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
			
			var userid=$("#userid").val();
			var name=$("#name").val();
			var gender = $("#gender").val();
			var phone=$("#phone").val();
			var classid=$("#classid").val();
			var remarks=$("#remarks").val();
			var param = "?userid=" + userid + "&name=" +name + "&gender=" +gender + "&phone=" +phone +"&classid=" +classid +"&remarks="+remarks;
			$.ajax({
				url:"user/modifyUser" + param,
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
						parent.layui.table.reload('User'); //重载表格
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
