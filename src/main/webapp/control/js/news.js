$(function(){
	var editor=null;
	KindEditor.ready(function(K) {
	editor=K.create('textarea[name="content"]');
	
	});
	var releaser1 = $('select[name="releaser"]').val();
    $('body').delegate('.modify','click', function() {
		// get selectors
		editor.sync();
		var title = $('input[name="title"]');
		var id=$('input[name="id"]');
		var content = $('textarea[name="content"]');
		var releaser = $('select[name="releaser"]');
		var summary = $('textarea[name="summary"]');
		if(summary.val()=="" || releaser.val()=="" || content.val()=="" || title.val()=="" ){
			alert("有值为空！");
			return false;
		
		}
		
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				title: title.val()==title.prop('defaultValue') ? null : title.val(),
				content: content.val()==content.prop('defaultValue') ? null : content.val(),
				releaser: releaser.val()==releaser1? null : releaser.val(),
				summary:summary.val()==summary.prop('defaultValue') ? null : summary.val()
		};
		if(readyData.title==null &&  readyData.content ==null && readyData.summary==null && readyData.releaser==null){
			alert("没有修改，不用保存");
			
			return false;
		}
		$.post('control/news/modifyNews.do', readyData, function(res) {
			alert(res.msg);
			location.reload();
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
		$.post('control/news/delNews.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.add').on('click', function(event) {
		// get selectors
		editor.sync();
		
		var title = $('input[name="title"]');
		var content = $('textarea[name="content"]');
		var releaser = $('select[name="releaser"]');
		var summary = $('textarea[name="summary"]');
		var file=$('input[name="file"]');
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		
		if(summary.val()=="" || releaser.val()=="" || content.val()=="" || title.val()=="" ){
			alert("有值为空！");
			return false;
		
		}
		// initialize a JSON object
		 $.ajax({  
	         url: 'control/news/addNews.do' ,  
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
});
