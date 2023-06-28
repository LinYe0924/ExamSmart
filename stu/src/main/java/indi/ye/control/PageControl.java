package indi.ye.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: PageControl
 * @Description: 用户的contorl
 * @Author: ye
 * @Date: 2023/6/5 15:35
 */
@Controller
@RestController
public class PageControl {
    @GetMapping("/toPortal")
    public ModelAndView toManager(){
        return new ModelAndView("portal");
    }
    @GetMapping("/toPage")
    public ModelAndView toPage(String page){

        return new ModelAndView(page);
    }

}
