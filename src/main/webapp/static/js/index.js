$(function(){

    $('.sign').eq(0).css("background-color","white");

    //自动播放
    var num=$('.child').length;
    var now_num=0;
    var clear=null;
    $('.child:gt(0)').hide();

    function move(){
        if (now_num==num-1) {
            now_num=-1;
        }
        $('.child').eq(now_num+1).fadeIn('slow').siblings('.child').fadeOut('slow');
        $('.sign').css("background-color","#367E94");
        $('.sign').eq(now_num+1).css("background-color","white");
        now_num++;
    }
    function returnphoto(){
        change=setInterval(function(){
            move();
        },5000);
    }
    returnphoto();

    //鼠标移上去停止
    $('.child').mouseover(function(){
        clearInterval(change);
    })
    $('.sign').mouseover(function(){
        clearInterval(change);
    })
    $('.child').mouseout(function(){
        returnphoto();
    })
    $('.sign').mouseout(function(){
        returnphoto();
    })


    //点击小图发生的事
    $('.sign').click(function(){
        var bigchange=$('.sign').index(this);
        $('.child').eq(bigchange).fadeIn('slow').siblings('.child').fadeOut('slow');
        $('.sign').css("background-color","#367E94");
        $('.sign').eq(bigchange).css("background-color","white");
        now_num=bigchange;
    })


//ajax
    $.ajax({
        type:"GET",
        url:"paper/listPaper.do",
        dataType:'json',
        data:{
            "identify":"index",
            "pageSize":4,
            "pageNow":0
        },
        success:function(json){
            $(".papername")[0].innerHTML=json.data.paperlist[0].title;
            $(".Designer")[0].innerHTML=json.data.paperlist[0].author;
            localStorage.setItem("0",json.data.paperlist[0].id);
            $(".papername")[1].innerHTML=json.data.paperlist[1].title;
            $(".Designer")[1].innerHTML=json.data.paperlist[1].author;
            localStorage.setItem("1",json.data.paperlist[1].id);
            $(".papername")[2].innerHTML=json.data.paperlist[2].title;
            $(".Designer")[2].innerHTML=json.data.paperlist[2].author;
            localStorage.setItem("2",json.data.paperlist[2].id);
            $(".papername")[3].innerHTML=json.data.paperlist[3].title;
            $(".Designer")[3].innerHTML=json.data.paperlist[3].author;
            localStorage.setItem("3",json.data.paperlist[3].id);
        },
        error:function(json){
            console.log("error")
        },
    })
//点击四篇论文
    for(var k=0;k<$(".listPaper").length;k++){
        $(".listPaper")[k].index=k;
        $(".listPaper")[k].onclick=function(){
            localStorage.setItem("papernumber",this.index);
            console.log(this.index);
        }
    }

//
    $.ajax({
        type:"GET",
        url:"news/listnews.do",
        dataType:"json",
        data:{
            "identify":"index",
            "pageSize":"2",
            "pageNow":"0"
        },
        success:function(json){
            console.log(json.data);
            $(".newsphoto img")[0].src='/institute/upload/'+json.data.newslist[0].picture.link;
            $(".newstittle")[0].innerHTML=json.data.newslist[0].title;
            $(".newsinfof")[0].innerHTML=json.data.newslist[0].summary;
            $(".newsinfos")[0].innerHTML=json.data.newslist[0].date+'&nbsp'+'发布';
            $(".newsphoto img")[1].src='/institute/upload/'+json.data.newslist[1].picture.link;
            $(".newstittle")[1].innerHTML=json.data.newslist[1].title;
            $(".newsinfof")[1].innerHTML=json.data.newslist[1].summary;
            $(".newsinfos")[1].innerHTML=json.data.newslist[1].date+'&nbsp'+'发布';
            localStorage.setItem("4",json.data.newslist[0].id);
            localStorage.setItem("5",json.data.newslist[1].id);
        },
        error:function(json){
            console.log("error");
        },
    })



    for(var k=0;k<$(".newslink").length;k++){
        $(".newslink")[k].index=k;
        $(".newslink")[k].onclick=function(){
            localStorage.setItem("newsnumber",this.index+4);
            console.log(this.index+4);
        }
    }

    // $("#header").contents().find("#Researchresult").click(function(){
    // 	window.location.href='../Researchresult.html'
    // 	})
})
