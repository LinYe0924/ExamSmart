package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.ExamPojo;
import indi.ye.service.ExamService;
import indi.ye.until.TimeUntil;
import indi.ye.vo.RegVo;
import indi.ye.vo.ScoreVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ExamControl
 * @Description: 考试的控制层
 * @Author: ye
 * @Date: 2023/6/25 15:41
 */
@Controller
@RestController
public class ExamControl {
    @Resource
    ExamService examService;
    @PostMapping("addExam")
    public JsonDto addExam(HttpServletRequest req){
        String examNameValue = req.getParameter("examNameValue");
        int paperId = Integer.parseInt(req.getParameter("paperId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        String startTime=req.getParameter("startTime");
        String endTime=req.getParameter("endTime");
        String endRegTime=req.getParameter("endRegTime");
        TimeUntil timeUntil=new TimeUntil();
        Date startDate = timeUntil.stringToDate(startTime);
        Date endDate = timeUntil.stringToDate(endTime);
        Date endRegDate = timeUntil.stringToDate(endRegTime);
        boolean res = examService.addExam(examNameValue, paperId, userId, startDate, endDate, endRegDate);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("updateExamTable")
    public JsonDto updateExamTable(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        int page = Integer.parseInt(req.getParameter("page"));
        System.out.println("拿到的userId："+userId);
        System.out.println("拿到的page："+page);
        List<ExamPojo> examList = examService.updateExamTable(userId, page);
        System.out.println("拿到了这么多数据："+examList.size()+"！！！");
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",examList);
        return jsonDto;
    }
    @PostMapping("delExam")
    public JsonDto delExam(HttpServletRequest req){
        int examId = Integer.parseInt(req.getParameter("examId"));
        int state = Integer.parseInt(req.getParameter("state"));
        boolean res = examService.setExamState(examId, state);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("selectExam")
    public JsonDto selectExam(HttpServletRequest req){
        int userId = Integer.parseInt(req.getParameter("userId"));
        List<ExamPojo> examList = examService.selectExam(userId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",examList);
        return jsonDto;
    }
    @PostMapping("addInformation")
    public JsonDto addInformation(HttpServletRequest req){
        String informationTittle = req.getParameter("informationTittle");
        String informationText = req.getParameter("informationText");
        int userId = Integer.parseInt(req.getParameter("userId"));
        int examId = Integer.parseInt(req.getParameter("examId"));
        boolean res = examService.addInformation(informationTittle, informationText, userId, examId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("selectRegs")
    public JsonDto selectRegs(HttpServletRequest req){
        int examId = Integer.parseInt(req.getParameter("examId"));
        int page = Integer.parseInt(req.getParameter("page"));
        List<RegVo> regList = examService.selectRegs(examId,page);
        System.out.println("考试id："+examId);
        System.out.println("查到了："+regList.size());
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",regList);
        return jsonDto;
    }
    @PostMapping("getReg")
    public JsonDto getReg(HttpServletRequest req){
        int regId = Integer.parseInt(req.getParameter("regId"));
        boolean res = examService.getReg(regId);
        System.out.println("通过！");
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("passReg")
    public JsonDto passReg(HttpServletRequest req){
        int regId = Integer.parseInt(req.getParameter("regId"));
        boolean res = examService.passReg(regId);
        System.out.println("驳回！");
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("selectScore")
    public JsonDto selectScore(HttpServletRequest req){
        int examId = Integer.parseInt(req.getParameter("examId"));
        int page = Integer.parseInt(req.getParameter("page"));
        List<ScoreVo> scoreVos = examService.selectScore(examId, page);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",scoreVos);
        return jsonDto;
    }
}
