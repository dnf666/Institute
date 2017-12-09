$(function(){
	$('.updatePicture').on('click', function() {
		var updatePicture = $(this).parent().parent().children().find('input[name="updatePicture"]').val();
		
		 layer.open({
		      type: 2,
		      title: '预览修改图片',
		      shadeClose: true,
		      shade: false,
		      maxmin: false, //开启最大化最小化按钮
		      area: ['893px', '600px'],
		      content:updatePicture
		    });
});
});

