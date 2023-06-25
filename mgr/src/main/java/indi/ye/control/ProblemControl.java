package indi.ye.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import indi.ye.dto.JsonDto;
import indi.ye.pojo.ChoosePojo;
import indi.ye.pojo.PaperPojo;
import indi.ye.pojo.ProblemPojo;
import indi.ye.service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
    public JsonDto addProblem(HttpServletRequest req) {
        int typeId= Integer.parseInt(req.getParameter("problemTypeId"));
        String problemText = req.getParameter("problemText");
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        JsonDto jsonDto=new JsonDto();
        if(typeId==1){
            String answer = req.getParameter("answer");
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
            //创建一个ObjectMapper对象
            ObjectMapper mapper = new ObjectMapper();
            String answer="";
            int charFlag = 63;
            char letter = 0;
            String chooseString = req.getParameter("choose");
            ChoosePojo[] chooseList;
            try {
                chooseList = mapper.readValue(chooseString, ChoosePojo[].class);
            } catch (IOException e) {
                System.out.println("解读json出错");
                throw new RuntimeException(e);
            }
            for (int i = 0; i < chooseList.length; i++) {
                charFlag++;
                if(chooseList[i].getYeNoAnswer().equals("是")){
                    letter = (char) charFlag;
                    if(answer.equals("")){
                        answer+=letter;
                    }else {
                        answer+=",";
                        answer+=letter;
                    }
                }
            }
            System.out.println("收到的多选题答案："+answer);
            boolean addMoreChooseProblemRes = problemService.addMoreChooseProblem(typeId, projectId, problemText, answer, userId, chooseList);
            jsonDto.getData().put("res",addMoreChooseProblemRes);
        }else{
            String answer = req.getParameter("answer");
            boolean yesOrNoAndBlankRes = problemService.addYesOrNoAndBlank(typeId, projectId, problemText, answer, userId);
            jsonDto.getData().put("res",yesOrNoAndBlankRes);
        }

        return jsonDto;
    }
    @PostMapping("updateProblemTable")
    public JsonDto updateProblemTable(HttpServletRequest req){
       int page= Integer.parseInt(req.getParameter("page"));
        int size = problemService.selectProblemSize();
        List<ProblemPojo> problems = problemService.selectProblem(page);
        System.out.println("查到了这么多数据："+problems.size());
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("maxPage",size);
        jsonDto.getData().put("list",problems);
        return jsonDto;
    }
    @PostMapping("delProblem")
    public JsonDto delProblem(HttpServletRequest req){
        int problemId= Integer.parseInt(req.getParameter("problemId"));
        boolean res = problemService.delProblem(problemId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("reProblem")
    public JsonDto reProblem(HttpServletRequest req){
        int problemId= Integer.parseInt(req.getParameter("problemId"));
        boolean res = problemService.reProblem(problemId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("selectChoose")
    public JsonDto selectChoose(HttpServletRequest req){
        int problemId= Integer.parseInt(req.getParameter("problemId"));
        List<ChoosePojo> chooseList= problemService.selectChoose(problemId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",chooseList);
        return jsonDto;
    }
    @PostMapping("addPaper")
    public JsonDto addPaper(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        String paperName = req.getParameter("paperName");
        System.out.println("userId:"+userId);
        System.out.println("projectId:"+projectId);
        System.out.println("paperName:"+paperName);
        boolean paperRes = problemService.addPaper(paperName, projectId, userId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",paperRes);
        return jsonDto;
    }
    @PostMapping("selectPaper")
    public JsonDto selectPaper(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        List<PaperPojo> paperList = problemService.selectPaper(userId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",paperList);
        return jsonDto;
    }
    @PostMapping("selectBankProblem")
    public JsonDto selectBankProblem(HttpServletRequest req){
        int paperId = Integer.parseInt(req.getParameter("paperId"));
        int page = Integer.parseInt(req.getParameter("currentPage"));
//        String paperId = req.getParameter("paperId");
//        String page = req.getParameter("currentPage");
        System.out.println("paperId:"+paperId+"page:"+page);
        List<ProblemPojo> problemList = problemService.selectBankProblem(paperId,page);
        System.out.println("查到："+problemList.size()+"条数据");
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",problemList);
        return jsonDto;
    }
    @PostMapping("selectPaperProblem")
    public JsonDto selectPaperProblem(HttpServletRequest req){
        int paperId = Integer.parseInt(req.getParameter("paperId"));
        int page = Integer.parseInt(req.getParameter("page"));
//        String paperId = req.getParameter("paperId");
//        String page = req.getParameter("currentPage");
        List<ProblemPojo> problemList = problemService.selectPaperProblem(paperId,page);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",problemList);
        return jsonDto;
    }
    @PostMapping("keepPaper")
    public JsonDto keepPaper(HttpServletRequest req){
        int paperId = Integer.parseInt(req.getParameter("paperId"));
        String problemIdList = req.getParameter("problemIdList");
        String scoreList = req.getParameter("scoreList");
        int sumScore = Integer.parseInt(req.getParameter("sumScore"));
        System.out.println("paperId："+paperId);
        System.out.println("problemIdList："+problemIdList);
        boolean res = problemService.keepPaper(paperId, problemIdList, scoreList, sumScore);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
}
