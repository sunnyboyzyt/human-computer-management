<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>密码修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
		<script type="text/javascript" src="layui/layui.js"></script>

  </head>
  
  <body>
     <div class="cBody">
			<form id="addForm" class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label">用户账号</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="userid" id="userid" required lay-verify="required" autocomplete="off" class="layui-input" value="${loginuser.userid }" readonly unselectable="on" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">当前用户</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="name" id="name" required lay-verify="required" autocomplete="off" class="layui-input" value="${loginuser.name }" readonly unselectable="on">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">原始密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="oldpassword" id="oldpassword" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="password" id="password"required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认新密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="password2" id="password2"required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submitBut" id="btn_updetPWd">确认修改</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
<script type="text/javascript" src="./js/md5.js"></script>
<script type="text/javascript" src="./js/systempublickey.js"></script>
<script src="./framework/area.js"></script>
<script src="./framework/province.js"></script>
<script src="./js/Bookkeep.js"></script>
<script>
	layui.use([ 'table', 'form', 'layer',  'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
		layer = layui.layer, $ = layui.jquery,
		element = layui.element;
		
		
		$("#btn_updetPWd").click(function(){
			var newpwd=$("#newpwd").val();
			var oldpwd=$("#oldpwd").val();
			var testpwd=$("#testpwd").val();
			var oleenpwd = hex_md5(fix(userid,oldpwd));
			var newenpwd = hex_md5(fix(userid,newpwd));
			var userid=$("#userid").val();
			var obj = {	
						"userid":userid,
						"newenpwd":newenpwd,
						"oleenpwd":oleenpwd,
						"testpwd":testpwd
						};
			$.ajax({
					url : 'user/Updetpwd',
					type : "POST",
					data : obj, //直接传对象参数 
					dataType : 'json',
					success:function(e){
					//alert(e.msg)
					if(e.code == 10001){
						layer.msg(e.msg,{icon:6}); 
					}else{
						layer.msg(e.msg,{icon:5});
					}
					},
				error:function(e){
					layer.msg(e.msg,{icon:5});
				}
				});
		});
		})
</script>	

		</div>
  </body>
</html>
