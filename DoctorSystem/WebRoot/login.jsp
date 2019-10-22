<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="js/jquery-3.3.1.js" ></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	    <!--[if lt IE 9]-->
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <!-- [endif]-->
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript" src="js/login.js"></script>

  </head>
  
  <body>
   
		<div class="login_main">
			<!--轮播图 开始-->
			<div class="layui-carousel lbt" id="loginLbt">
				<div carousel-item>
					<div class="item" style="background: url(images/bg1.jpg) no-repeat; background-size: cover;"></div>
					<div class="item" style="background: url(images/bg2.jpg) no-repeat; background-size: cover;"></div>
				</div>
			</div>
			<!--轮播图 结束-->
			<div class="logo">
				<img src="images/logo.png" />
				<div>
					<h1>互联网人机交互在护理临床教学应用管理系统</h1>
					<p>版本号:19.3.01</p>
				</div>
			</div>
			<div class="form_tzgg">
				<div class="form">
					<form action="" method="post" class="layui-form">
						<div class="title">用户登录</div>
						<div class="con" onclick="getFocus(this)">
							<input type="text" id="user_name" name="user_name" lay-verify="user_name" placeholder="请输入您的用户名" autocomplete="off" class="layui-input">
						</div>
						<div class="con" onclick="getFocus(this)">
							<input type="password" id="user_password" name="user_password" required  lay-verify="user_password" placeholder="请输入您的账户密码" autocomplete="off" class="layui-input">
						</div>
						<!-- <div class="but">
							<button class="layui-btn" lay-submit lay-filter="formDemo" id="login-button">登录</button>
						</div> -->
						<div class="layui-form-item">
							
						    <button type="button" id="login-button" class="layui-btn " lay-filter="login" lay-submit="">登录</button>
						</div>
						
						<div class="apply"><a href="#">忘记密码</a></div>
					</form>
				</div>
				
				<script type="text/javascript" src="js/md5.js"></script>
				<script type="text/javascript" src="js/systempublickey.js"></script>
				<script type="text/javascript" src="js/jquery-3.3.1.js" ></script>
				<script>
					layui.use(['form','layer'], function(){
				var layer = layui.layer
				var form = layui.form;	  
				var $ = layui.jquery;
				
				/* 点击登录 ,用jquery判断输入的用户名、密码是否符合条件*/
				$("#login-button").click(function(){
					var username=$("#user_name").val().trim();
					var password=$("#user_password").val().trim();
			
					if(username==null || username=="" || username==undefined){
						$("#user_name").focus();
						layer.alert('用户名不能为空!', {icon: 2});
						return;
					}
					if(password==null || password=="" || password==undefined){
						$("#user_password").focus();
						layer.alert('密码不能为空!', {icon: 2});
						return;
					}
					if(password.length<6 || password.length>18){
						layer.alert('密码长度不符合规范!', {icon: 2});
						return;
					}
					
					/* 用MD5将密码做加密处理 */
					var enpwd = hex_md5(fix(username,password));
					$("#user_password").val(enpwd);
					var param = '?userid='+username+'&pwd='+enpwd;//参数组合
					/* alert(enpwd); */  
					var index = layer.load(0, {shade: 0.1});
					$.ajax({
						type : 'get',
						url : 'user/loginuser'+param,
						datatype : 'json',
						success : function(data) {
							/* alert(data.msg) */
							if (data.code == 10001) {
								layer.msg(data.msg,{icon:6}); 
								window.location.href = "frame.jsp";
							}else {
								layer.msg(data.msg,{icon:5});
								window.location.href = "login.jsp";
							}
						},
						error:function(data){
		    	        	layer.alert(data.msg, {icon: 5});
		    	        	window.location.href = "login.jsp";
		    	        }
					});
					return false;
				});
			});
			</script>
			
			
			
				<div class="tzgg">
					<div class="title">医学常识</div>
					<div class="con">
						<ul>
							<li><span>10-17</span><a href="#" target="_blank">牙齿美白后要常吃的10种食物！！</a></li>
							<li><span>10-16</span><a href="#" target="_blank">皮肤受伤了？当心白癜风出现！！</a></li>
							<li><span>10-15</span><a href="#" target="_blank">踝关节扭伤要如何急救？？</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
  </body>
</html>
