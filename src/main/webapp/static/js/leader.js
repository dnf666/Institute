$(function(){
    $.ajax({
        type:"GET",
        url:"person/listLeader.do",
        dataType:"json",
        data:{
            "pageSize":100,
            "pageNow":0
        },
        success:function(json){
            console.log(json.data);
            for (let i in json.data.person) {
                let leader = '<div class="card text-center col-md-4" style="width:300px;">'+
                               '<img class="card-img-top" src="" alt="Card image cap">'+
                               '<div class="card-body">'+
                                 '<h4 class="card-title"></h4>'+
                                 '<p class="card-text"></p>'+
                                 '<a class="btn btn-primary">个人简介</a>'+
                               '</div>'+
                             '</div>'
                $(".box").eq(0).append(leader);
                $(".card img")[i].src = '/institute/upload/' + json.data.person[i].picture.link;
                $(".card-title")[i].innerHTML = json.data.person[i].name;
                $(".card-text")[i].innerHTML = json.data.person[i].zhicheng;

                //添加点击事件
                $(".btn")[i].index=i;
                $(".btn")[i].onclick=function(){
                    localStorage.setItem("number",this.index);
                    window.parent.location.href="personal.html";
                }

                //储存数据
                list = {
                    name: json.data.person[i].name,
                    id: json.data.person[i].id
                }
                list = JSON.stringify(list);
                console.log(list);
                localStorage.setItem(i, list);
                /*       $(".card img")[1].src='/institute/upload/'+json.data.person[1].picture.link;
                       $(".card-title")[1].innerHTML=json.data.person[1].name;
                       $(".card-text")[1].innerHTML=json.data.person[1].zhicheng;
                       list={
                           name:json.data.person[1].name,
                           id:json.data.person[1].id,
                       }
                       list=JSON.stringify(list);
                       console.log(list);
                       localStorage.setItem("1",list);*/
            }
        },
        error:function(json){
            console.log("error");
        },
    })

})