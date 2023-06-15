
 let moreChoose=1;
 let userName=localStorage.getItem("userName");
$("#userNameValue").val(userName);
$("#changeAll").click(function(){
	getChoose();
	var changAll=document.getElementById("changeAll");
	console.log("changAll:"+changAll.checked);
	if(changAll.checked){
		console.log("false");
	var checkboxes = document.querySelectorAll("input[type='checkbox']"); //获取所有复选框
	for (var i = 0; i < checkboxes.length; i++) {
	  checkboxes[i].checked = true; //设置为选中
	}
	}else{
		console.log("true");
		var checkboxes = document.querySelectorAll("input[type='checkbox']"); //获取所有复选框
		for (var i = 0; i < checkboxes.length; i++) {
		  checkboxes[i].checked = false; //设置为未选中
		}
	}
})
function getChoose(){
	var arr = [];	//声明一个数组用来存放遍历出来的checkbox value值
	$("input[name='choose']:checked").each(function(i){	//遍历
		arr.push($(this).val());	//将我们遍历出来的值push到数组中
		//最后可以提交arr就可以实现将我们选中的checkbox的value值提交
		console.log("arr:"+arr);
	})
}
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
	 updateBtn();
	var oneChoose=document.getElementById("oneChoose");
	oneChoose.style.backgroundColor="rgb(75, 125, 252)";
	oneChoose.style.color="#FFF";
	 $(".panel").html(`
		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
		单选题
		</div>
		<div class="panel-body">
		<div class="inputText" style="margin-left: -4px;">
		    <div class="classFont">题号</div>
		    <input type="text" class="input" id="bankProValue" readonly="readonly">
		</div>
		</br>
		<div>
			<div>请输入题目内容：</div>
			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容"></textarea></div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项一：是否是答案：<input type="radio" class="samllChoose" name="choose" value="1">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容"></textarea>
			</div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项二：是否是答案：<input type="radio" class="samllChoose" name="choose" value="2">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容"></textarea>
			</div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项三：是否是答案：<input type="radio" class="samllChoose" name="choose" value="3">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容"></textarea>
			</div>
		</div>
		<div style="font-size: 15px;" class="choose">
			选项四：是否是答案：<input type="radio" class="samllChoose" name="choose" value="4">
			<br />
			<div>
				<textarea class="form-control" rows="2" placeholder="请输入选项内容"></textarea>
			</div>
		</div>
		</div>
		`);
 })
 $("#moreChoose").click(function(){
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
		<div class="inputText" style="margin-left: -4px;">
		    <div class="classFont">题号</div>
		    <input type="text" class="input" id="bankProValue" readonly="readonly">
		</div>
		</br>
 		<div>
 			<div>请输入题目内容：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容"></textarea></div>
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
	 updateBtn();
 	var blank=document.getElementById("blank");
 	blank.style.backgroundColor="rgb(75, 125, 252)";
	blank.style.color="#FFF";

 	 $(".panel").html(`
 		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
 		填空题
 		</div>
 		<div class="panel-body">
		<div class="inputText" style="margin-left: -4px;">
		    <div class="classFont">题号</div>
		    <input type="text" class="input" id="bankProValue" readonly="readonly">
		</div>
		</br>
 		<div>
 			<div>请输入题目内容：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容"></textarea></div>
 		</div>
 		<div>
 			<div>请输入答案：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入答案"></textarea></div>
 		</div>
 		</div>
 		`);
 })


 $("#yesOrNo").click(function(){
	 updateBtn();
 	var yesOrNo=document.getElementById("yesOrNo");
 	yesOrNo.style.backgroundColor="rgb(75, 125, 252)";
	yesOrNo.style.color="#FFF";
 	 $(".panel").html(`
 		<div class="panel-heading" style="background-color: rgb(75, 125, 252); border-top: none; font-size: 20px; color: #FFF;">
 		判断题
 		</div>
 		<div class="panel-body">
		<div class="inputText" style="margin-left: -4px;">
		    <div class="classFont">题号</div>
		    <input type="text" class="input" id="bankProValue" readonly="readonly">
		</div>
		</br>
 		<div>
 			<div>请输入题目内容：</div>
 			<div><textarea class="form-control" rows="3" placeholder="请输入题目内容"></textarea></div>
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
	 console.log("略略略");
	let chooseText=document.getElementById("chooseText").value;
	let answer= document.getElementById("yesAnswer").checked;
	let yesAnswer;
	if(answer){
		yesAnswer="是";
	}else{
		yesAnswer="否";
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
 function selectChoose(e){
	 
 }
 
 


