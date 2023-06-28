package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.until.CodePicture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        int res=0;
        if(codeStr.equals(code)){


        }else {
            res=3;
        }
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
}
