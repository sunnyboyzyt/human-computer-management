layui.use([ 'table', 'form', 'layer', 'laydate','element' ],function() {
	var table = layui.table;
	form = layui.form, layer = layui.layer,
	laydate = layui.laydate, laytpl = layui.laytpl,
	element = layui.element,layedit=layui.layedit;
	/*
	 * 日常生活状态
	 */
	$("#btn_income").click(function(){
		layer.open({
			title:"日常生活状态",
			type: 1,
			area: ['700px'],
			skin: 'demo-class',
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_addmajor'),
			btn1: function(index, layero){
				$.ajax({
	        		type: 'get',
	        		url: "bookkeep/addbookeep",
	        		dataType: 'json',
	        		data:{
	        			money:money,
	        			datetime:datetime,
	        			payid:payid,
	        			sortid:sortid,
	        			type:1,
	        			remark:remark
	        		},
	        		success:function(data){
	        			if(data.code == 0){
	        				layer.confirm(data.msg, {
	        				icon: 1,
							  btn: ['确定']
							}, function(){
								table.reload("backrolesys", { //此处是上文提到的 初始化标识id
					                where: {
					                	
					                },page: {
					                curr:1
					                }
					            });	
								layer.closeAll();
							});          				 
	        			}
	        			else{
	        				layer.confirm(data.msg, {
	        					  icon: 6,
								  btn: ['确定']
							});
	        			}
	        		},
	        		
	        	});  
			},
			cancel: function(){ 
				$('#money').val("");
				$('#remark').val("");
				$("#date").val("");
			}
		});
	})
	
	
});
