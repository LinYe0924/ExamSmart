
function updateCode(imgObj){
    imgObj.src = imgObj.src+"?"+Math.random();
}
$("#loginBut").click(function(){
    console.log("点击登录")
    let tel = document.getElementById("telText").value;
    let pwd = document.getElementById("pwdText").value;
    let code = document.getElementById("codeText").value;
    pwd = $.md5(pwd);
    $.ajax({
        url:'doLogin',
        type:'GET',
        data:{
            'uTel' : tel,
            'uPwd' : pwd,
            'uCode' : code
        },
        dataType:'JSON',
        async:true,
        success:function(reps){
            console.log(reps);
            var userId=reps.data.userId;
			var roleId=reps.data.roleId;	
			var userName=reps.data.userName;
			var state=reps.data.state;
            if(userId>0){
				if(state>0){
                // alert("登陆成功");
				console.log("userId："+userId);
                window.location.href="toPage?page="+reps.data.location;
                console.log(window.location.href);
				//存入浏览器的本地缓存
				localStorage.setItem("userId", userId);
				localStorage.setItem("roleId", roleId);
				localStorage.setItem("userName", userName);
            }else{
				alert("您的账号已被封禁，请联系您的上级管理员解封！");
			}
			}
        },
        error:function (reps){
            document.write(reps.responseText)
        }
    })
})