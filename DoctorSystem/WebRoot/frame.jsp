<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frame.jsp' starting page</title>
    
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
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/frameStyle.css">
		<script type="text/javascript" src="framework/frame.js" ></script>

  </head>
  
  <body>
    <!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		        <img src="images/logo.png"/>
		        <div class="logoText">
		            <h1>医学护理系统</h1>
		            <p>yixuehulixitong</p>
		        </div>
		    </div>
		    <div class="menu">
		        <ul>
		        	<li>
		            	<a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>问诊<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addPatient.jsp',this)">基础情况录入</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addLife.jsp',this)">日常生活状态</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addChiefComplaint.jsp',this)">主诉</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addNowSick.jsp',this)">现病史</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addPastSick.jsp',this)">既往病史</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addPersonal.jsp',this)">个人史</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/lnterrogation/addMentalSociety.jsp',this)">心理社会状况</a></dt>
		                	
		                </dl>    
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>用户信息管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/agent/Teacher_add.jsp',this)">教师学生添加</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/agent/add_Role.jsp',this)">角色添加</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/agent/add_Class.jsp',this)">班级添加</a></dt>
						 </dl>
		            </li>
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>科室/章节管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                		<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/Department/addUnit.jsp',this)">科室/章节录入</a></dt>
		                </dl>
		            </li>
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>检查项<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                		<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/Department/addEasyExamine.jsp',this)">常规检查录入</a></dt>
		               	        <dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/Department/addOtherExamine.jsp',this)">辅助检查录入</a></dt> 
		               	</dl>
		            </li>
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>考试管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                		<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/achievement/addExamTime.jsp',this)">考试场次</a></dt>
		               	</dl>
		            </li>
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>成绩管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                		<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/achievement/Score.jsp',this)">成绩查询</a></dt>
		               	</dl>
		            </li>
		        </ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<img class="jt" src="images/top_jt.png"/>
				<div class="topMenu">
					<ul>
						<li><a href="javascript:void(0)" onclick="menuCAClick('tgls/modify_password.jsp',this)"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
						<li><a href="login.jsp"><i class="iconfont icon-084tuichu"></i>注销</a></li>
					</ul>
				</div>
			</div>
			<!-- 头部栏 - 结束 -->
			
			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
				</div>
				<div class="con">
					<iframe id="mainIframe" src="tgls/qdAPI.jsp" scrolling="no"></iframe>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
	
  </body>
</html>
