package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.UserManagePojo;
import indi.ye.pojo.UserPojo;
import indi.ye.service.*;
import indi.ye.until.CodePicture;
import indi.ye.until.UserUntil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserControl
 * @Description: 这是用户的control
 * @Author: ye
 * @Date: 2023/6/7 14:41
 */
@Controller
@RestController
public class UserControl {
    @Resource
    LoginService loginService;
    @Resource
    SelectUserService selectUserService;
    @Resource
    SetStateService setStateService;
    @Resource
    ResettingPwdService resettingPwdService;
    @Resource
    SetUserInfoService setUserInfoService;
    @Resource
    InsertUserService insertUserService;
    @Resource
    FindUserService findUserService;
    @Resource
    SelectSetPwdService selectSetPwdService;
    @Resource
    SetPwdService setPwdService;
    @GetMapping("/doLogin")
    public JsonDto login(HttpServletRequest req){

        System.out.println("登录！！！！");
        String uTel = req.getParameter("uTel");
        String uPwd = req.getParameter("uPwd");
        System.out.println("加密后的密码："+uPwd);
        String code = req.getParameter("uCode");
        String codeStr = (String) req.getSession().getAttribute("codeStr");
        UserPojo userPojo=new UserPojo(uTel,uPwd);
        String res=loginService.login(uTel,uPwd);
        int userId=0;
        int roleId=0;
        int state=0;
        String userName="";
        String location;
        if(codeStr.equalsIgnoreCase(code)){
            if (res.equals("error")){
                location="pwdError";
            }else {
                String[] Res = res.split(",");
                userId= Integer.parseInt(Res[0]);
                roleId=Integer.parseInt(Res[1]);
                userName=Res[2];
                state=Integer.parseInt(Res[3]);
                System.out.println("res:"+res);
                System.out.println("roleId:"+roleId);
                System.out.println("userName:"+userName);
                String token = UserUntil.getToken(userPojo);
                System.out.println("token: "+token);
                Claims body = UserUntil.decryptToken(token);
                Date expiration = body.getExpiration();
                if (UserUntil.checkExpired(expiration)){
                    System.out.println("未过期！！");
                }else {
                    System.out.println("已过期，请重新登录！！");
                }
                String date = UserUntil.getDateString(body.getExpiration().getTime());
                String date1 = UserUntil.getDateString(body.getIssuedAt().getTime());
                System.out.println("过期时间："+date+"登陆时间："+date1);
//            System.out.println("claims: "+claims);
                location="manage";
            }

        }else {
            userId=-1;
            location="codeError";
        }
        System.out.println("需要的验证码："+codeStr);
        System.out.println("输入的验证码："+code);
        JsonDto jsonDto= new JsonDto();
        jsonDto.getData().put("userId",userId);
        jsonDto.getData().put("roleId",roleId);
        jsonDto.getData().put("userName",userName);
        jsonDto.getData().put("state",state);
        jsonDto.getData().put("location",location);

        return jsonDto;
    }
    @GetMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response){

        //获取工具的对象
        Object[] objects = CodePicture.createImage();
        //获取生成的验证码
        String codeStr = (String) objects[0];

        //存储到本地session
        HttpSession session = request.getSession();
        session.setAttribute("codeStr",codeStr);
        //生成图片发到前端
        try {
            ImageIO.write((RenderedImage) objects[1],"jpg",response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/selectUser")
    public JsonDto selectUser(HttpServletRequest req){
        int page = Integer.parseInt(req.getParameter("page"));
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        int num = selectUserService.selectUserSize(roleId);
        List<UserManagePojo> userInfoPojoList= selectUserService.selectUsers(page,num,roleId);
        if(num%5==0){
            num=num/5;
        }else {
            num=num/5+1;
        }
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",userInfoPojoList);
//        System.out.println("集合："+userInfoPojoList.get(0).getUser_name());
        System.out.println("maxPage"+num);
        jsonDto.getData().put("maxPage",num);
        return jsonDto;
    }
    @PostMapping("/setState")
    public JsonDto setUserState(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        int setNum = Integer.parseInt(req.getParameter("setNum"));
        boolean res = setStateService.setUserState(userId, setNum);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("/resettingPwd")
    public JsonDto resettingPwd(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        boolean res=resettingPwdService.resettingPwd(userId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("/setUserInfo")
    public JsonDto setUserInfo(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        String userName = req.getParameter("userName");
        String userTel = req.getParameter("userTel");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        boolean res=setUserInfoService.setUserInfo(userId,userName,userTel,roleId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("/insertUser")
    public JsonDto insertUser(HttpServletRequest req){
        String userName = req.getParameter("userName");
        String userTel = req.getParameter("userTel");
        String userEmail = req.getParameter("userEmail");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        boolean res=insertUserService.insertUser(userName,userTel,userEmail,roleId);
        JsonDto jsonDto=new JsonDto();
        if(res){
            jsonDto.getData().put("res",res);
        }
        return jsonDto;
    }
    @PostMapping("/findUser")
    public JsonDto findUser(HttpServletRequest req){
        String userName = req.getParameter("userName");
        String userTel = req.getParameter("userTel");
        int selectRoleId = Integer.parseInt(req.getParameter("selectRoleId"));
        int stateId=Integer.parseInt(req.getParameter("stateId"));
        List<UserManagePojo> list = findUserService.findUser(userName, userTel, selectRoleId, stateId);
        int num=list.size();
        if(num%5==0){
            num=num/5;
        }else {
            num=num/5+1;
        }
        System.out.println("找到的长度："+list.size());
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("sumPage",num);
        jsonDto.getData().put("list",list);
        return jsonDto;
    }
    @PostMapping("/setPwd")
    public JsonDto setPwd(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        String oldPwd = req.getParameter("oldPwd");
        String newPwd = req.getParameter("newPwd");
        String res;
        boolean pwdRes = selectSetPwdService.selectPwd(userId, oldPwd);
        if(pwdRes){
            boolean setPwdRes = setPwdService.setPwd(userId, newPwd);
            if (setPwdRes){
                res="true";
            }else {
                res="error";
            }
        }else {
            res="pwdFalse";
        }
        JsonDto jsonDto=new JsonDto();
        System.out.println("返回："+res);
        jsonDto.getData().put("setRes",res);
        System.out.println("添加结果："+jsonDto.getData().get("setRes"));
        return jsonDto;
    }
}
