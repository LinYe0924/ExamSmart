package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: problemControl
 * @Description: 这是考题的control层
 * @Author: ye
 * @Date: 2023/6/15 15:50
 */
@Controller
@RestController
public class ProblemControl {
    @Resource
    ProblemService problemService;
    @PostMapping("/addProblem")
    public JsonDto addProblem(HttpServletRequest req){
        int typeId= Integer.parseInt(req.getParameter("typeId"));
        String problemText = req.getParameter("problemText");
        String answer = req.getParameter("answer");
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        if(typeId==1){
            String chooseA = req.getParameter("chooseA");
            String chooseB = req.getParameter("chooseB");
            String chooseC = req.getParameter("chooseC");
            String chooseD = req.getParameter("chooseD");
            boolean addOneChooseProblemRes = problemService.addOneChooseProblem(typeId, projectId, problemText, answer, chooseA, chooseB, chooseC, chooseD);
            if(addOneChooseProblemRes){

            }
        }else if(typeId==2){

        }else if (typeId==4){

        }
        JsonDto jsonDto=new JsonDto();
        return jsonDto;
    }
}
