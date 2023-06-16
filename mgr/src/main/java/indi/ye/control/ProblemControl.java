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
        int typeId= Integer.parseInt(req.getParameter("problemTypeId"));
        String problemText = req.getParameter("problemText");
        String answer = req.getParameter("answer");
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        JsonDto jsonDto=new JsonDto();
        if(typeId==1){
            int ans= Integer.parseInt(answer);
            int charFlag = 64;
            char charIndex = 0;
            for(int i=1;i<5;i++){
                charFlag++;
                if(ans==i){
                    charIndex = (char) charFlag;
                }
            }
            answer= String.valueOf(charIndex);
            String chooseA = req.getParameter("chooseA");
            String chooseB = req.getParameter("chooseB");
            String chooseC = req.getParameter("chooseC");
            String chooseD = req.getParameter("chooseD");
            boolean addOneChooseProblemRes = problemService.addOneChooseProblem(typeId, projectId, problemText, answer, userId,chooseA, chooseB, chooseC, chooseD);
            jsonDto.getData().put("res",addOneChooseProblemRes);

        }else if(typeId==2){

        }else if (typeId==4){

        }

        return jsonDto;
    }
}
