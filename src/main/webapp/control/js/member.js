$(function(){

    $('body').delegate('.modify','click', function() {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var xibie = $(this).parent().parent().children().find('input[name="xibie"]');
		var zhiwu = $(this).parent().parent().children().find('input[name="zhiwu"]');
		var jianjie = $(this).parent().parent().children().find('textarea[name="jianjie"]');
		var id=$(this).parent().parent().children().find('input[name="id"]');
        var grade=$(this).parent().parent().children().find('input[name="grade"]');

		if(grade.val()=="" || name.val()=="" || xibie.val()=="" || zhiwu.val()=="" || jianjie.val()==""){
			alert("有值为空！");
			return false;
		}
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				name: name.val()==name.prop('defaultValue') ? null : name.val(),
				xibie: xibie.val()==xibie.prop('defaultValue') ? null : xibie.val(),
				zhiwu: zhiwu.val()==zhiwu.prop('defaultValue') ? null : zhiwu.val(),
				jianjie: jianjie.val()==jianjie.prop('defaultValue') ? null : jianjie.val(),
            grade: grade.val()==grade.prop('defaultValue') ? null : grade.val()

		};
		if(readyData.name==null && readyData.grade == null && readyData.xibie==null && readyData.zhiwu ==null && readyData.jianjie==null){
			alert("没有修改，不用保存");
			event.preventDefault();
			return false;
		}
		$.post('control/member/modifyMember.do', readyData, function(res) {
			 alert(res.msg);
             location.reload();
		});
	});
	$('.add').on('click', function(event) {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var xibie = $(this).parent().parent().children().find('input[name="xibie"]');
		var zhiwu = $(this).parent().parent().children().find('input[name="zhiwu"]');
		var jianjie = $(this).parent().parent().children().find('textarea[name="jianjie"]');
		var file=$(this).parent().parent().children().find('input[name="file"]');
        var grade = $(this).parent().parent().children().find('input[name="grade"]');
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		if(name.val()=="" || xibie.val()=="" || zhiwu.val()=="" || jianjie.val()==""|| grade.val()==""){
			alert("有值为空！");
			return false;
		}
		// initialize a JSON object
		
		 $.ajax({  
	         url: 'control/member/addMember.do' ,  
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
		
		$.post('control/member/delMember.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	
});
