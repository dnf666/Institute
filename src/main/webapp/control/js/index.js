$(function(){
    $('body').delegate('.modify','click', function() {
		var file=$(this).parent().parent().children().find('input[name="file"]');
		alert(file);
		if(file.val()=="" ){
			alert("文件为空！");
			return false;
		}
		         var file= $("#img1").val();
		         xhr.open("post", "photo.ashx", true);
		         xhr.onreadystatechange = changing;
		         xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		          xhr.send("img=" +file+"&id="+id);
		  
		     function changing() {
		         if (xhr.readystate == 4) {
		             if (xhr.status == 200) {
		                 var uo = xhr.responseText;
		                 if(uo=="ok")
		                 {
		                    alert("修改成功！");
		                  }
		                  else
		                  {
		                  alert("修改失败！");
		                  }
		             }
		             else {
	                 alert(xhr.status);
		            }
		         }
		     }
		         
		/*$.ajax({
			url:'modifyPicture.do',
            cache: true,
            type: "POST",
            data:file.val(),// 你的formid
            async: false,
            contentType:false,  
            error: function(resquest) {
                alert("Connection error");
            },
            success: function(data) {
                alert(data.msg);
            }
        });*/
});
});

