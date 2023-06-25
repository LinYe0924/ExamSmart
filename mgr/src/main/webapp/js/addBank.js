 let typeChange=0;
 let moreChoose=1;
 let userName=localStorage.getItem("userName");
$("#userNameValue").val(userName);


function updateBtn(){
	var oneChoose=document.getElementById("oneChoose");
	oneChoose.style.backgroundColor="rgb(242,242,242)";
	oneChoose.style.color="#000";
	var moreChoose=document.getElementById("moreChoose");
	moreChoose.style.backgroundColor="rgb(242,242,242)";
	moreChoose.style.color="#000";
	var blank=document.getElementById("blank");
	blank.style.backgroundColor="rgb(242,242,242)";
	blank.style.color="#000";
	var yesOrNo=document.getElementById("yesOrNo");
	yesOrNo.style.backgroundColor="rgb(242,242,242)";
	yesOrNo.style.color="#000";
}
 $("#oneChoose").click(function(){
	 typeChange=1;
	 updateBtn();
	var oneChoose=document.getElementById("oneChoose");
	oneChoose.style.backgroundColor="rgb(75, 125, 252)";
	oneChoose.style.color="#FFF";
	 $(".panel").html(`
		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
		单选题
		</div>
		<div class="panel-body">
		<div>
			<div>请输入题目内容：</div>
			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容" id="oneChooseText"></textarea></div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项一：是否是答案：<input type="radio" class="samllChoose" name="choose" value="1">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容" id="chooseAValue"></textarea>
			</div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项二：是否是答案：<input type="radio" class="samllChoose" name="choose" value="2">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容" id="chooseBValue"></textarea>
			</div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项三：是否是答案：<input type="radio" class="samllChoose" name="choose" value="3">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容" id="chooseCValue"></textarea>
			</div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项四：是否是答案：<input type="radio" class="samllChoose" name="choose" value="4">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容" id="chooseDValue"></textarea>
			</div>
		</div>
		</div>
		`);
 })
 $("#moreChoose").click(function(){
	 typeChange=2;
	 updateBtn();
	 moreChoose=1;
 	var moreChoose=document.getElementById("moreChoose");
 	moreChoose.style.backgroundColor="rgb(75, 125, 252)";
	moreChoose.style.color="#FFF";
 	 $(".panel").html(`
 		
 		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
 		多选题
 		</div>
 		<div class="panel-body">
 		<div>
 			<div>请输入题目内容：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容" id="moreChooseText" ></textarea></div>
 		</div>
		<div>
		<div>请输入选项内容：</div>
			<textarea class="form-control" rows="2" id="chooseText" placeholder="请输入选项内容"></textarea>
		</div>
		<div>
		是否是答案：<input id="yesAnswer" type="radio"  name="yesAnswer">&nbsp是
		&nbsp&nbsp&nbsp
		<input id="noAnswer" type="radio"  name="yesAnswer">&nbsp否
		</div>
 		<button class="btn btn-info " type="button" onclick="addChoose()" id="addChooseBtn">添加选项</button>
		<button class="btn btn-info " style="background-color: coral;" type="button" onclick="delChoose()" id="delChooseBtn">删除选项</button>
		  <table class="informationTable" id="chooseTable" style="border-collapse: collapse;">
 		<colgroup>
			<col style="width: 15%;">
			<col style="width: 70%;">
			<col style="width: 15%;">
 		</colgroup>
		<td>选项编号</td>
 		<td>选项内容</td>
		<td>是否为答案</td>
		</div>
 		`);
 })
 $("#blank").click(function(){
	 typeChange=3;
	 updateBtn();
 	var blank=document.getElementById("blank");
 	blank.style.backgroundColor="rgb(75, 125, 252)";
	blank.style.color="#FFF";

 	 $(".panel").html(`
 		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
 		填空题
 		</div>
 		<div class="panel-body">
 		<div>
 			<div>请输入题目内容：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容" id="blankText"></textarea></div>
 		</div>
 		<div>
 			<div>请输入答案：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入答案" id="blankAnsText"></textarea></div>
 		</div>
 		</div>
 		`);
 })


 $("#yesOrNo").click(function(){
	 typeChange=4;
	 updateBtn();
 	var yesOrNo=document.getElementById("yesOrNo");
 	yesOrNo.style.backgroundColor="rgb(75, 125, 252)";
	yesOrNo.style.color="#FFF";
 	 $(".panel").html(`
 		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
 		判断题
 		</div>
 		<div class="panel-body">
 		<div>
 			<div>请输入题目内容：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容" id="yesOrNoText"></textarea></div>
 		</div>
		<div>
		请选择答案：<input id="yesChoose" type="radio"  name="yesChoose">&nbsp是
		&nbsp&nbsp&nbsp
		<input id="noChoose" type="radio"  name="yesChoose">&nbsp否
		</div>
 		</div>
 		`);
 })

function addChoose(){
	let chooseText=$("#chooseText").val()
	let answer= document.getElementById("yesAnswer").checked;
	let answerTwo=document.getElementById("noAnswer").checked;
	let yesAnswer;
	chooseText=chooseText.trim();
	if(answer){
		yesAnswer="是";
	}else{
		if(answerTwo){
			yesAnswer="否";
		}else{
			alert("请选择该选项是否为答案！");
			return;
		}
	}
	
	if(chooseText.length==0){
		alert("请输入选项内容！！！");
		return;
	}
	let count=0;
	// 遍历每一行
	$("#chooseTable tr").each(function() {
	  // 获取第二列的单元格
	  var cell = $(this).find("td:eq(1)");
	  // 打印单元格的文本内容
	  console.log(cell.text());
	  if(cell.text().trim()==chooseText){
		  count++;
	  }
	});
	if(count==0){
			  
	}else{
	  alert("选项已被添加过了！");
	  return;
	}
	document.getElementById("chooseTable").innerHTML+=
	`<tr>
	<td>${moreChoose}</td>
	<td>${chooseText}</td>
	<td>${yesAnswer}</td>
	</tr>
	</table>`
	moreChoose++;
 }
 function addProblem(){
	let userId=localStorage.getItem("userId");
	let projectId= $("#projectId").val();
	if(typeChange==1){
		var problemText=$("#oneChooseText").val();
		var chooseA=$("#chooseAValue").val();
		var chooseB=$("#chooseBValue").val();
		var chooseC=$("#chooseCValue").val();
		var chooseD=$("#chooseDValue").val();
		problemText=problemText.trim();
		chooseA= chooseA.trim();
		chooseB= chooseB.trim();
		chooseC= chooseC.trim();
		chooseD= chooseD.trim();
		if(problemText.length==0){
			alert("请输入题目内容");
			return;
		}
		if(chooseA.length==0||chooseB.length==0||chooseC.length==0||chooseD.length==0){
			alert("请将选项输入完整！");
			return;
		}
		let answer=0;
		 var radios = document.getElementsByName("choose");
		  for (var i = 0; i < radios.length; i++) {
		    if (radios[i].checked) {
				answer=radios[i].value;
		    }
		  }
	if(answer==0){
		alert("请选择一个答案！");
		return;
	}
	const arr = [chooseA, chooseB, chooseC, chooseD]; //定义一个数组
	const hasDuplicate = arr.some (function (item) { //使用some方法遍历数组
	  return arr.indexOf (item) !== arr.lastIndexOf (item); //比较索引是否相等
	});
	if(hasDuplicate){
		console.log (hasDuplicate); //true，表示数组中有重复的值
		alert("有选项重复了，请修改！");
		return;
	}
	
	$.ajax({
	    url:'addProblem',
	    type:'POST',
	    data:{
	        'projectId' : projectId,
			'problemTypeId' : "1",
			'problemText' : problemText,
	        'answer' : answer,
			'userId' : userId,
			'chooseA' : chooseA,
			'chooseB' : chooseB,
			'chooseC' : chooseC,
			'chooseD' : chooseD
	    },
	    dataType:'JSON',
	    async:true,
		success:function(reps){
			$('#myModal').modal('hide');
			alert("添加成功!");
			let currentPage = document.getElementById("currentPage").innerText;
			updateTable(currentPage);
	    },
	    error:function (reps){
	        document.write(reps.responseText)
	    },
	})
		typeChange=0;
		updateBtn();
		$(".panel").html(`
		<div class="panel-heading" style="background-color: #FFF;"></div>`);
	}else if(typeChange==2){
		var moreProblemText=$("#moreChooseText").val();
		console.log("moreProblemText："+moreProblemText);
		moreProblemText=moreProblemText.trim();
		if(moreProblemText.length==0){
			alert("请输入题目内容");
			return;
		}
		const table = document.getElementById ("chooseTable"); //获取表格元素
		const rowCount = table.rows.length; //获取表格中的行数
		console.log("表格行数："+rowCount);
		if(rowCount<5){
			alert("选项不足，请添加选项！");
			return;
		}
		let count=0;
		var chooseArray = new Array();
		// 遍历每一行
		$("#chooseTable tr").each(function() {
		  // 获取第二列的单元格
		  var cell1 = $(this).find("td:eq(0)");
		  var cell2 = $(this).find("td:eq(1)");
		  var cell3 = $(this).find("td:eq(2)");
		  // 打印单元格的文本内容
		  console.log("是否？："+cell3.text());
		  console.log("滴滴");
		  if(cell3.text()=="是"){
			  count++;
		  }
		  var obj = {chooseId: cell1.text(), chooseText: cell2.text(),yeNoAnswer:cell3.text()};
		  chooseArray.push(obj);
		});
		if(count<2){
			alert("答案不足，至少2个，请修改！");
			chooseArray.length = 0;
			return;
		}
		var chooseJsson= JSON.stringify(chooseArray);
		console.log("集合：");
		console.log(chooseArray);
		console.log("chooseJsson:"+chooseJsson);
		// return;
		$.ajax({
		    url:'addProblem',
		    type:'POST',
		    data:{
		        'projectId' : projectId,
				'problemTypeId' : "2",
				'problemText' : moreProblemText,
				'userId' : userId,
				'choose' : chooseJsson
		    },
		    dataType:'JSON',
		    async:true,
			success:function(reps){
				$('#myModal').modal('hide');
				alert("添加成功!");
				let currentPage = document.getElementById("currentPage").innerText;
				updateTable(currentPage);
		    },
		    error:function (reps){
		        document.write(reps.responseText)
		    },
		})
		typeChange=0;
		updateBtn();
		$(".panel").html(`
		<div class="panel-heading" style="background-color: #FFF;"></div>`);
	}else if(typeChange==3){
		var blankText=$("#blankText").val();
		console.log("blankText："+blankText);
		blankText=blankText.trim();
		var blankAnsText=$("#blankAnsText").val();
		console.log("blankAnsText："+blankAnsText);
		blankAnsText=blankAnsText.trim();
		if(blankText.length==0){
			alert("请输入题目内容！");
			return;
		}
		if(blankAnsText.length==0){
			alert("请输入答案内容！");
			return;
		}
		$.ajax({
		    url:'addProblem',
		    type:'POST',
		    data:{
		        'projectId' : projectId,
				'problemTypeId' : "3",
				'problemText' : blankText,
				'userId' : userId,
				'answer' : blankAnsText
		    },
		    dataType:'JSON',
		    async:true,
			success:function(reps){
				$('#myModal').modal('hide');
				alert("添加成功!");
				let currentPage = document.getElementById("currentPage").innerText;
				updateTable(currentPage);
		    },
		    error:function (reps){
		        document.write(reps.responseText)
		    },
		})
		typeChange=0;
		updateBtn();
		$(".panel").html(`
		<div class="panel-heading" style="background-color: #FFF;"></div>`);
	}else if(typeChange==4){
		var yesOrNoText=$("#yesOrNoText").val();
		console.log("yesOrNoText："+yesOrNoText);
		yesOrNoText=yesOrNoText.trim();
		if(yesOrNoText.length==0){
			alert("请输入题目内容！");
			return;
		}
		let answer= document.getElementById("yesChoose").checked;
		let answerTwo=document.getElementById("noChoose").checked;
		let yesAnswer;
		if(answer){
			yesAnswer="是";
		}else{
			if(answerTwo){
				yesAnswer="否";
			}else{
				alert("请选择答案！");
				return;
			}
		}
		$.ajax({
		    url:'addProblem',
		    type:'POST',
		    data:{
		        'projectId' : projectId,
				'problemTypeId' : "4",
				'problemText' : yesOrNoText,
				'userId' : userId,
				'answer' : yesAnswer
		    },
		    dataType:'JSON',
		    async:true,
			success:function(reps){
				$('#myModal').modal('hide');
				alert("添加成功!");
				let currentPage = document.getElementById("currentPage").innerText;
				updateTable(currentPage);
		    },
		    error:function (reps){
		        document.write(reps.responseText)
		    },
		})
		typeChange=0;
		updateBtn();
		$(".panel").html(`
		<div class="panel-heading" style="background-color: #FFF;"></div>`);
	}else{
		alert("请选择题型！！！");
	}
 }
 function delChoose(){
	 const table = document.getElementById ("chooseTable"); //获取表格元素
	 const rowCount = table.rows.length; //获取表格中的行数
	 table.deleteRow (rowCount - 1); //删除最后一行，索引为行数减一
	 moreChoose--;
 }
function updateTable(page){
	
	$.ajax({
	    url:'updateProblemTable',
	    type:'POST',
	    data: {
	        page: page,
	    },
	    dataType:'JSON',
	    async:true,
		success:function(reps){
			$("#sumPage").text(reps.data.maxPage);
			document.getElementById("table").innerHTML=`<table class="informationTable" id="table" style="border-collapse: collapse;">
		              <colgroup>
		                <col style="width: 5%;">
						<col style="width: 40%;">
						<col style="width: 5%;">
						<col style="width: 15%;">
						<col style="width: 10%;">
						<col style="width: 5%;">
						<col style="width: 5%;">
						<col style="width: 15%;">
		              </colgroup>
					<tr style="background-color: rgb(229,229,229);">
					   <td>题目编号</td>
		               <td>题干</td>
					   <td>题型</td>
					   <td>选项</td>
		               <td>答案</td>
						<td>上传者</td> 
						<td>所属学科</td> 
						<td>操作</td>
		            </tr>`;
					for(let i = 0; i < reps.data.list.length; i++){
						let choose =reps.data.list[i].type_name == "单选题"? '<button onclick="selectChoose(this)" class="selectChoose" style="background-color: rgb(168,131,68); width: 70px;" data-toggle="modal" data-target="#setChooseModal" >查看选项</button>'
						: (reps.data.list[i].type_name == "多选题"? '<button onclick="selectChoose(this)" class="selectChoose" style="background-color: rgb(168,131,68); width: 70px;" data-toggle="modal" data-target="#setChooseModal">查看选项</button>' : '无');
						if(reps.data.list[i].problem_state==1){
						document.getElementById("table").innerHTML+=`<tr>
						    <td>${reps.data.list[i].problem_id}</td>
						    <td>${reps.data.list[i].problem_text}</td>
						    <td>${reps.data.list[i].type_name}</td>
						    <td>${choose}</td>
							<td>${reps.data.list[i].problem_answer}</td>
							<td>${reps.data.list[i].user_name}</td>
							<td>${reps.data.list[i].project_name}</td>
						    <td><button onclick="modifyProblem(this)" class="altBtn" style="background-color: rgb(75,125,252);" data-toggle="modal" data-target="#setChooseModal" data-toggle="modal" data-target="#setChooseModal">修改</button>
						 <button onclick="delProblem(this)" class="altBtn" style="background-color: rgb(221,110,78)">禁用</button></td>
							</tr>`
							}else{
								document.getElementById("table").innerHTML+=`<tr>
									<td>${reps.data.list[i].problem_id}</td>
									<td>${reps.data.list[i].problem_text}</td>
									<td>${reps.data.list[i].type_name}</td>
									<td>${choose}</td>
									<td>${reps.data.list[i].problem_answer}</td>
									<td>${reps.data.list[i].user_name}</td>
									<td>${reps.data.list[i].project_name}</td>
								    <td><button onclick="modifyProblem(this)" class="altBtn" style="background-color: rgb(75,125,252);" data-toggle="modal" data-target="#setChooseModal">修改</button>
								 <button onclick="reProblem(this)" class="altBtn" style="background-color: rgb(0, 100, 48)">恢复</button></td>
									</tr>`
							}
					}
					document.getElementById("table").innerHTML+=`</table>`;
	    },
	    error:function (reps){
	        document.write(reps.responseText)
	    },
	})
 }

 updateTable(1);
 document.getElementById("upPage").onclick = function () {
     let currentPage = document.getElementById("currentPage").innerText;
     if (currentPage > 1) {
         currentPage--;
         updateTable(currentPage);
         document.getElementById("currentPage").innerText = currentPage;
     } else {
         alert("已经是第一页啦！");
     }
 }
 document.getElementById("downPage").onclick = function () {
     let currentPage = document.getElementById("currentPage").innerText;
     let sumPage = document.getElementById("sumPage").innerText;
     if (currentPage < sumPage) {
         currentPage++;
         updateTable(currentPage);
         document.getElementById("currentPage").innerText = currentPage;
     } else {
         alert("已经是最后一页啦！");
     }
 }
 function delMoreProblem(){
	 var arr = [];	//声明一个数组用来存放遍历出来的checkbox value值
	 $("input[name='choose']:checked").each(function(i){	//遍历
	 	arr.push($(this).val());	//将我们遍历出来的值push到数组中
	 	//最后可以提交arr就可以实现将我们选中的checkbox的value值提交
	 	console.log("arr:"+arr);
	 })
	let arrJSON=JSON.stringify(arr);
	// $.ajax({
	//     url:'delMoreProblem',
	//     type:'POST',
	//     data:{
	//         'problemId' : arrJSON,
	//     },
	//     dataType:'JSON',
	//     async:true,
	// 	success:function(reps){
	// 		alert("禁用成功!");
	// 		let currentPage = document.getElementById("currentPage").innerText;
	// 		updateTable(currentPage);
	//     },
	//     error:function (reps){
	//         document.write(reps.responseText)
	//     },
	// })
 }
 function delProblem(e){
	let problemId = e.parentNode.parentNode.children[0].innerText.trim();
	$.ajax({
	    url:'delProblem',
	    type:'POST',
	    data:{
	        'problemId' : problemId,
	    },
	    dataType:'JSON',
	    async:true,
		success:function(reps){
			alert("禁用成功!");
			let currentPage = document.getElementById("currentPage").innerText;
			updateTable(currentPage);
	    },
	    error:function (reps){
	        document.write(reps.responseText)
	    },
	})
	
 }
 function reProblem(e){
 	let problemId = e.parentNode.parentNode.children[0].innerText.trim();
 	$.ajax({
 	    url:'reProblem',
 	    type:'POST',
 	    data:{
 	        'problemId' : problemId,
 	    },
 	    dataType:'JSON',
 	    async:true,
 		success:function(reps){
 			alert("恢复成功!");
 			let currentPage = document.getElementById("currentPage").innerText;
 			updateTable(currentPage);
 	    },
 	    error:function (reps){
 	        document.write(reps.responseText)
 	    },
 	})
 }
 var chooArray = [];
 function modifyProblem(e){

	document.getElementById("setChooseModaBody").innerHTML=`<div id="setChooseModaBody">`
	if(e.parentNode.parentNode.children[2].innerText.trim()=="单选题"){
	let answer= e.parentNode.parentNode.children[4].innerText.trim();
	let answerId=answer.charCodeAt(0)-65;
	for(let i = 0; i < chooArray.length; i++){
		if(answerId==i){
		document.getElementById("setChooseModaBody").innerHTML+=`<div style="font-size: 15px;" class="choose">
			选项${i+1}：是否是答案：<input type="radio" class="samllChoose" name="choose" value="${i+1}" checked>
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="${chooArray[i].chooseText}" id="chooseAValue"></textarea>
			</div>
		</div>`
		}else{
			document.getElementById("setChooseModaBody").innerHTML+=`<div style="font-size: 15px;" class="choose">
				选项${i+1}：是否是答案：<input type="radio" class="samllChoose" name="choose" value="${i+1}" >
				<br />
				<div>
					<textarea class="form-control" rows="2" placeholder="${chooArray[i].chooseText}" id="chooseAValue"></textarea>
				</div>
			</div>`
		}
	}
	}else{
	let answer= e.parentNode.parentNode.children[5].innerText.trim().split(",");
	let answerId=-1;
		for(let i = 0; i < chooArray.length; i++){
			for(let j = 0; j < answer.length; j++){
			answerId=answer[j].charCodeAt(0)-65;
				if(answerId==i){
					break;
				}
			}
			if(answerId==i){
			document.getElementById("setChooseModaBody").innerHTML+=`<div style="font-size: 15px;" class="choose">
				选项${i+1}：是否是答案：<input type="checkbox" id="changeAll"  name="choose" value="${i+1}" checked>
				<br />
				<div>
					<textarea class="form-control" rows="2" placeholder="${chooArray[i].chooseText}" id="chooseAValue"></textarea>
				</div>
			</div>`
			answerId=-1;
			}else{
				document.getElementById("setChooseModaBody").innerHTML+=`<div style="font-size: 15px;" class="choose">
				选项${i+1}：是否是答案：<input type="checkbox" id="changeAll"  name="choose" value="${i+1}">
				<br />
				<div>
					<textarea class="form-control" rows="2" placeholder="${chooArray[i].chooseText}" id="chooseAValue"></textarea>
				</div>
			</div>`
			}
		}
	}
	document.getElementById("setChooseModaBody").innerHTML+=`</div>`
 }
 
 function selectChoose(e){
	 let problemId = e.parentNode.parentNode.children[0].innerText.trim();
	$.ajax({
	    url:'selectChoose',
	    type:'POST',
	    data:{
	        'problemId' : problemId
	    },
	    dataType:'JSON',
	    async:true,
		success:function(reps){
			chooArray = [];
			for(let i = 0; i < reps.data.list.length; i++){
			var obj = {chooseId: reps.data.list[i].choose_id,chooseLetter: reps.data.list[i].choose_letter,chooseText: reps.data.list[i].choose_text};
			console.log(obj);
			chooArray.push(obj);
			}
			modifyProblem(e);
	    },
	    error:function (reps){
	        document.write(reps.responseText)
	    },
	})
 }
 
 


