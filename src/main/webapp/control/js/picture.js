$(function(){
    $('body').delegate('.modify','click', function() {
		var file=$(this).parent().parent().children().find('input[name="file"]');
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		
	 $.ajax({  
         url: 'control/picture/modifyPicture.do' ,  
         type: 'POST',  
         data: new FormData($('#myform')[0]), 
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,
	 /*}).done(function(returndata) {
             alert(returndata.msg);
             //location.reload();
         });*/
         success: function (returndata) {  
             alert(returndata.msg);
             location.reload();
         },  
         error: function (returndata) {  
             alert("error!"); 
             location.reload();
         }  
    });  
         
});
});

