package indi.ye.control;

import indi.ye.dto.JsonDto;

import indi.ye.pojo.ExamPojo;
import indi.ye.service.ExamInfoService;
import indi.ye.vo.ChooseVo;
import indi.ye.vo.PaperProblemVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ExamControl
 * @Description: 考试的控制层
 * @Author: ye
 * @Date: 2023/6/29 17:13
 */
@Controller
@RestController
public class ExamControl {
    @Resource
    ExamInfoService examInfoService;
    @PostMapping("/selectExamInfo")
    public JsonDto selectExamInfo(HttpServletRequest req){
        int examId = Integer.parseInt(req.getParameter("examId"));
        ExamPojo examPojo = examInfoService.selectExamInfo(examId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("exam",examPojo);
        return jsonDto;
    }
    @PostMapping("/selectPaperProblem")
    public JsonDto selectPaperProblem(HttpServletRequest req){
        int examId = Integer.parseInt(req.getParameter("examId"));
        List<PaperProblemVo> paperProblemList = examInfoService.selectPaperProblem(examId);
        List<ChooseVo> choose=new ArrayList<>();
        List<ChooseVo> chooseList;
        for (int i = 0; i < paperProblemList.size(); i++) {
            chooseList = examInfoService.selectChoose(paperProblemList.get(i).getProblem_id());
            for (int j = 0; j < chooseList.size(); j++) {
                choose.add(chooseList.get(j));
            }
        }
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("problemList",paperProblemList);
        jsonDto.getData().put("chooseList",choose);
        return jsonDto;
    }
    @PostMapping("/getPaper")
    public JsonDto getPaper(HttpServletRequest req){
        int regId = Integer.parseInt(req.getParameter("regId"));
        int examId = Integer.parseInt(req.getParameter("examId"));
        int stuId = Integer.parseInt(req.getParameter("stuId"));
        int score = Integer.parseInt(req.getParameter("score"));
        boolean res = examInfoService.setExamState(regId);
        examInfoService.setScore(examId, stuId, score);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
}
