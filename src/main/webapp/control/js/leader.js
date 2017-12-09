$(function(){

    $('body').delegate('.modify','click', function() {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var xibie = $(this).parent().parent().children().find('input[name="xibie"]');
		var zhicheng = $(this).parent().parent().children().find('input[name="zhicheng"]');
		var jianjie = $(this).parent().parent().children().find('textarea[name="jianjie"]');
		var id=$(this).parent().parent().children().find('input[name="id"]');
		if(name.val()=="" || xibie.val()=="" || zhicheng.val()=="" || jianjie.val()==""){
			alert("有值为空！");
			return false;
		}
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				name: name.val()==name.prop('defaultValue') ? null : name.val(),
				xibie: xibie.val()==xibie.prop('defaultValue') ? null : xibie.val(),
				zhicheng: zhicheng.val()==zhicheng.prop('defaultValue') ? null : zhicheng.val(),
				jianjie: jianjie.val()==jianjie.prop('defaultValue') ? null : jianjie.val()
		};
		if(readyData.name==null && readyData.xibie==null && readyData.zhicheng ==null && readyData.jianjie==null){
			alert("没有修改，不用保存");
			event.preventDefault();
			return false;
		}
		$.post('control/leader/modifyLeader.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
		
	});
	$('.add').on('click', function(event) {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var xibie = $(this).parent().parent().children().find('input[name="xibie"]');
		var zhicheng = $(this).parent().parent().children().find('input[name="zhicheng"]');
		var jianjie = $(this).parent().parent().children().find('textarea[name="jianjie"]');
		var file=$(this).parent().parent().children().find('input[name="file"]');
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		if(name.val()=="" || xibie.val()=="" || zhicheng.val()=="" || jianjie.val()==""){
			alert("有值为空！");
			return false;
		}
		// initialize a JSON object
		 $.ajax({  
	         url: 'control/leader/addLeader.do' ,  
	         type: 'POST',  
	         data: new FormData($('#myform')[0]), 
	         async: false,  
	         cache: false,  
	         contentType: false,  
	         processData: false,  
	         success: function (returndata) {  
	             alert(returndata.msg);
	             location.reload();
	         },  
	         error: function (returndata) {  
	             alert(returndata.msg); 
	             location.reload();
	         }  
	    });  
	});
	$('.del').on('click', function(event) {
		// get selectors
		var id=$(this).parent().parent().children().find('input[name="id"]');
		var pictureId=$(this).parent().parent().children().find('input[name="pictureId"]');
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				pictureId:pictureId.val()
		};
		
		$.post('control/leader/delLeader.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
});
