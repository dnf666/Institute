$(function(){

    $('body').delegate('.modify','click', function() {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var zhiwu = $(this).parent().parent().children().find('input[name="zhiwu"]');
		var whereabout = $(this).parent().parent().children().find('input[name="whereabout"]');
		var jianjie = $(this).parent().parent().children().find('textarea[name="jianjie"]');
		var grade = $(this).parent().parent().children().find('input[name="grade"]');
        var xibie = $(this).parent().parent().children().find('input[name="xibie"]');
		var id=$(this).parent().parent().children().find('input[name="id"]');
		// initialize a JSON object
		if(name.val()=="" || zhiwu.val()=="" || whereabout.val()=="" || jianjie.val()=="" ||grade.val()=="" || xibie.val()==""){
			alert("有值为空！");
			return false;
		}
		var readyData = {
				id:id.val(),
				name: name.val()==name.prop('defaultValue') ? null : name.val(),
				zhiwu: zhiwu.val()==zhiwu.prop('defaultValue') ? null : zhiwu.val(),
				whereabout: whereabout.val()==whereabout.prop('defaultValue') ? null : whereabout.val(),
				grade:grade.val()==grade.prop('defaultValue') ? null : grade.val(),
				jianjie: jianjie.val()==jianjie.prop('defaultValue') ? null : jianjie.val(),
                xibie: xibie.val()==xibie.prop('defaultValue') ? null : xibie.val(),
		};
		if( readyData.name==null && readyData.zhiwu==null && readyData.whereabout==null && readyData.jianjie==null &&readyData.grade==null && readyData.xibie==null){
			alert("没有修改,不用保存！");
			return false;
		}
		$.post("control/grad/modifyGrad.do", readyData, function(res) {
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
		
		$.post('control/grad/delGrad.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.add').on('click', function(event) {
		// get selectors
		var name = $(this).parent().parent().children().find('input[name="name"]');
		var zhiwu = $(this).parent().parent().children().find('input[name="zhiwu"]');
		var whereabout = $(this).parent().parent().children().find('input[name="whereabout"]');
		var grade = $(this).parent().parent().children().find('input[name="grade"]');
		var jianjie = $(this).parent().parent().children().find('textarea[name="jianjie"]');
		var file=$(this).parent().parent().children().find('input[name="file"]');
        var xibie = $(this).parent().parent().children().find('input[name="xibie"]');
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		if(xibie.val()==""||name.val()=="" || zhiwu.val()=="" || whereabout.val()=="" || jianjie.val()=="" ||grade.val()==""){
			alert("有值为空！");
			return false;
		
		}
		// initialize a JSON object
		 $.ajax({  
	         url: 'control/grad/addGrad.do' ,  
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
