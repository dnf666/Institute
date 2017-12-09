$(function(){
    var i = sessionStorage.getItem("page")? sessionStorage.getItem("page") : 1;

    var pageSum1;
    var pageSum2;
    var pageSum;
//ajax
    $("#numberpage")[0].innerHTML="第"+i+"页";
    var list;
    var name;
    var id;
    function aj(){
        //研究生
        $.ajax({
            type:"get",
            url:"person/listAllPostGrads.do",
            dataType:"json",
            data:{
                "pageNow":i,
                "pageSize":"3"
            },
            success:function(json){
                //研究生第一个学生
                //无获取到数据时隐藏
                var k=json.data.person.length;
                for(var m=0;m<3;m++){
                    $(".litlebox")[m].style.display = "block";
                }
                for(var m=3;m>k;m--) {
                    $(".litlebox")[m - 1].style.display = "none";
                }
                pageSum1=json.data.pageSum;
                // localStorage.setItem(pageSum1,json.data.pageSum);
                for(var i = 0;i<json.data.person.length;i++) {
                    $(".photo img")[i].src = "/institute/upload/" + json.data.person[i].picture.link;
                    $(".name")[i].innerHTML = "姓名：" + json.data.person[i].name;
                    $(".dection")[i].innerHTML = "方向：" + json.data.person[i].zhiwu;
                    // $(".profession")[i].innerHTML = "导师：" + json.data.person[i].whereabout;
                    list = {
                        name: json.data.person[i].name,
                        id: json.data.person[i].id
                    }
                    list = JSON.stringify(list);
                    //console.log(list);
                    localStorage.setItem(i, list);
                }

            },
            error:function(json){
                //alert("error");
            },
        })


        //本科生
        $.ajax({
            type:"get",
            url:"person/listAllMembers.do",
            dataType:"json",
            data:{
                "pageNow":i,
                "pageSize":"3"
            },
            success:function(json){
                //console.log(json);
                //无获取到数据时隐藏
                var k=json.data.person.length;
                for(var m=0;m<3;m++){
                    $(".litlebox")[m+3].style.display = "block";
                }
                for(var m=3;m>k;m--){
                    $(".litlebox")[m+2].style.display="none";
                }
                // localStorage.setItem(pageSum2,json.data.pageSum);
                pageSum2=json.data.pageSum;
                if(pageSum1>=pageSum2)
                {pageSum=pageSum1}
                else
                {pageSum=pageSum2};

                for(var i = 0;i<json.data.person.length;i++){
                    $(".photo img")[i+3].src = "/institute/upload/" + json.data.person[i].picture.link;
                    $(".name")[i+3].innerHTML = "姓名：" + json.data.person[i].name;
                    $(".dection")[i+3].innerHTML = "方向：" + json.data.person[i].zhiwu;
                    $(".profession")[i+3].innerHTML = "专业：" + json.data.person[i].xibie;
                    list = {
                        name: json.data.person[i].name,
                        id: json.data.person[i].id
                    }
                    list = JSON.stringify(list);
                    //console.log(list);
                    localStorage.setItem(i + 3, list);
                }
            },
            error:function(json){
                //alert("error");
            },

        })
    }
    // pageSum1=localStorage.getItem(pageSum1);
    // pageSum2=localStorage.getItem(pageSum2);
    // if(pageSum1>=pageSum2){pageSum=pageSum1}
    // else{pageSum=pageSum2};
//调用ajax
    aj();
//点击事件
    //上一页
    $("#beforepage")[0].onclick=function(){
        if (i>1) {
            i--;
            aj();
            $("#numberpage")[0].innerHTML="第"+i+"页";
        }
    }

    //下一页
    $("#nextpage")[0].onclick=function(){
        // console.log(1);
        // console.log(pageSum);
        // console.log(pageSum1);
        // console.log(pageSum2);
        if(pageSum>i){
            //console.log(2);
            i++;
            aj();
            $("#numberpage")[0].innerHTML="第"+i+"页";
        }


    }
    //显示的页数
    $("#numberpage")[0].innerHTML="第"+i+"页";



    //点击头像跳转个人界面
    for(var k=0;k<$(".man").length;k++){
        $(".man")[k].index=k;
        $(".man")[k].onclick=function(){
            sessionStorage.setItem("page",i);
            localStorage.setItem("number",this.index);
            window.location.href="personal.html";
        }
    }
})