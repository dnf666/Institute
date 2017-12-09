$(function(){
    $('body').delegate('.modify','click', function() {
        // get selectors
        console.log(1);
        var name = $(this).parent().parent().children().find('input[name="name"]');
        var phone = $(this).parent().parent().children().find('input[name="phone"]');
        var email= $(this).parent().parent().children().find('input[name="email"]');
        // initialize a JSON object
        if(name.val()=="" ||  phone.val()==""||email.val()==""){
            alert("有值为空！");
            return false;
        };
        var readyData = {
            name:name.val(),
            phone: phone.val()==phone.prop('defaultValue') ? null : phone.val(),
            email: email.val()==email.prop('defaultValue') ? null : email.val()
        };
        console.log(readyData);
        if( readyData.phone==null&&readyData.email==null){
            alert("没有修改，不用保存");
            return false;
        }
        $.post('control/extraMessage/addExtraMessage.do', readyData, function(res) {
            alert(res.msg);
            location.reload();
        });
    });
    // $('.del').on('click', function() {
    //     // get selectors
    //     var phone= $(this).parent().parent().children().find('input[name="phone"]');
    //     var email=$(this).parent().parent().children().find('input[name="email"]');
    //
    //     // initialize a JSON object
    //     var readyData = {
    //         phone:phone.val(),
    //         email:email.val()
    //     };
    //     $.post('control/extraMessage/delExtraMessage.do', readyData, function(res) {
    //         alert(res.msg);
    //         location.reload();
    //     });
    // });
    $('.add').on('click', function() {
        // get selectors
        var name = $(this).parent().parent().children().find('input[name="name"]');
        var phone = $(this).parent().parent().children().find('input[name="phone"]');
        var email=$(this).parent().parent().children().find('input[name="email"]');
        if(name.val()=="" ){
            alert("名字为空！");
            return false;
        }
        if(phone.length>11) {
            alert("请输入正确的号码");
            return false;
        }
        if(phone.val()=="" ||  email.val()=="" ){
            alert("有值为空！");
            return false;
        }
        //	提交表单
        $.ajax({
            url: 'control/extraMessage/addExtraMessage.do',
            type: 'POST',
            cache: false,
            data: new FormData($('#mform1')[0]),
            processData: false,
            contentType:false
        }).done(function(res){
            alert(res.msg);
            location.reload();
        });
    });

});
