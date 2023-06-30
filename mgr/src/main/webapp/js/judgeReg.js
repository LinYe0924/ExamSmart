function updateInfo(){
	let userId = localStorage.getItem("userId");
	let userName= localStorage.getItem("userName");
	console.log("userName::"+userName);
	document.getElementById("userNameValue").value=userName;
	
	$.ajax({
	    url:'selectExam',
	    type:'POST',
	    data:{
		'userId' : userId
	    },
	    dataType:'JSON',
	    async:true,
		success:function(reps){
			document.getElementById("examValue").innerHTML=`<select class="input"  id="examValue">
						<option value="0">未选择</option>`
						for (var i = 0; i < reps.data.list.length; i++) {
							document.getElementById("examValue").innerHTML+=`<option value="${reps.data.list[i].exam_id}">${reps.data.list[i].exam_name}</option>`
						}
				document.getElementById("examValue").innerHTML+=`</select>`
	    },
	    error:function (reps){
	        document.write(reps.responseText)
	    },
	})
}
updateInfo();
function selectRegs(){
	let userName= localStorage.getItem("userName");
	let currentPage = document.getElementById("currentPage").innerText;
	let examId=document.getElementById("examValue").value;
	$.ajax({
	    url:'selectRegs',
	    type:'POST',
	    data:{
		'examId' : examId,
		'page':currentPage
	    },
	    dataType:'JSON',
	    async:true,
		success:function(reps){
			document.getElementById("table").innerHTML=`<table class="informationTable" id="table" style="border-collapse: collapse;">
		              <colgroup>
		                <col style="width: 10%;">
						<col style="width: 20%;">
						<col style="width: 10%;">
						<col style="width: 10%;">
						<col style="width: 10%;">
						<col style="width: 20%;">
						<col style="width: 10%;">
		              </colgroup>
					<tr style="background-color: rgb(229,229,229);">
						<td>报名编号</td>
						<td>考试名称</td>
						<td>组织者</td> 
						<td>考生</td> 
						<td>审核状态</td> 
						<td>报名时间</td>
						<td>操作</td>
		            </tr>`
			for (var i = 0; i < reps.data.list.length; i++) {
				if(reps.data.list[i].pass_state==0){
				//将时间戳转化为可读格式
				let time=new Date(reps.data.list[i].reg_time);
				let formatted = time.toLocaleString ();
				document.getElementById("table").innerHTML+=`<tr>
						 <td>${reps.data.list[i].reg_id}</td>
						 <td>${reps.data.list[i].exam_name}</td>
						 <td>${userName}</td>
						 <td>${reps.data.list[i].stu_name}</td>
						 <td>未审核</td>
						 <td>${formatted}</td>
						 <td><button onclick="get(this)" class="altBtn" style="background-color: rgb(75,125,252);">通过</button>
						 <button onclick="pass(this)" style="background-color: rgb(221,110,78)" class="delBtn">驳回</button></td>
					</tr>`
			}else if(reps.data.list[i].pass_state==-1){
				//将时间戳转化为可读格式
				let time=new Date(reps.data.list[i].reg_time);
				let formatted = time.toLocaleString ();
				document.getElementById("table").innerHTML+=`<tr>
						 <td>${reps.data.list[i].reg_id}</td>
						 <td>${reps.data.list[i].exam_name}</td>
						 <td>${userName}</td>
						 <td>${reps.data.list[i].stu_name}</td>
						 <td>已驳回</td>
						 <td>${formatted}</td>
						 <td></td>
					</tr>`
			}else{
				//将时间戳转化为可读格式
				let time=new Date(reps.data.list[i].reg_time);
				let formatted = time.toLocaleString ();
				document.getElementById("table").innerHTML+=`<tr>
						 <td>${reps.data.list[i].reg_id}</td>
						 <td>${reps.data.list[i].exam_name}</td>
						 <td>${userName}</td>
						 <td>${reps.data.list[i].stu_name}</td>
						 <td>已通过</td>
						 <td>${formatted}</td>
						 <td></td>
					</tr>`
			}
			}
			document.getElementById("table").innerHTML+=`</table>`
	    },
	    error:function (reps){
	        document.write(reps.responseText)
	    },
	})
}
function get(e){
	let regId=e.parentNode.parentNode.children[0].innerText.trim();
	$.ajax({
	    url: 'getReg',
	    type: 'POST',
	    data: {
			'regId':regId
	    },
	    dataType: 'JSON',
	    async: true,
	    success: function (reps) {
			selectRegs();
		},error:function (reps){
		        document.write(reps.responseText)
		    }
		})
}
function pass(e){
	let regId=e.parentNode.parentNode.children[0].innerText.trim();
		$.ajax({
		    url: 'passReg',
		    type: 'POST',
		    data: {
				'regId':regId
		    },
		    dataType: 'JSON',
		    async: true,
		    success: function (reps) {
				selectRegs();
			},error:function (reps){
			        document.write(reps.responseText)
			    }
			})
	}

