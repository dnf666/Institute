
//已完成项目
$(function(){
var i=0;
var k=1;
	$.ajax({
		type:"GET",
		url:"project/listCompletedAchieve.do",
		data:{
            "pageSize":3,
			"pageNow":0
		},
		dateType:"json",
		success:function(json){
				for(var j=0;j<json.data.completedachieve.length&&j<3;j++){
					$("#info li")[i++].innerHTML=k++;
					$("#info li")[i++].innerHTML=json.data.completedachieve[j].leader;
					$("#info li")[i++].innerHTML=json.data.completedachieve[j].title;
					$("#info li")[i++].innerHTML=json.data.completedachieve[j].deadline;					
				}

		}
	})
})
//未完成的项目
$(function(){
var i=12;
var k=1;
	$.ajax({
		type:"get",
		url:"project/listAllProject.do?pageSize=1&pageNow=0",
		dateType:"json",
		success:function(json){
		for(var j=0;j<json.data.doingachieve.length&&j<3;j++){
			$("#info li")[i++].innerHTML=k++;
			$("#info li")[i++].innerHTML=json.data.doingachieve[j].leader;
			$("#info li")[i++].innerHTML=json.data.doingachieve[j].title;
			$("#info li")[i++].innerHTML=json.data.doingachieve[j].startline;
		}
		},
		error:function(json){
			console.log("error");
		},
	})
})