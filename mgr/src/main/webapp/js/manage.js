// 从浏览器的本地缓存获取角色的编号和角色
let userId = localStorage.getItem("userId");
let roleId = localStorage.getItem("roleId");
let userName= localStorage.getItem("userName");
console.log("userId:"+userId);
console.log("roleId:"+roleId);
console.log("userName:"+userName);
$("#userName").text("欢迎："+userName);
function selectMenu(){
	if(roleId==1||roleId==2){
		document.getElementById("left").innerHTML=`
			<div class="item">
			<div class="first_item">前台管理</div>
			<div class="cecond_item" >题库管理</div>
			<div class="cecond_item">资讯管理</div>
			<div class="cecond_item">成绩管理</div>
			<div class="cecond_item">考生管理</div>
			<div class="cecond_item">试卷管理</div>

			</div>
			<div class="item">
			<div class="first_item">后台管理</div>
			<div class="cecond_item" page="userManage">人员管理</div>
			</div>`
	}else if(roleId==3){
		document.getElementById("left").innerHTML=
		`<div class="item">
			<div class="first_item">前台管理</div>
			<div class="cecond_item" >题库管理</div>
			<div class="cecond_item">资讯管理</div>
			<div class="cecond_item">成绩管理</div>
			<div class="cecond_item">考生管理</div>
			<div class="cecond_item">试卷管理</div>
		</div>`
	}
	
}
selectMenu();
var left=document.getElementById("left");
			left.onclick=function(event){//event为被选中的对象
			var targetObj=event.target;
				if(targetObj.className=="first_item"){//判断如果被点击的是一级标题
					var eles=targetObj.parentElement.children;//返回所有子节点
							for(var i=0;i<eles.length;i++){
							if(eles[i].className=="cecond_item"){
								if(eles[i].style.display=="block"){
									eles[i].style.display="none";
								} else {
									eles[i].style.display="block";
								}
							}
							}
				}else if(targetObj.className=="cecond_item"){
				//获取链接
				var page=targetObj.getAttribute("page");
				//获取iframe对象
				var frame=document.getElementById("frame");
				//修改iframe的src属性
				frame.src="toPage?page="+page;
				}
		}