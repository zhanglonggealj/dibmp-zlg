$(function(){
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"name" : {
				required : true
			} ,
			"tid" : {
				required : true 
			},
			"stid" : {
				required : true 
			},
			"price" : {
				required : true ,
				number : true 
			},
			"weight" : {
				required : true ,
				digits : true 
			},
			"pic" : {
				required : true ,
				accept : ["jpg","png","gif","bmp"]
			},
			"note" : {
				required : true
			}
		}
	});
	$.ajax({
		url:"pages/back/admin/goods/allwitem.action",
		method:"post",
		data:{},
		dataType:"json",
		success:function(data){
			for(x=0;x<data.length;x++){
				witem=data[x];
				//Console.log("witem"+witem);
				$("#wiid").append("<option id='"+witem.wiid+"' value='"+witem.wiid+"'>"+witem.title+"</option>");
			}
		}
	})
	$(wiid).on("change",function(){
		wiid=$(this).val();
		$.ajax({
			url:"pages/back/admin/goods/allsubtype.action",
			method:"post",
			data:{
				"wiid":wiid
			},
			dataType:"json",
			success:function(data){
				$("#stid>option").remove();
				for(x=0;x<data.length;x++){
					subtype=data[x];
					$("#stid").append("<option id="+subtype.stid+" value='"+subtype.stid+"'>"+subtype.title+"</option>");
				}
			}
		})
	})
	
	/*$("button[id=submit]").on("click",function(){
		name=$("#name").val();
		wiid=$("#wiid").val();
		stid=$("#stid").val();
		price=$("#price").val();
		weight=$("#weight").val();
		pic=$("#pic").val();
		note=$("#note").val();
		console.log(name+"-"+wiid+"-"+stid+"-"+price+"-"+weight+"-"+pic+"-"+note);
		$.ajax({
			url:"pages/back/admin/goods/add_pre.action",
			method:"post",
			data:{
				"name":name,
				"wiid":wiid,
				"stid":stid,
				"price":price,
				"weight":weight,
				"pic":pic,
				"note":note,
			},
			dataType:"json"
				
		})
		operateAlert(true,"商品添加成功");
	})*/
	
})