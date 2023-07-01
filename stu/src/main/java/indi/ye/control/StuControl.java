package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.StuPojo;
import indi.ye.service.StuService;
import indi.ye.until.CodePicture;
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

/**
 * @ClassName: StuControl
 * @Description: 学生的控制层
 * @Author: ye
 * @Date: 2023/6/28 11:02
 */
@Controller
@RestController
public class StuControl {
    @Resource
    StuService stuService;
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
    @GetMapping("/stuReg")
    public JsonDto stuReg(HttpServletRequest req){
        String phone = req.getParameter("phone");
        String cardId = req.getParameter("ID");
        String name = req.getParameter("Name");
        String eMail = req.getParameter("Email");
        String pwd = req.getParameter("pwd");
        String code = req.getParameter("code");
        String codeStr = (String) req.getSession().getAttribute("codeStr");
        StuPojo stu=new StuPojo(name,phone,cardId,eMail,pwd);
        int res=0;
        System.out.println("需要的验证码："+codeStr);
        System.out.println("我给的验证码："+code);
        if(codeStr.equalsIgnoreCase(code)){
            res= stuService.regStu(stu);
            if(res>0){
            }else {
                res=0;
            }
        }else {
            res=-1;
        }
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @GetMapping("/login")
    public JsonDto stuLogin(HttpServletRequest req){
        String tel = req.getParameter("uTel");
        String pwd = req.getParameter("uPwd");
        String code = req.getParameter("uCode");
        String codeStr = (String) req.getSession().getAttribute("codeStr");
        int res=0;
        System.out.println("tel:"+tel);
        System.out.println("pwd:"+pwd);
        if(codeStr.equalsIgnoreCase(code)){
            res= stuService.login(tel, pwd);
        }else {
            res=-1;
        }
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("/selectStuInfo")
    public JsonDto selectStuInfo(HttpServletRequest req){
        int stuId = Integer.parseInt(req.getParameter("stuId"));
        StuPojo stuPojo = stuService.selectStuInfo(stuId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("stu",stuPojo);
        return jsonDto;
    }
}
