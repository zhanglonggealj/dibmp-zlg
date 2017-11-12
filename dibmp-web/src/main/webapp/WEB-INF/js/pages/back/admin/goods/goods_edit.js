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
			retWiid = $("#retWiid").text() ;
			for(x=0;x<data.length;x++){
				witem=data[x];
				if(witem.wiid == retWiid){
					$("#wiid").append($("<option id='"+witem.wiid+"' value='"+witem.wiid+"' selected>"+witem.title+"</option>"));
				}else{
					$("#wiid").append($("<option id='"+witem.wiid+"' value='"+witem.wiid+"'>"+witem.title+"</option>"));
				}
			}
			$.ajax({
				url:"pages/back/admin/goods/allsubtype.action",
				method:"post",
				data:{
					"wiid":retWiid
				},
				dataType:"json",
				success:function(data){
					$("#stid>option").remove();
					for(x=0;x<data.length;x++){
						retStid = $("#retstid").text() ;
						subtype=data[x];
						if(subtype.stid==retStid){
							$("#stid").append("<option id="+subtype.stid+" value='"+subtype.stid+"' selected>"+subtype.title+"</option>");
						}else{
							$("#stid").append("<option id="+subtype.stid+" value='"+subtype.stid+"'>"+subtype.title+"</option>");
						}
					}
				}
			})
			$("#name").text();
			
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
					retStid = $("#retstid").text() ;
					subtype=data[x];
					if(subtype.stid==retStid){
						$("#stid").append("<option id="+subtype.stid+" value='"+subtype.stid+"' selected>"+subtype.title+"</option>");
					}else{
						$("#stid").append("<option id="+subtype.stid+" value='"+subtype.stid+"'>"+subtype.title+"</option>");
					}
				}
			}
		})
	})

})
