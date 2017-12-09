$(function(){
	j=0;
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"project/listNotCompleted.do",
		success:function(json){
			for(;j<json.data.doingachieve.length;j++){
				create=document.createElement("div");
				create.className="paper";
				create.innerHTML=
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
				$("#allpage")[0].append(create);
				$(".name_").eq(j).html(json.data.doingachieve[j].leader);
				$(".content_").eq(j).html(json.data.doingachieve[j].title);
				$(".time_").eq(j).html(json.data.doingachieve[j].startline);
				localStorage.setItem(j,json.data.doingachieve[j].id);
				// $(".content_")[j].index=j;
				// $(".content_")[j].onclick=function(){
				// localStorage.setItem("papernumber",this.index);
				// window.parent.location.href="monongraphinfo.html";
				// }	
			}
		},
		error:function(){
			console.log("error");
		}
	})
	// $("#btn")[0].onclick=function(){
	// 	$.ajax({
	// 		type:"GET",
	// 		dataType:"json",
	// 		url:"http://rapapi.org/mockjsdata/19301/project/morenotcompleted.do",
	// 		success:function(json){
	// 			for(;j<json.data.doingachieve.length;j++){
	// 				create=document.createElement("div");
	// 				create.className="paper";
	// 				create.innerHTML=
	// 					'<div class="page">'+
	// 						'<ul>'+
	// 							'<li class="name">'+
	// 								'<div class="name_">'+'</div>'+
	// 							'</li>'+
	// 							'<li class="title">'+
	// 								'<p href="#" class="content_">'+'</p>'+
	// 							'</li>'+
	// 							'<li class="time">'+
	// 								'<div class="time_">'+'</div>'+
	// 							'</li>'+
	// 						'</ul>'+
	// 					'</div>'+
	// 						'<div class="box">'+'</div>'
	// 					;
	// 				$("#allpage")[0].append(create);
	// 				$(".name_").eq(j).html(json.data.doingachieve[j].leader);
	// 				$(".content_").eq(j).html(json.data.doingachieve[j].content);
	// 				$(".time_").eq(j).html(json.data.doingachieve[j].startline);
	// 				localStorage.setItem(j,json.data.doingachieve[j].id);
	// 				$(".content_")[j].index=j;
	// 				$(".content_")[j].onclick=function(){
	// 				localStorage.setItem("papernumber",this.index);
	// 				//window.parent.location.href="monongraphinfo.html";
	// 				}	
	// 			}
	// 	},
	// 	error:function(){
	// 		console.log("error");
	// 	}
	// })
	// }
})