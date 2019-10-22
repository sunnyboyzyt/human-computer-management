	<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基础信息录入</title>
    
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
		
		<!-- 公共样式结束 -->
		
		
  </head>
  
  <body>
		<div class="cBody">
			<form id="addForm" class="layui-form" action="">
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled="disabled" style="background-color: #F2F2F2"  id="patientid" name="patientid" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				   <div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">姓名</label>
						<div class="layui-input-inline">
							<input type="text" id="name" name="name" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">性别</label>
						<div class="layui-input-inline">
							<input type="text" id="gender" name="gender" required lay-verify="required|PriceCheck" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">年龄</label>
						<div class="layui-input-inline">
							<input type="text" id="age" name="age" required lay-verify="required|PriceCheck" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">职业</label>
						<div class="layui-input-inline">
							<input type="text" id="job" name="job" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">民族</label>
						<div class="layui-input-inline">
							<input type="text" id="nationality" name="nationality" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">籍贯</label>
						<div class="layui-input-inline">
							<input type="text" id="birthplace" name="birthplace" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">婚否</label>
						<div class="layui-input-inline">
							<input type="text" id="marriage" name="marriage" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					
				</div>
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">文化程度</label>
						<div class="layui-input-inline">
							<input type="text" id="culture" name="culture" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">宗教信仰</label>
						<div class="layui-input-inline">
							<input type="text" id="faith" name="faith" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">家庭住址</label>
						<div class="layui-input-inline">
							<input type="text" id="addr" name="addr" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">联系电话</label>
						<div class="layui-input-inline">
							<input type="text" id="phone" name="phone" required lay-verify="required|phone" placeholder="例：13000000000" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
      					<label class="layui-form-label"style="width:100px;">入院时间</label>
	      				<div class="layui-input-inline">
	       					<input type="text" class="layui-input" id="test1">
	      				</div>
      				</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">所属科室/章节</label>
						<div class="layui-input-inline">
							<input type="text" id="unitid" name="unitid" required lay-verify="required" autocomplete="off" class="layui-input">
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
			
			var patientid=$("#patientid").val().trim();
			var name=$("#name").val().trim();
			var age=$("#age").val().trim();
			var gender=$("#gender").val().trim();
			var job=$("#job").val().trim();
			var nationality=$("#nationality").val().trim();
			var birthplace=$("#birthplace").val().trim();	
			var marriage=$("#marriage").val().trim();
			var culture=$("#culture").val().trim();
			var faith=$("#faith").val().trim();
			var addr=$("#addr").val().trim();
			var phone=$("#phone").val().trim();			
			var joindate=$("#test1").val().trim();
			var unitid=$("#unitid").val().trim();	
			
			 var param = "?patientid=" + patientid + "&name=" +name + "&age=" +age + "&gender=" +gender + "&job=" +job + 
			 "&nationality=" +nationality + "&birthplace=" +birthplace + "&marriage=" +marriage + "&culture=" +culture + "&faith=" +faith + 
			 "&addr=" +addr + "&phone=" +phone + "&joindate=" +joindate + "&unitid=" +unitid;
			//alert(param)
			$.ajax({
				url:"patient/modifyPatient" + param,
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
						parent.layui.table.reload('Patient'); //重载表格
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
