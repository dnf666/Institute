$(function(){
	var editor=null;
	
	KindEditor.ready(function(K) {
	editor=K.create('textarea[name="content"]');

	});
    $('body').delegate('.modify','click', function() {
		// get selectors
		editor.sync();
		
		var title = $('input[name="title"]');
		var content = $('textarea[name="content"]');
		var author = $('input[name="author"]');
		var keyword=$('input[name="keyword"]');
		var summary = $('textarea[name="summary"]');
		var id= $('input[name="id"]');
		// initialize a JSON object
		if(title.val()=="" || content.val()=="" || author.val()=="" ||keyword.val()=="" ||summary.val()=="" ){
			alert("有值为空!");
			return false;
		}
		var readyData = {
				id:id.val(),
				title: title.val()==title.prop('defaultValue') ? null : title.val(),
				content: content.val()==content.prop('defaultValue') ? null : content.val(),
				author: author.val()==author.prop('defaultValue') ? null : author.val(),
				keyword:keyword.val()==keyword.prop('defaultValue') ? null : keyword.val(),		
				summary:summary.val()==summary.prop('defaultValue') ? null : summary.val()
		};
		if(readyData.title==null &&  readyData.content ==null && readyData.author==null && readyData.summary==null &&readyData.keyword==null){
			alert("没有修改，不用保存");
			return false;
		}
		$.post('control/article/modifyArticle.do', readyData, function(res) {
			alert(res.msg);
			location.reload();
		});
	});
	$('.del').on('click', function() {
		// get selectors
		
		var id=$(this).parent().parent().children().find('input[name="id"]');
		// initialize a JSON object
		var readyData = {
				id:id.val()
		};
		$.post('control/article/delArticle.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	$('.notdel').on('click', function() {
		// get selectors
		
		alert("无法再删除了！");
	});
	$('.add').on('click', function() {
		// get selectors
		editor.sync();
		
		var title = $('input[name="title"]');
		var content = $('textarea[name="content"]');
		var author = $('input[name="author"]');
		var keyword=$('input[name="keyword"]');
		var summary = $('textarea[name="summary"]');
		// initialize a JSON object
		if(title.val()=="" || content.val()=="" || author.val()=="" ||keyword.val()=="" ||summary.val()=="" ){
			alert("有值为空!");
			return false;
		}
		var readyData = {
				title: title.val(),
				content: content.val(),
				author: author.val(),
				keyword:keyword.val(),		
				summary:summary.val()
		};
		$.post('control/article/addArticle.do', readyData, function(res) {
			alert(res.msg);
			location.reload();
		});
	});
	
	
});
