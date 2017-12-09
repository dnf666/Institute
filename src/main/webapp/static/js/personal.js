$(function(){
	var number=localStorage.getItem("number");
	var i=number;
	var info=localStorage.getItem(i);
	info=JSON.parse(info);
	//console.log(info);
	$.ajax({
		type:"GET",
		url:"personshow/personShow.do",
		dataType:"json",
		data:{
			"id":info.id,
			"name":info.name,
		},
		success:function(json){
			//console.log(json);
            $("#photo img")[0].src='/institute/upload/'+json.data.Member.picture.link;
            $("#name")[0].innerHTML="姓名:"+json.data.Member.name;
		if (json.data.Member.whereabout == undefined) {
                $("#whereabout")[0].style.display="none";
            }
            else{
                $("#whereabout")[0].innerHTML="去向："+json.data.Member.whereabout;
            }
	    if (json.data.Member.zhiwu == undefined) {
                $("#zhiwu")[0].style.display="none";
            }
            else{
                $("#zhiwu")[0].innerHTML="研究方向："+json.data.Member.zhiwu;
            }
	   if (json.data.Member.xibie==undefined) {
                $("#major")[0].style.display="none";
            }
            else{
                $("#major")[0].innerHTML="系别："+json.data.Member.xibie;
            }
            if (json.data.Member.xuewei==undefined) {
                $("#position")[0].style.display="none";
            }
            else{
                $("#position")[0].innerHTML="学位："+json.data.Member.xuewei;
            }
            if (json.data.Member.zhicheng==undefined) {
                $("#degree")[0].style.display="none";
            }
            else{
                $("#degree")[0].innerHTML="职称："+json.data.Member.zhicheng;
            }
            if (json.data.Member.daoshi==undefined) {
                $("#daoshi")[0].style.display="none";
            }
            else{
                $("#daoshi")[0].innerHTML="导师："+json.data.Member.daoshi;
            }
            $("#personcontent")[0].innerHTML=json.data.Member.jianjie;
            for(var i in json.data.titleList){
                $("#study")[0].innerHTML += json.data.titleList[i]+'<br>';
            }
            if ($("#study")[0].innerHTML=="") {
                $("#study")[0].innerHTML="这人很懒，什么都没留下。"
            }
		},
		error:function(json){
			alert("error");
		},

	})
	
})