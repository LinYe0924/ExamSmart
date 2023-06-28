function changeCode(imgobj) {
    imgobj.src = imgobj.src + "?" + Math.random();

}



//确认注册
function regstuBtn() {
    let phone = document.getElementById("phone").value;
    let ID = document.getElementById("ID").value;
    let Name = document.getElementById("Name").value;
    let Email = document.getElementById("Email").value;
    let pwd = document.getElementById("pwd").value;
    let repwd = document.getElementById("repwd").value;
    let code = document.getElementById("code").value;
	// 定义一个正则表达式来匹配身份证号
	var regex = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
	// 使用typeof运算符检查id是否定义了
	if (typeof ID === 'undefined') {
	  alert("请输入身份证号");
	  return;
	} else {
	  // 使用正则表达式的test方法检查id是否符合格式
	  if (regex.test(id)) {
	  } else {
		alert("身份证号格式错误！");
		return;
	  }
	}
	// 定义一个正则表达式来匹配手机号
	var rege = /^0[6-7]\d{8}$/;
	
	// 使用typeof运算符检查phone是否定义了
	if (typeof phone === 'undefined') {
	  alert("请输入手机号");
	  return;
	} else {
	  // 使用正则表达式的test方法检查phone是否符合格式
	  if (rege.test(phone)) {
	  } else {
	    alert("手机号格式错误！");
		return;
	  }
	}
	// 定义一个正则表达式来匹配邮箱地址
	var reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	// 定义一个变量email，赋值为一个邮箱地址
	var email = "example@gmail.com";
	
	// 使用typeof运算符检查email是否定义了
	if (typeof email === 'undefined') {
	  alert("请输入邮箱");
	  return;
	} else {
	  // 使用正则表达式的test方法检查email是否符合格式
	  if (reg.test(email)) {
	  } else {
	    alert("邮箱格式错误！");
		return;
	  }
	}
	
    if (pwd != repwd) {
        alert("两次密码不一致");
    } else {
        $.ajax({
            url: "stuReg",
            type: "GET",
            data: {
                "phone": phone,
                "ID": ID,
                "Name": Name,
                "Email": Email,
                "pwd": $.md5(pwd),
                "code": code
            },
            dataType: "JSON",
            async: true,
            success: function (response) {
                var res = response.data.res;
                if (res==1){
                    alert("注册成功,即将返回登入窗口");
                    window.location.href = "page?p=studentlogin";
                }else if (res==0){
                    alert("注册失败");
                    document.getElementById("phone").value="";
                    document.getElementById("ID").value="";
                    document.getElementById("Name").value="";
                    document.getElementById("pwd").value="";
                    document.getElementById("repwd").value="";
                    document.getElementById("code").value="";
                }else if (res==3){
                    alert("验证码错误");
                    document.getElementById("code").value="";
                }
            },
            error: function (response) {
            }


        })
    }

}
function  returnLogin(){
    alert("即将返回登入窗口");
    window.location.href = "page?p=studentlogin";
}