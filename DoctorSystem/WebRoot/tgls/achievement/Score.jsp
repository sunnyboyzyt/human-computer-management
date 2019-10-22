<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成绩查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		

  </head>
  
  <body>
	<div class="">
			<div class="layui-row layui-col-space10">
			<form class="layui-form" action="">
			  <div class="layui-form-item">
			  <br><div class="layui-col-md2">
			  		 <div class="layui-form-item">
					    <div class="layui-input-inline" style="width:180px;">
					      <select name="city" lay-verify="required">
					        <option value="">班级</option>
					        <option value="0">2018级护理1班</option>
					      </select>
					    </div>
					  </div>
				 </div>	  
				 <div class="layui-col-md2">
				 	<div class="layui-form-item">
					    <div class="layui-input-inline" style="width:180px;">
					      <select name="city" lay-verify="required">
					        <option value="">场次</option>
					        <option value="0">第一场</option>
					        <option value="1">第二场</option>
					      </select>
					    </div>
					  </div>
				 </div>
				 <div class="layui-col-md8">
				 	<div class="layui-input-inline">
						<input style="width:200px;" placeholder="考生编号" type="text" name="price"class="layui-input">
					</div>
					<div class="layui-inline">
						<button id="btnselbackrole" type="button"class="layui-btn layuiadmin-btn-useradmin layui-btn-radius">查询</button>
					</div>
				 </div>
			  </div>
			  </form>
			</div>
			
		

		<table class="layui-hide" id="backrolesystemmodel" lay-filter="tool"></table>
		<script type="text/html" id="barDemo"> 
				  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>重置</a>
				  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        	 </script>
		<script type="text/html" id="selectbar">
				<input type="checkbox" name="{{d.deepth}}" value="{{d.id}}" title="授予" lay-filter="lockDemo" {{ d.isedit == "1" ? 'checked' : '' }}>
			</script>

		<script type="text/html" id="menuTypebar">
				<span>{{ d.deepth <= "1" ? '展开菜单' : '子菜单' }}</span>
			</script>

	</div>

	<!--弹窗内容 -->
	<div id="div_addmajor" style="display: none;text-align: center; ">
		<form class="layui-form" action="">
				
				   <div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">名称</label>
						<div class="layui-input-inline">
							<input type="text" name="price" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">开始时间</label>
						<div class="layui-input-inline">
							<input type="text" class="layui-input" id="test1">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">结束时间</label>
						<div class="layui-input-inline">
							<input type="text" class="layui-input" id="test2">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">所属章节</label>
						<div class="layui-input-inline">
							<input type="text" name="price" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<br>
					<br>
		
				
				<div class="layui-form-item">
						<button class="layui-btn" lay-submit lay-filter="submitBut">发布</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
		</form>
	</div>
	
	<script src="framework/area.js"></script>
	<script src="framework/province.js"></script>
	<script src="./js/Bookkeep.js"></script>
	<script>
layui.use(['form', 'layedit', 'laydate','table'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,table = layui.table
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  laydate.render({
    elem: '#datetime'
  });
  laydate.render({
    elem: '#date2'
  });
  table.render({
		elem: '#backrolesystemmodel',
		id:'backrolesys',
		url: 'bookkeep/bookkeepselect',
		loading: true,
		skin: 'line',
		height:'full-50',
		widht:'600',
		page: true,
		curr:1,
		limit: 7,
		limits: [10, 20, 30],
		even: true,
		cols: [
			[
			{
				field: 'scoreid',
				align: 'center',
				title: '编号'						
			} ,
			{
				field: 'examid',
				align: 'center',
				title: '所属考试'						
			} ,
			{
				field: 'userid',
				align: 'center',
				title: '学生'						
			} ,
			{
				field: 'score1',
				align: 'center',
				title: '问诊得分'						
			} ,
			{
				field: 'score2',
				align: 'center',
				title: '检查得分'						
			} ,
			{
				field: 'score3',
				align: 'center',
				title: '医疗诊断得分'						
			} ,
			{
				field: 'score4',
				align: 'center',
				title: '护理诊断得分'						
			} ,
			{
				field: 'allscore',
				align: 'center',
				title: '综合得分'						
			} ,
			{
				field: 'isedit',
				align: 'center',
				title: '操作',
				toolbar : '#barDemo'
			}]
		]
	});
});
  </script>
  <script>  //日期生成
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test1' //指定元素
  });
});
</script>
<script>  //日期生成
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test2' //指定元素
  });
});
</script>
</body>
</html>
