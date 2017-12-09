$(function(){

    $('body').delegate('.modify','click', function() {
		// get selectors
		var title = $(this).parent().parent().children().find('input[name="title"]');
		var leader = $(this).parent().parent().children().find('input[name="leader"]');
		var id=$(this).parent().parent().children().find('input[name="id"]');
		if(title.val()=="" || leader.val()=="" ){
			alert("有值为空！");
			event.preventDefault();
			return false;
		}
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				title: title.val()==title.prop('defaultValue') ? null : title.val(),
				leader: leader.val()==leader.prop('defaultValue') ? null : leader.val()
		};
		
		if(readyData.title==null && readyData.leader==null){
			alert("没有修改，不用保存！");
			event.preventDefault();
			return false;
		}
		$.post(	'control/doingProject/modifyDoingProject.do', readyData,  function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.add').on('click', function(event) {
		// get selectors
		var title = $(this).parent().parent().children().find('input[name="title"]');
		var leader = $(this).parent().parent().children().find('input[name="leader"]');
		// initialize a JSON object
		var readyData = {
				title: title.val(),
				leader: leader.val()
		};
		if(readyData.title=="" || readyData.leader=="" ||readyData.title==null || readyData.leader==null){
			alert("有值为空！");
			event.preventDefault();
			return false;
		}
		$.post(	'control/doingProject/addDoingProject.do', readyData,  function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.validate').on('click', function(event) {
		// get selectors
		var id=$(this).parent().parent().children().find('input[name="id"]');
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				type:2
		};
		$.post(	'control/doingProject/validate.do', readyData,  function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.del').on('click', function(event) {
		var id=$(this).parent().parent().children().find('input[name="id"]');
		// initialize a JSON object
		var readyData = {
				id:id.val()
		};
		
		$.post(	'control/doingProject/delDoingProject.do', readyData,  function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
});
