package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.UserPojo;
import indi.ye.service.LoginService;
import indi.ye.until.CodePicture;
import indi.ye.until.UserUntil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName: PageControl
 * @Description: 用户的contorl
 * @Author: ye
 * @Date: 2023/6/5 15:35
 */
@Controller
@RestController
public class PageControl {

    @GetMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }

    @GetMapping("/toManager")
    public ModelAndView toManager(String page){
        return new ModelAndView(page);
    }
    @GetMapping("/toPage")
    public ModelAndView toPage(String page){

        return new ModelAndView(page);
    }

}
