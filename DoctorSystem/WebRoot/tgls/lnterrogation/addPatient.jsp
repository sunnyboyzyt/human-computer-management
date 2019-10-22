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
			  <br>
				      <div class="layui-input-inline">
						<input style="width:200px;" type="text" name="price"class="layui-input">
					</div>
					<div class="layui-inline">
						<button id="btnselbackrole" type="button"class="layui-btn layuiadmin-btn-useradmin layui-btn-radius">查询</button>
					</div>
					<div class="layui-inline">
							<button class="layui-btn layuiadmin-btn-useradmin layui-btn-radius" type="button"id="btn_income">添加</button>
						</div>
			  </div>
			</form>
			</div>
			
		<table class="layui-hide" id="Patient" lay-filter="Patient"></table>
		<script type="text/html" id="barDemo"> 
				  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
			     <a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
        	 </script>
		<script type="text/html" id="selectbar">
				<input type="checkbox" name="{{d.deepth}}" value="{{d.id}}" title="授予" lay-filter="lockDemo" {{ d.isedit == "1" ? 'checked' : '' }}>
			</script>

		<script type="text/html" id="menuTypebar">
				<span>{{ d.deepth <= "1" ? '展开菜单' : '子菜单' }}</span>
			</script>

	</div>

	<!--弹窗内容-->
	<div id="div_addmajor" style="display: none;text-align: center; ">
		<form class="layui-form" action="">
				<div class="layui-col-md6">
				   <div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="name" id="name" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">年龄</label>
						<div class="layui-input-inline">
							<input type="text" name="age" id="age" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				<div class="layui-form-item">
				    <label class="layui-form-label">性别</label>
				    <div class="layui-input-block" style="width:210px;">
				      <select name="gender" lay-verify="required" id="gender" lay-filter="gender">
				        <option value="0">男</option>
				        <option value="1">女</option>
				      </select>
				    </div>
				  </div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">职业</label>
						<div class="layui-input-inline">
							<input type="text" name="job" id="job" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">民族</label>
						<div class="layui-input-inline">
							<input type="text" name="nationality" id="nationality" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">籍贯</label>
						<div class="layui-input-inline">
							<input type="text" name="birthplace" id="birthplace" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				<div class="layui-form-item">
					<label class="layui-form-label">婚否</label>
					<div class="layui-input-block" style="width:210px;">
				      <select name="gender" lay-verify="required" id="marriage" lay-filter="marriage">
				        <option value="0">是</option>
				        <option value="1">否</option>
				      </select>
				    </div>
					</div>
				</div>
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">文化程度</label>
						<div class="layui-input-inline">
							<input type="text" name="culture" id="culture" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">宗教信仰</label>
						<div class="layui-input-inline">
							<input type="text" name="faith" id="faith" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">家庭住址</label>
						<div class="layui-input-inline">
							<input type="text" name="addr" id="addr" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"style="width:100px;">联系电话</label>
						<div class="layui-input-inline">
							<input type="text" name="phone" id="phone" required lay-verify="required|phone" placeholder="例：13000000000" autocomplete="off" class="layui-input">
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
							<input type="text" name="unitid" id="unitid" required lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
						<button class="layui-btn" id="btn_addPatient" lay-submit lay-filter="submitBut">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
		</form>
	</div>
	
	<script src="framework/area.js"></script>
	<script src="framework/province.js"></script>
	<script src="./js/Bookkeep.js"></script>
	<script>
//查询开始
layui.use([ 'table', 'form', 'layer',  'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			element = layui.element;
		/*加载表格*/
		table.render({
			elem : '#Patient',
			id:'Patient',
			url : 'patient/getPatientlist',
			title : '',
			height : "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [{
					field : 'patientid',
					align : 'center',
					title : '编号',
				},{
					field : 'name',
					align : 'center',
					title : '姓名',
				}, {
					field : 'gender',
					align : 'center',
					title : '性别',
					
				}, {
					field : 'age',
					align : 'center',
					title : '年龄',
					
				}, {
					field : 'job',
					align : 'center',
					title : '职业',
					
				},{
					field : 'nationality',
					align : 'center',
					title : '民族',
				},{
					field : 'birthplace',
					align : 'center',
					title : '籍贯',
					
				}, {
					field : 'marriage',
					align : 'center',
					title : '婚否',
					
				}, {
					field : 'culture',
					align : 'center',
					title : '文化程度',
					
				}, {
					field : 'faith',
					align : 'center',
					title : '宗教信仰',
					
				},{
					field : 'addr',
					align : 'center',
					title : '家庭住址',
				}, {
					field : 'phone',
					align : 'center',
					title : '联系电话',
					
				}, {
					field : 'joindate',
					align : 'center',
					title : '入院时间',
					
				},{
					field : 'unitid',
					align : 'center',
					title : '所属科室/章节',
				},
				 {
					title: '操作',
					toolbar: '#barDemo',
					align: 'center',
					width : 180
					}] 
			 ],
			page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
			 }
		});
		table.on('tool(Patient)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var tr = obj.tr; //获得当前行 tr 的DOM对象
		  if(layEvent === 'delete'){ //删除
		    layer.confirm('真的删除行么', function(index){
		      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
		      layer.close(index);
		      //向服务端发送删除指令
		      	$.post("patient/deletPatient",{patientid:obj.data.patientid},function(flag){
	    			if(flag){
	    				layer.msg("刪除成功",{icon:6}); //表格刷新
				        table.reload('test'); //重载表格	
	    			}else{
	    				layer.msg("刪除失敗",{icon:5});
	    			}
		    	});
		    });
		   } else if(layEvent === 'edit'){ //编辑
		    //do something
		   //脚本编辑弹出层
	             var name = encodeURIComponent(data.toolName);
	             //alert(name);
	             layer.open({
		               type: 2,
		               title: '修改信息',
		               shadeClose: true,
		               shade: 0.5,
		               closeBtn:'1',//右上角xx关闭
		               area: ['600px','600px'],
		               content:'./tgls/edit/edit_Patient.jsp',
		               btn: ['确定', '取消'],
		               yes: function(index, layero){
			           //点击确认触发 iframe 内容中的按钮提交
			           var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
			           submit.click();
			           //表格刷新
		          	   table.reload('Patient');
			        },
		               success : function(layero, index){
				            var body = layui.layer.getChildFrame('body', index);
				            if(layEvent === 'edit'){
				                // 取到弹出层里的元素，并把编辑的内容放进去
				                body.find("#patientid").val(obj.data.patientid);
				                body.find("#name").val(obj.data.name);
				                body.find("#gender").val(obj.data.gender);
				                body.find("#age").val(obj.data.age);
				                body.find("#job").val(obj.data.job);
				                body.find("#nationality").val(obj.data.nationality);
				                body.find("#birthplace").val(obj.data.birthplace);
				                body.find("#marriage").val(obj.data.marriage);
				                body.find("#culture").val(obj.data.culture);
				                body.find("#faith").val(obj.data.faith);
				                body.find("#addr").val(obj.data.addr);
				                body.find("#phone").val(obj.data.phone);
				                body.find("#joindate").val(obj.data.joindate);
				                body.find("#unitid").val(obj.data.unitid);
				                // 记得重新渲染表单
		                		form.render();
				            }
				            setTimeout(function(){
				                layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
				                    tips: 3
				                });
				            },100)
				        }
	             });
	              //同步更新缓存对应的值
		    obj.update({
		      username: '123'
		      ,title: 'xxx'
		    });
		  }
		});
	//查询结束
	//添加一条基本信息方法开始
	$("#btn_addPatient").click(function(){
			var name=$("#name").val().trim();
			var age=$("#age").val().trim();
			var gender=$("#gender").val();
			var job=$("#job").val().trim();
			var nationality=$("#nationality").val().trim();
			var birthplace=$("#birthplace").val().trim();	
			var marriage=$("#marriage").val();
			var culture=$("#culture").val().trim();
			var faith=$("#faith").val().trim();
			var addr=$("#addr").val().trim();
			var phone=$("#phone").val().trim();			
			var joindate=$("#test1").val().trim();
			var unitid=$("#unitid").val().trim();
						
			var obj = {
						"name":name,
						"age":age,
						"genders":gender,
						"job":job,
						"nationality":nationality,
						"birthplace":birthplace,							
						"marriages":marriage,
						"culture":culture,
						"faith":faith,
						"addr":addr,
						"phone":phone,	
						"joindate":joindate,
						"unitid":unitid,				
						};
			$.ajax({
					url : 'patient/addpatient',
					type : "POST",
					data : obj, //直接传对象参数 
					dataType : 'json',
					success : function(data) {
							alert("添加成功!");
					},
					error:function(){
						
	    	        	$("#input").val("");
	    	        }  
				});	
			});
		//添加结束
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
</body>
</html>
