var number=localStorage.getItem("newsnumber");
var i=number;
var id=localStorage.getItem(i);
console.log(id);
$.ajax({
	type:"GET",
	url:"news/checknews.do",
	dataType:"json",
	data:{
		"id":id,
	},
	success:function(json){
		console.log(json.data);
		$(".title")[0].innerHTML=json.data.news.title;
		$(".info")[0].innerHTML="发表日期:"+json.data.news.date+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"作者:"+json.data.news.releaser;
		$(".contentinfo")[0].innerHTML=json.data.news.content;
	},
	error:function(json){
		console.log("error")
	},
})