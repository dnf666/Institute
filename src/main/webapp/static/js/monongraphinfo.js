$(function(){
	var number=localStorage.getItem("papernumber");
	var i=number;
	var id=localStorage.getItem(i);
	$.ajax({
			type:"GET",
			dataType:"json",
			data:{
				"id":id
			},
			url:"paper/readpaper.do",
			success:function(json){
				$(".title")[0].innerHTML=json.data.paper.title;
				$(".info")[0].innerHTML="发表日期:"+json.data.paper.date+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"作者:"+json.data.paper.author;
				$(".contentinfo")[0].innerHTML=json.data.paper.content;
			},
			error:function(json){
					console.log("error");
				},
		})
})