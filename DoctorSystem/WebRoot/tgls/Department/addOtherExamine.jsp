<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>科室/章节录入</title>
    
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
		<table class="layui-hide" id="OtherExamine" lay-filter="OtherExamine"></table>
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

	<!--生活状况内容  -->
	<div id="div_addmajor" style="display: none;text-align: center; ">
		<form class="layui-form" action="">
			<div class="layui-col-md7">
			<br>
				<div class="layui-form-item">
					<label class="layui-form-label">检查项目</label>
					<div class="layui-input-inline" style="width:255px;">
						<input type="text" name="otherexamineitem" id="otherexamineitem" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">参数</label>
					<div class="layui-input-inline" style="width:255px;">
						<input type="text" name="otherexamineparam" id="otherexamineparam" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">病人编号</label>
					<div class="layui-input-inline" style="width:255px;">
						<input type="text" name="patientid" id="patientid" required lay-verify="required" placeholder="例：13000000000" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-col-md5">
				<div class="layui-upload">
					<div class="layui-upload-list">
					    <img class="layui-upload-img" id="demo1" style="width:200px;height:200px;">
					    <p id="demoText"></p>
					  </div>
					  <button style="margin-left:20px;" type="button" class="layui-btn" id="test1">上传图片</button>
					</div>  
				</div>	
				<div class="layui-form-item">
						<button class="layui-btn" lay-submit lay-filter="submitBut" id="btn_otherexamine">立即提交</button>
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
			elem : '#OtherExamine',
			id:'OtherExamine',
			url : 'OtherExamine/getOtherExaminelist',
			title : '',
			height : "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [{
					field : 'otherexamineid',
					align : 'center',
					title : '编号',
				},{
					field : 'otherexamineitem',
					align : 'center',
					title : '检查项目',
					
				}, {
					field : 'otherexamineparam',
					align : 'center',
					title : '参数',
						
				},
				{
					field : 'patientid',
					align : 'center',
					title : '病人编号',
						
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
		table.on('tool(OtherExamine)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event;
		  //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var tr = obj.tr; //获得当前行 tr 的DOM对象
		  if(layEvent === 'delete'){ //删除
		    layer.confirm('真的删除行么', function(index){
		      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
		      layer.close(index);
		      //向服务端发送删除指令
		      	$.post("OtherExamine/deletOtherExamine",{otherexamineid:obj.data.otherexamineid},function(flag){
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
		               content:'./tgls/edit/edit_OtherExamine.jsp',
		               btn: ['确定', '取消'],
		               yes: function(index, layero){
			           //点击确认触发 iframe 内容中的按钮提交
			           var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
			           submit.click();
			           //表格刷新
		          	   table.reload('OtherExamine');
			        },
		               success : function(layero, index){
				            var body = layui.layer.getChildFrame('body', index);
				            if(layEvent === 'edit'){
				                // 取到弹出层里的元素，并把编辑的内容放进去
				                body.find("#otherexamineid").val(obj.data.otherexamineid);  //将选中的数据的id传到编辑页面的隐藏域，便于根据ID修改数据
				                body.find("#otherexamineitem").val(obj.data.otherexamineitem); 
				                body.find("#otherexamineparam").val(obj.data.otherexamineparam);
				                body.find("#patientid").val(obj.data.patientid);
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
	$("#btn_otherexamine").click(function(){
			var otherexamineitem=$("#otherexamineitem").val();
			var otherexamineparam=$("#otherexamineparam").val();
			var patientid=$("#patientid").val();
			var obj = {
						"otherexamineitem":otherexamineitem,
						"otherexamineparam":otherexamineparam,
						"patientid":patientid
						};
			$.ajax({
					url : 'OtherExamine/addOtherExamine',
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
<script>//图片上传
			layui.use('upload', function(){
			  var $ = layui.jquery
			  ,upload = layui.upload;
				var uploadInst = upload.render({
				    elem: '#test1'
				    ,url: '/upload/'
				    ,before: function(obj){
				      //预读本地文件示例，不支持ie8
				      obj.preview(function(index, file, result){
				        $('#demo1').attr('src', result); //图片链接（base64）
				      });
				    }
				    ,done: function(res){
				      //如果上传失败
				      if(res.code > 0){
				        return layer.msg('上传失败');
				      }
				      //上传成功
				    }
				    ,error: function(){
				      //演示失败状态，并实现重传
				      var demoText = $('#demoText');
				      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
				      demoText.find('.demo-reload').on('click', function(){
				        uploadInst.upload();
				      });
				    }
				  });
				  });
			</script>  
</body>
</html>
