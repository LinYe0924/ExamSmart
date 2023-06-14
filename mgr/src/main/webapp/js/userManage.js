function setSelect(){
	let roleId = localStorage.getItem("roleId");
	if(roleId==2){
		document.getElementById("roleValue").innerHTML=`
            <select class="input"  id="roleValue">
                <option value="3">教师</option>
            </select>`
	}
}
setSelect();
function setUser(e) {
        $("#overCurtain2").fadeIn();
        let userId = e.parentNode.parentNode.children[0].innerText.trim();
		let userName = e.parentNode.parentNode.children[1].innerText.trim();
		let userTel = e.parentNode.parentNode.children[2].innerText.trim();
		let role;
		if(e.parentNode.parentNode.children[3].innerText.trim()=="管理员"){
			role=2;
		}else{
			role=3;
		}
        $("#setInput").val(userId);
		$("#uName").val(userName);
		$("#userTel").val(userTel);
		$("#setRole").val(role);
		// console.log( "userTel:"+$("#userTel").val());
       $("#confirm2").click(function(){
		   $.ajax({
		       url:'setUserInfo',
		       type:'POST',
		       data:{
		           userId:userId,
				   userName:$("#uName").val(),
				   userTel:$("#userTel").val(),
				   roleId:$("#setRole").val()
		       },
		       success:function (){
				   $("#overCurtain2").fadeOut();
		          let currentPage = document.getElementById("currentPage").innerText;
		          selectUser(currentPage);
		       },
		       error:function (reps){
		           document.write(reps.responseText);
		       }
		   })
	   })
    }

    $("#closeOver2").click(function () {
        $("#overCurtain2").fadeOut();
    })
    $("#insert").click(function () {
        $("#overCurtain").fadeIn();
    })

    $("#closeOver").click(function () {
        $("#overCurtain").fadeOut();
    })
    $("#selectBtn").click(function (){
        
    })
	$("#confirm").click(function insertUser(){
		let userName=$("#uAcc").val();
		let userTel=$("#uTel").val();
		var telReg = /^1[3-9]\d{9}$/; //定义正则表达式，匹配以1开头，第二位为3-9，后面跟9位数字的手机号
		let userEmail=$("#uEmail").val();
		let roleId=$("#role").val();
		if(userName.length==0||userTel.length==0||userEmail.length==0){
			alert("请将信息填写完整！");
		}else{
			if(telReg.test(userTel)){ //判断手机号是否符合正则表达式
				var emailReg = /^\w+@\w+\.\w+$/; //定义正则表达式，匹配以字母或数字开头，中间有@符号，后面有一个或多个字母或数字和一个点号的邮箱格式
				if(emailReg.test(userEmail)){ //判断邮箱是否符合正则表达式
					$.ajax({
					    url:'insertUser',
					    type:'POST',
					    data:{
						   userName : userName,
						   userTel : userTel,
						   userEmail :userEmail,
						   roleId : roleId
					    },
					    success:function (){
							$("#overCurtain").fadeOut();
					       let currentPage = document.getElementById("currentPage").innerText;
					       selectUser(currentPage);
					    },
					    error:function (reps){
					        document.write(reps.responseText);
					    }
					})
				}else{
					alert("邮箱格式错误"); //弹出提示
				}
			}else{
				alert("手机号格式错误"); //弹出提示
			}
		}
	})
	
	function resettingPwd(e){
		let userId = e.parentNode.parentNode.children[0].innerText.trim();
		let userName=e.parentNode.parentNode.children[1].innerText.trim();
		$.ajax({
		    url:'resettingPwd',
		    type:'POST',
		    data:{
		        userId:userId
		    },
		    success:function (){
		       alert(userName+"的密码重置成功！");
		    },
		    error:function (reps){
		        document.write(reps.responseText);
		    }
		})
	}
    function delUser(e) {
    console.log(e.parentNode.parentNode.children[0].innerText.trim());
    // $.ajax({
    //     url:'delUser',
    //     type:'POST',
    //     data:{
    //         uid:e.parentNode.parentNode.children[0].innerText.trim()
    //     },
    //     success:function (){
    //         let currentPage = document.getElementById("currentPage").innerText;
    //         selectUser(currentPage);
    //     },
    //     error:function (reps){
    //         document.write(reps.responseText);
    //     }
    // })
    }
    let currentPage;
    let sumPage;
    function selectUser(page) {
		let roleId = localStorage.getItem("roleId");
        $.ajax({
            url: 'selectUser',
            type: 'POST',
            data: {
                page: page,
				roleId:roleId
            },
            dataType: 'JSON',
            async: true,
            success: function (reps) {
                console.log("最大页面："+reps.data.maxPage);
                $("#sumPage").text(reps.data.maxPage);
                // console.log(reps);
                // var list=reps.data.list;
                // console.log(list.length);
                document.getElementById("table").innerHTML=` <table class="informationTable" id="table" style="border-collapse: collapse;">
            <tr style="background-color: rgb(229,229,229);">
                <td>用户编号</td>
                <td>用户名</td>
                <td>手机号</td>
                <td>角色</td>
                <td>注册时间</td>
				<td>状态</td>
                <td style="width: 490px">操作</td>
            </tr>`;
                for (let i = 0; i < reps.data.list.length; i++) {
					let role = reps.data.list[i].role_id == 1? '超级管理员' 
					: (reps.data.list[i].role_id == 2? '管理员' :'教师');
					let state=reps.data.list[i].user_state == 0? '已停用' :'启用中';
					//将时间戳转化为可读格式
					let time=new Date(reps.data.list[i].user_time);
					let formatted = time.toISOString().split('T')[0] + ' ' + time.toISOString().split('T')[1].substring(0, 5); 
                    //判断超级管理员并无法对其进行操作
					if(reps.data.list[i].user_id==1){
						document.getElementById("table").innerHTML+=`<tr>
						    <td>${reps.data.list[i].user_id}</td>
						    <td>${reps.data.list[i].user_name}</td>
						    <td>${reps.data.list[i].user_tel}</td>
						    <td>${role}</td>
							<td>${formatted}</td>
						    <td>${state}</td>
							<td></td>
							</tr>`
							// 根据用户状态决定禁用按钮的样式
					}else if(reps.data.list[i].user_state==0){
						document.getElementById("table").innerHTML+=`<tr>
						    <td>${reps.data.list[i].user_id}</td>
						    <td>${reps.data.list[i].user_name}</td>
						    <td>${reps.data.list[i].user_tel}</td>
						    <td>${role}</td>
							<td>${formatted}</td>
						    <td>${state}</td>
						    <td>
						        <button onclick="setUser(this)" class="altBtn" style="background-color: rgb(75,125,252);">修改</button>
						        <button onclick="delUser(this)" style="background-color: rgb(221,110,78)" class="delBtn">删除</button>
						        <button onclick="setState(this)"style="background-color: rgb(85,107,47)" class="disBtn">恢复</button>
						        <button onclick="resettingPwd(this)" style="background-color: rgb(231,168,42); width:80px" class="altPwdBtn">重置密码</button>
						    </td>
						</tr>`
					}else{
						document.getElementById("table").innerHTML+=`<tr>
						    <td>${reps.data.list[i].user_id}</td>
						    <td>${reps.data.list[i].user_name}</td>
						    <td>${reps.data.list[i].user_tel}</td>
						    <td>${role}</td>
							<td>${formatted}</td>
						    <td>${state}</td>
						    <td>
						        <button onclick="setUser(this)" class="altBtn" style="background-color: rgb(75,125,252);">修改</button>
						        <button onclick="delUser(this)" style="background-color: rgb(221,110,78)" class="delBtn">删除</button>
						        <button onclick="setState(this)"style="background-color: rgb(77,181,206)" class="disBtn"> 禁用</button>
						        <button onclick="resettingPwd(this)" style="background-color: rgb(231,168,42); width:80px" class="altPwdBtn">重置密码</button>
						    </td>
						</tr>`
					}
					
                }
                document.getElementById("table").innerHTML+=`</table>`;

            },
            error:function (reps){
                document.write(reps.responseText)
            }
        })
    }
	function setState(e) {
		let userId=e.parentNode.parentNode.children[0].innerText.trim();
		let state=e.parentNode.parentNode.children[5].innerText.trim();
		console.log("state:"+state);
		let setNum;
	if(state=="已停用"){
		setNum=1;
		}else{
		setNum=0;
	}
	console.log("setNum:"+setNum);
		$.ajax({
		    url: 'setState',
		    type: 'POST',
		    data: {
		        userId: userId,
				setNum:setNum
		    },
		    dataType: 'JSON',
		    async: true,
		    success: function (reps) {
				let currentPage = document.getElementById("currentPage").innerText;
				selectUser(currentPage);
			},
            error:function (reps){
                document.write(reps.responseText)
            }
		})
	
	}
    document.getElementById("upPage").onclick = function () {
        let currentPage = document.getElementById("currentPage").innerText;
        if (currentPage > 1) {
            currentPage--;
            selectUser(currentPage);
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
            selectUser(currentPage);
            document.getElementById("currentPage").innerText = currentPage;
        } else {
            alert("已经是最后一页啦！");
        }
    }
    selectUser(1);
   
	$("#selectBtn").click(function(){
		let userName=$("#nameValue").val();
		let userTel=$("#telValue").val();
		let selectRoleId=$("#selectRoleValue").val();
		let stateId=$("#selectStatesValue").val();
		console.log("userName："+userName);
		console.log("selectRoleId："+selectRoleId);
		console.log("stateId："+stateId);
		$.ajax({
		    url: 'findUser',
		    type: 'POST',
		    data: {
				userName:userName,
				userTel:userTel,
				selectRoleId:selectRoleId,
				stateId:stateId,
		    },
		    dataType: 'JSON',
		    async: true,
		    success: function (reps) {
				console.log("最大页面："+reps.data.maxPage);
				    $("#sumPage").text(reps.data.maxPage);
				    // console.log(reps);
				    // var list=reps.data.list;
				    // console.log(list.length);
				    document.getElementById("table").innerHTML=` <table class="informationTable" id="table" style="border-collapse: collapse;">
				<tr style="background-color: rgb(229,229,229);">
				    <td>用户编号</td>
				    <td>用户名</td>
				    <td>手机号</td>
				    <td>角色</td>
				    <td>注册时间</td>
					<td>状态</td>
				    <td style="width: 490px">操作</td>
				</tr>`;
				    for (let i = 0; i < reps.data.list.length; i++) {
						let role = reps.data.list[i].role_id == 1? '超级管理员' 
						: (reps.data.list[i].role_id == 2? '管理员' :'教师');
						let state=reps.data.list[i].user_state == 0? '已停用' :'启用中';
						//将时间戳转化为可读格式
						let time=new Date(reps.data.list[i].user_time);
						let formatted = time.toISOString().split('T')[0] + ' ' + time.toISOString().split('T')[1].substring(0, 5); 
				        //判断超级管理员并无法对其进行操作
						if(reps.data.list[i].user_id==1){
							document.getElementById("table").innerHTML+=`<tr>
							    <td>${reps.data.list[i].user_id}</td>
							    <td>${reps.data.list[i].user_name}</td>
							    <td>${reps.data.list[i].user_tel}</td>
							    <td>${role}</td>
								<td>${formatted}</td>
							    <td>${state}</td>
								<td></td>
								</tr>`
								// 根据用户状态决定禁用按钮的样式
						}else if(reps.data.list[i].user_state==0){
							document.getElementById("table").innerHTML+=`<tr>
							    <td>${reps.data.list[i].user_id}</td>
							    <td>${reps.data.list[i].user_name}</td>
							    <td>${reps.data.list[i].user_tel}</td>
							    <td>${role}</td>
								<td>${formatted}</td>
							    <td>${state}</td>
							    <td>
							        <button onclick="setUser(this)" class="altBtn" style="background-color: rgb(75,125,252);">修改</button>
							        <button onclick="delUser(this)" style="background-color: rgb(221,110,78)" class="delBtn">删除</button>
							        <button onclick="setState(this)"style="background-color: rgb(85,107,47)" class="disBtn">恢复</button>
							        <button onclick="resettingPwd(this)" style="background-color: rgb(231,168,42); width:80px" class="altPwdBtn">重置密码</button>
							    </td>
							</tr>`
						}else{
							document.getElementById("table").innerHTML+=`<tr>
							    <td>${reps.data.list[i].user_id}</td>
							    <td>${reps.data.list[i].user_name}</td>
							    <td>${reps.data.list[i].user_tel}</td>
							    <td>${role}</td>
								<td>${formatted}</td>
							    <td>${state}</td>
							    <td>
							        <button onclick="setUser(this)" class="altBtn" style="background-color: rgb(75,125,252);">修改</button>
							        <button onclick="delUser(this)" style="background-color: rgb(221,110,78)" class="delBtn">删除</button>
							        <button onclick="setState(this)"style="background-color: rgb(77,181,206)" class="disBtn"> 禁用</button>
							        <button onclick="resettingPwd(this)" style="background-color: rgb(231,168,42); width:80px" class="altPwdBtn">重置密码</button>
							    </td>
							</tr>`
						}
						
				    }
				    document.getElementById("table").innerHTML+=`</table>`;
			},
		    error:function (reps){
		        document.write(reps.responseText)
		    }
		})
	})