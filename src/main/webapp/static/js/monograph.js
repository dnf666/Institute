$(function(){
	var j=0;
	var i=0;
		$.ajax({
				type:"GET",
				url:"paper/listPaper.do",
				dataType:"json",
				data:{
						"identify":"article",
						"pageNow":i,
						"pageSize":"3"
				},
				success:function(json){
					console.log(json);
					for(;j<json.data.paperlist.length;j++){
						var page=document.createElement("div");
						page.className='pager';
						page.innerHTML=
							'<div class="page">'+
								'<ul>'+
									'<li class="name">'+
										'<div class="name_">'+'</div>'+
									'</li>'+
									'<li class="tit">' +
										'<div class="titl">' +'lala'+'</div>'+
							'		</li>'+
									// '<li class="title">'+
									// 	'<div>'+
									// 		//'<p class="title_">'+'<a href="#">'+'</a>'+'</p>'+
									// 		'<a class="content_">'+'</a>'+
									// 	'</div>'+
									// '</li>'+
									'<li class="time">'+
										'<div class="time_">'+'</div>'+
									'</li>'+
								'</ul>'+
							'</div>'+
								'<div class="box"></div>'
							;
								$("#allpage")[0].append(page);
								$(".name_").eq(j).html(json.data.paperlist[j].author);
								$(".titl").eq(j).html(json.data.paperlist[j].title);
								$(".time_").eq(j).html(json.data.paperlist[j].date);
								localStorage.setItem(j,json.data.paperlist[j].id);
								$(".titl")[j].index=j;
								$(".titl")[j].onclick=function(){
									localStorage.setItem("papernumber",this.index);
									window.parent.location.href="monongraphinfo.html";
								}

					}
				},
				error:function(json){
					console.log("error");
				},

			})
		$("#btn")[0].onclick=function(){
			$.ajax({
				type:"GET",
				url:"paper/listMorePaper.do",
				dataType:"json",
				success:function(json){
					console.log(json);
					for(;j<json.data.paperlist.length;j++){
						var page=document.createElement("div");
						page.className='pager';
						page.innerHTML=
                            '<div class="page">'+
                            '<ul>'+
                            '<li class="name">'+
                            '<div class="name_">'+'</div>'+
                            '</li>'+
                            '<li class="tit">' +
                            '<div class="titl">' +'lala'+'</div>'+
                            '		</li>'+
                            // '<li class="title">'+
                            // '<div>'+
                            // //'<p class="title_">'+'<a href="#">'+'</a>'+'</p>'+
                            // '<a class="content_">'+'</a>'+
                            // '</div>'+
                            '</li>'+
                            '<li class="time">'+
                            '<div class="time_">'+'</div>'+
                            '</li>'+
                            '</ul>'+
                            '</div>'+
                            '<div class="box"></div>'

							;
								$("#allpage")[0].append(page);

								$(".name_").eq(j).html(json.data.paperlist[j].author);
								$(".titl").eq(j).html(json.data.paperlist[j].title);
								$(".keyword").eq(j).html(json.data.paperlist[j].keyword);
								$(".time_").eq(j).html(json.data.paperlist[j].date);
								localStorage.setItem(j,json.data.paperlist[j].id);
                        		$(".titl")[j].index=j;
								$(".titl")[j].onclick=function(){
									localStorage.setItem("papernumber",this.index);
									window.parent.location.href="monongraphinfo.html";
								}

					}
				},
				error:function(json){
					console.log("error");
				},

			})
		}

})