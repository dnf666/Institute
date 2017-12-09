
$(function(){
	/*$('input[name=deadline]').on('focusout', function() {
		//	获取当前日期
		var currentTime = new Date();
		var year = currentTime.getFullYear();
		var month = currentTime.getMonth()+1;
		var day = currentTime.getDate();
		
		//	获取输入日期
		var inputYear = this.value.substring(0,4);
		var inputMonth = this.value.substring(5,7);
		var inputDay = this.value.substring(8,10);
		
		//	获取连字符
		var hyphen1 = this.value.substring(4,5);
		var hyphen2 = this.value.substring(7,8);

		//	判断是否已经输入项目名称，未输入则要求输入
		if($('input[name=title]').val() == '') {
			$('.tips_pro').html('请输入项目名称').css('color', 'red');
			setTimeout(function() {
				$('.tips_pro').html('');
			}, 1000);
		}
		else {
			//	判断输入格式是否正确
			if(this.value.length==10 && hyphen1=='-' && hyphen2=='-') {
			
				//	判断年份是否有效
				if(inputYear>=year) {

					//	年份在当年时执行的操作
					if(inputYear == year) {

						//	判断月份是否有效
						if(inputMonth>=month && inputMonth<=12) {

							//	Deadline在当月执行的操作
							if(inputMonth == month) {

								//	获取当月天数来判断输入日数是否有效
								var virtualDate = new Date(inputYear, inputMonth, 0);
								var days = virtualDate.getDate();
								if(inputDay>day && inputDay<=days) {
									$('.tips').html("日期有效").css('color', 'green');
									stepWiseForm();
									setTimeout(function() {
										$('.tips').html('');
									}, 1000);
								}
								else {
									$('.tips').html("日期无效").css('color', 'red');
									setTimeout(function() {
										$('.tips').html('');
									}, 1000);
								}
							}
							
							//	Deadline在往后月份时执行的操作
							else {

								//	获取当月天数来判断输入日数是否有效
								var virtualDate = new Date(inputYear, inputMonth, 0);
								var days = virtualDate.getDate();
								if(inputDay>=1 && inputDay<=days) {
									$('.tips').html("日期有效").css('color', 'green');
									stepWiseForm();
									setTimeout(function() {
										$('.tips').html('');
									}, 1000);
								}
								else {
									$('.tips').html("日期无效").css('color', 'red');
									setTimeout(function() {
										$('.tips').html('');
									}, 1000);
								}
							}
						}
						else {
							$('.tips').html("日期无效").css('color', 'red');
							setTimeout(function() {
								$('.tips').html('');
							}, 1000);
						}

					}

					//	年份在往后年时执行的操作
					else {

						//	判断月份是否有效
						if(inputMonth>=1 && inputMonth<=12) {

							//	获取当月天数来判断输入日数是否有效
							var virtualDate = new Date(inputYear, inputMonth, 0);
							var days = virtualDate.getDate();
							if(inputDay>=1 && inputDay<=days) {
								$('.tips').html("日期有效").css('color', 'green');
								stepWiseForm();
								setTimeout(function() {
									$('.tips').html('');
								}, 1000);
							}
							else {
								$('.tips').html("日期无效").css('color', 'red');
								setTimeout(function() {
									$('.tips').html('');
								}, 1000);
							}
						}
					}
				}
				else {
					$('.tips').html("日期无效").css('color', 'red');
					setTimeout(function() {
						$('.tips').html('');
					}, 1000);
				}
			}
			else {
				$('.tips').html("日期无效").css('color', 'red');
				setTimeout(function() {
					$('.tips').html('');
				}, 1000);
			}
		}
	});*/
    $('body').delegate('.modify','click', function() {
		// get selectors
		var title = $(this).parent().parent().children().find('input[name="title"]');
		var leader = $(this).parent().parent().children().find('input[name="leader"]');
		var content = $(this).parent().parent().children().find('input[name="content"]');
		var id=$(this).parent().parent().children().find('input[name="id"]');
		// initialize a JSON object
		var readyData = {
				id:id.val(),
				title: title.val()==title.prop('defaultValue') ? null : title.val(),
				leader: leader.val()==leader.prop('defaultValue') ? null : leader.val(),
				content:content.val()==content.prop('defaultValue') ? null : content.val()
		};
		if(readyData.title=="" || readyData.leader=="" ||readyData.startline=="" || readyData.deadline==""){
			alert("有值为空！");
			event.preventDefault();
			return false;
		}
		if(readyData.title==null && readyData.leader==null && readyData.content==null ){
			alert("没有修改，不用保存");
			event.preventDefault();
			return false;
		}
		$.post('control/doneProject/modifyDoneProject.do', readyData, function(res) {
			alert(res.msg);  
			location.reload();
		});
	});
	
	
		$('.add').on('click', function() {
			
			// get selectors
			var title = $(this).parent().parent().children().find('input[name="title"]');
			var leader = $(this).parent().parent().children().find('input[name="leader"]');
			var deadline = $(this).parent().parent().children().find('input[name="deadline"]');
			var startline = $(this).parent().parent().children().find('input[name="startline"]');
			var content=$(this).parent().parent().children().find('input[name="content"]');
			// initialize a JSON object
			var readyData = {
					startline:startline.val(),
					deadline:deadline.val(),
					title: title.val(),
					content:content.val(),
					leader: leader.val()
			};
			if(readyData.title=="" || readyData.leader=="" ||readyData.startline=="" || readyData.deadline==""){
				alert("有值为空！");
				event.preventDefault();
				return false;
			}
			$.post(	'control/doneProject/addDoneProject.do', readyData,  function(res) {
				alert(res.msg);  
				location.reload();
			});
		});
		$('.del').on('click', function(event) {
			var id=$(this).parent().parent().children().find('input[name="id"]');
			// initialize a JSON object
			var readyData = {
					id:id.val()
			};
			
			$.post(	'control/doneProject/delDoneProject.do', readyData,  function(res) {
				alert(res.msg);  
				location.reload();
			});
		});
	});


