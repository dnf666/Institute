$(function(){
    var j=0;
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"news/listnews.do",
        data:{
            "identify":"news",
            "pageSize":3,
            "pageNow":0
        },
        success:function(json){
            console.log(json);
            console.log(json.data);
            for(;j<json.data.newslist.length;j++){
                create=document.createElement("div");
                create.className="pager";
                create.innerHTML=
                    '<div class="page">'+
                    '<div class="photo">'+'<img class="picture" src="img/1.png">'+'</div>'+
                    '<div class="content_">'+
                    '<div class="titlebox">'+
                    '<span class="title">'+'</span>'+
                    '<span class="name">'+'</span>'+
                    '<span class="time">'+'</span>'+
                    '</div>'+
                    '<div class="contentinfo">'+'</div>'+
                    '<div class="last">'+'<a class="newslist">'+'阅读原文'+'</a>'+'</div>'+
                    '</div>'+
                    '</div>'
                ;
                $("#content")[0].append(create);
                $(".photo img")[j].src='/institute/upload/'+json.data.newslist[j].picture.link;
                $(".title").eq(j).html(json.data.newslist[j].title);
                $(".contentinfo").eq(j).html(json.data.newslist[j].summary);
                $(".name").eq(j).html("发布人："+json.data.newslist[j].releaser);
                $(".time").eq(j).html(json.data.newslist[j].data);
                localStorage.setItem(j,json.data.newslist[j].id);
                $(".newslist")[j].index=j;
                $(".newslist")[j].onclick=function(){
                    localStorage.setItem("newsnumber",this.index);
                    window.parent.location.href="newsinfo.html";
                };

            }
        },
        error:function(json){
            console.log("error!");
        }
    })


    $("#btn")[0].onclick=function(){
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"news/listMoreNews.do",
            success:function(json){
                console.log(json);
                for(;j<json.data.newslist.length;j++){
                    console.log(j);
                    create=document.createElement("div");
                    create.className="pager";
                    create.innerHTML=
                        '<div class="page">'+
                        '<div class="photo">'+'<img class="picture" src="img/1.png">'+'</div>'+
                        '<div class="content_">'+
                        '<div class="titlebox">'+
                        '<span class="title">'+'</span>'+
                        '<span class="name">'+'</span>'+
                        '<span class="time">'+'</span>'+
                        '</div>'+
                        '<div class="contentinfo">'+'</div>'+
                        '<div class="last">'+'<a class="newslist" href="javascript:window.parent.location.href="newsinfo.html"">'+'阅读原文'+'</a>'+'</div>'+
                        '</div>'+
                        '</div>'
                    ;
                    $("#content")[0].append(create);
                    $(".photo img")[j].src='/institute/upload/'+json.data.newslist[j].picture.link;
                    $(".title").eq(j).html(json.data.newslist[j].title);
                    $(".contentinfo").eq(j).html(json.data.newslist[j].summary);
                    $(".name").eq(j).html("发布人："+json.data.newslist[j].releaser);
                    $(".time").eq(j).html(json.data.newslist[j].data);
                    localStorage.setItem(j,json.data.newslist[j].id);
                    $(".newslist")[j].index=j;
                    $(".newslist")[j].onclick=function(){
                        localStorage.setItem("newsnumber",this.index);
                        window.parent.location.href="newsinfo.html";
                    };
                }
            },
            error:function(json){
                console.log("error!");
            }
        })
    }

})