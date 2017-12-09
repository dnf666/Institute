$(function(){
	$('.login').on('click', function() {
		var username=$('input[name=userName]').val();
		var password=$('input[name=password]').val();
		var indexurl=$('input[name=indexurl]').val();
		if(username=="" || password==""){
			alert("有值为空！");
			return false;
		}
	/*	$.ajax({
			url:'user/login.do',
            cache: true,
            type: "POST",
            data:$('#myform').serialize(),// 你的formid
            //async: false,
            error: function(resquest) {
                alert("Connection error");
            },
            success: function(data) {
               // $("#commonLayout_appcreshi").parent().html(data);
                alert(data.msg);
                location.reload();
            }
        });*/
		
		var readyData = {
				userName:username,
				password:password
		};
		$.post('control/user/login.do', readyData, function(res) {
			if(res.msg=="success"){
				   window.location.href = indexurl;
			}
			else{
				alert(res.msg);
			}
		});
});
});

