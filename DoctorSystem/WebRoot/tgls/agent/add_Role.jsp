<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色添加</title>
    
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
	<div class="backRoleSysModel-con">
			<div class="layui-form-item">
				<form class="layui-form" action="">
				  <div class="layui-form-item" >
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
			<table class="layui-hide" id="Role" lay-filter="Role"></table>
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

	<!--角色项添加  -->
	<div id="div_addmajor" style="display: none;text-align: center; ">
		<form class="layui-form" action="">

				 
				<div class="layui-form-item">
					<label class="layui-form-label">角色名称</label>
					<div class="layui-input-inline" style="width:255px;">
						<input type="text" id="rolename" name="identity" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">角色描述</label>
					<div class="layui-input-inline" style="width:255px;">
						<input type="text" id="roledescription" name="identity" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					    <button class="layui-btn" lay-submit lay-filter="submitBut" id="btn_addRole">立即提交</button>
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
			elem : '#Role',
			id:'Role',
			url : 'Role/getRolelist',
			title : '',
			height : "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [{
					field : 'roleid',
					align : 'center',
					title : '角色编号',
				},{
					field : 'rolename',
					align : 'center',
					title : '角色名称',
					
				}, {
					field : 'roledescription',
					align : 'center',
					title : '角色描述',
						
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
		table.on('tool(Role)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var tr = obj.tr; //获得当前行 tr 的DOM对象
		  if(layEvent === 'delete'){ //删除
		    layer.confirm('真的删除行么', function(index){
		      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
		      layer.close(index);
		      //向服务端发送删除指令
		      	$.post("Role/deletRole",{roleid:obj.data.roleid},function(flag){
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
		               area: ['500px','500px'],
		               content:'./tgls/edit/edit_Role.jsp',
		               btn: ['确定', '取消'],
		               yes: function(index, layero){
			           //点击确认触发 iframe 内容中的按钮提交
			           var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
			           submit.click();
			           //表格刷新
		          	   table.reload('Role');
			        },
		               success : function(layero, index){
				            var body = layui.layer.getChildFrame('body', index);
				            if(layEvent === 'edit'){
				                // 取到弹出层里的元素，并把编辑的内容放进去
				                body.find("#roleid").val(obj.data.roleid);  //将选中的数据的id传到编辑页面的隐藏域，便于根据ID修改数据
				                body.find("#rolename").val(obj.data.rolename); 
				                body.find("#roledescription").val(obj.data.roledescription);
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
	//添加一条方法开始
	$("#btn_addRole").click(function(){
			var rolename=$("#rolename").val();
			var roledescription=$("#roledescription").val();
			var obj = {
						"rolename":rolename,
						"roledescription":roledescription,
						};
			$.ajax({
					url : 'Role/addRole',
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
		});
		//添加结束
  </script>
</body>
</html>
