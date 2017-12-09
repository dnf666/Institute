$(function(){
var j=0;
$.ajax({
	type:"GET",
	url:"project/listCompletedAchieve.do",
	dataType:'json',
	success:function(json){
		console.log(json.data)
		for(;j<json.data.completedachieve.length;j++){
			var page=document.createElement("div");
				page.className='pager';
				page.innerHTML=
					'<div class="page">'+
						'<ul>'+
							'<li class="name">'+
								'<div class="name_">'+'</div>'+
							'</li>'+
							'<li class="title">'+
								'<p href="#" class="content_">'+'</p>'+
							'</li>'+
							'<li class="time">'+
								'<div class="time_">'+'</div>'+
							'</li>'+
						'</ul>'+
				 	'</div>'+
					'<div class="box">'+'</div>'
							;
								$("#allpage")[0].append(page);
								$(".name_")[j].innerHTML=json.data.completedachieve[j].leader;
								$(".content_")[j].innerHTML=json.data.completedachieve[j].title;
								$(".time_")[j].innerHTML=json.data.completedachieve[j].startline;
								localStorage.setItem(j,json.data.completedachieve[j].id);
								// $(".content_")[j].index=j;
								// $(".content_")[j].onclick=function(){
								// 	localStorage.setItem("papernumber",this.index);
								// 	window.parent.location.href="monongraphinfo.html";
								// }							

					}
	},
	error:function(json){
		console.log("error");
	},
})
// 	$("#btn")[0].onclick=function(){
// 		$.ajax({
// 			type:"GET",
// 			url:"http://rapapi.org/mockjsdata/19301/news/listnews.do",
// 			dataType:'json',
// 			success:function(json){
// 				for(;j<json.data.newslist.length;j++){
// 					var page=document.createElement("div");
// 						page.className='pager';
// 						page.innerHTML=
// 							'<div class="page">'+
// 								'<ul>'+
// 									'<li class="name">'+
// 										'<div class="name_">'+'</div>'+
// 									'</li>'+
// 									'<li class="title">'+
// 										'<p href="#" class="content_">'+'</p>'+
// 									'</li>'+
// 									'<li class="time">'+
// 										'<div class="time_">'+'</div>'+
// 									'</li>'+
// 								'</ul>'+
// 						 	'</div>'+
// 							'<div class="box">'+'</div>'
// 									;
// 										$("#allpage")[0].append(page);
// 										$(".name_")[j].innerHTML=json.data.newslist[j].author;
// 										$(".content_")[j].innerHTML=json.data.newslist[j].content;
// 										$(".time_")[j].innerHTML=json.data.newslist[j].date;
// 										localStorage.setItem(j,json.data.newslist[j].id);
// 										$(".content_")[j].index=j;
// 										$(".content_")[j].onclick=function(){
// 											localStorage.setItem("papernumber",this.index);
// 											//window.parent.location.href="monongraphinfo.html";
// 										}							

// 							}
// 			},
// 			error:function(json){
// 				console.log("error");
// 			},
// })
// 	}

})