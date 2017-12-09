$(function(){
    $('body').delegate('.modify','click', function() {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var url = $(this).parent().parent().children().find('input[name="url"]');
		var id= $(this).parent().parent().children().find('input[name="id"]');
		// initialize a JSON object
		if(name.val()=="" ||  url.val()=="" ){
			alert("有值为空！");
			return false;
		};
		var readyData = {
				id:id.val(),
				name: name.val()==name.prop('defaultValue') ? null : name.val(),
				url: url.val()==url.prop('defaultValue') ? null : url.val()
		};
		if(readyData.name==null &&  readyData.url==null ){
			alert("没有修改，不用保存");
			return false;
		}
		$.post('control/department/modifyDepartment.do', readyData, function(res) {
			alert(res.msg);
			location.reload();
		});
	});
	$('.del').on('click', function() {
		// get selectors
		var id= $(this).parent().parent().children().find('input[name="id"]');
		var pictureId=$(this).parent().parent().children().find('input[name="pictureId"]');
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				pictureId:pictureId.val()
		};
		$.post('control/department/delDepartment.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.add').on('click', function() {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var url = $(this).parent().parent().children().find('input[name="url"]');	
		var file=$(this).parent().parent().children().find('input[name="file"]');
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		if(name.val()=="" ||  url.val()=="" ){
			alert("有值为空！");
			return false;
		}
		//	提交表单
		$.ajax({
			url: 'control/department/addDepartment.do',
			type: 'POST',
			cache: false,
			data: new FormData($('#mform')[0]),
			processData: false,
		    contentType:false
		}).done(function(res){
			alert(res.msg);
			location.reload();
		});
	});
	
});
