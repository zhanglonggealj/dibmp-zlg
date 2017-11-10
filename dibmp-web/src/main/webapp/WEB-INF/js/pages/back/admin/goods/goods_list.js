$(function(){
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[1] ;
			operateAlert(true,"待出库商品添加成功！","待出库商品添加失败！") ;
		}) ;
	}) ;
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#goodsRecordInfo").modal("toggle") ; 
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			name = this.id.split("-")[1] ;
			
			$.ajax({
				url:"pages/back/admin/member/get.action",
				method:"post",
				data:{
					"name":name
				},
				dataType:"json",
				success:function(data){
					$("#bbbbb").empty();
					tr1=("<tr><td style='width:30%;'><strong>雇员姓名：</strong></td><td><span>"+data.member.name+"</span></td></tr>");
					tr2=("<tr><td><strong>雇员职位：</strong></td><td>"+data.level.title+"</td></tr>");
					tr3=("tr><td><strong>所属部门：</strong></td><td>"+data.dept.dname+"</td></tr>");
					tr4=("<tr><td><strong>联系电话：</strong></td><td>"+data.member.phone+"</td></tr>");
					tr5=("<tr><td><strong>备注信息：</strong></td><td><pre class='pre-scrollable' style='width:450px;height:150px;'>"+data.member.note+"</pre></td></tr>");
					$("#bbbbb").append(tr1);
					$("#bbbbb").append(tr2);
					$("#bbbbb").append(tr3);
					$("#bbbbb").append(tr4);
					$("#bbbbb").append(tr5);
				}
			/*$.post("pages/back/admin/member/get.action",{"mid":mid},function(data){
				console.log("data="+data);
				$(name).text(data.member.name);
				$(level).text(data.level.title);
				$(dept).text(data.dept.dname);
				$(phone).text(data.member.phone);
				$(note).text(data.member.note);
				$("#memberInfo").modal("toggle") ;
				
			},"json")*/
			
		})
		$("#memberInfo").modal("toggle") ;
		}) ;
	}) ;
})