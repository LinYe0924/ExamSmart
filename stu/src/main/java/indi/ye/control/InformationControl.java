package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.ExamPojo;
import indi.ye.pojo.InformationPojo;
import indi.ye.service.InformationService;
import indi.ye.vo.InformationInfoVo;
import indi.ye.vo.ScoreVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: InformationControl
 * @Description: 考试资讯的控制层
 * @Author: ye
 * @Date: 2023/6/27 16:54
 */
@Controller
@RestController
public class InformationControl {
    @Resource
    InformationService informationService;
    @PostMapping("/selectInformation")
    public JsonDto selectInformation(HttpServletRequest req){
        int page = Integer.parseInt(req.getParameter("page"));
        List<InformationPojo> informationList = informationService.selectInformation(page);
        System.out.println("查到了："+informationList.size());
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",informationList);
        return jsonDto;
    }
    @PostMapping("/selectInformationInfo")
    public JsonDto selectInformationInfo(HttpServletRequest req){
        int examId = Integer.parseInt(req.getParameter("examId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        System.out.println("examId:"+examId);
        System.out.println("userId:"+userId);
        InformationInfoVo informationInfoVo = informationService.selectExamName(examId, userId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("userName",informationInfoVo.getUser_name());
        jsonDto.getData().put("examName",informationInfoVo.getExam_name());
        return jsonDto;
    }
    @PostMapping("/selectRegExam")
    public JsonDto selectRegExam(HttpServletRequest req){
        int stuId = Integer.parseInt(req.getParameter("stuId"));
        List<ExamPojo> examList = informationService.selectRegExam(stuId);
        System.out.println("查到了这么多数据："+examList.size());
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",examList);
        return jsonDto;
    }
    @PostMapping("/regExam")
    public JsonDto regExam(HttpServletRequest req){
        int stuId = Integer.parseInt(req.getParameter("stuId"));
        int examId = Integer.parseInt(req.getParameter("examId"));
        boolean res = informationService.regExam(examId,stuId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("res",res);
        return jsonDto;
    }
    @PostMapping("/selectRegEdExam")
    public JsonDto selectRegEdExam(HttpServletRequest req){
        int stuId = Integer.parseInt(req.getParameter("stuId"));
        List<ExamPojo> examList = informationService.selectRegEdExam(stuId);
        System.out.println("查到了这么多数据："+examList.size());
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",examList);
        return jsonDto;
    }
    @PostMapping("selectScore")
    public JsonDto selectScore(HttpServletRequest req){
        int stuId = Integer.parseInt(req.getParameter("stuId"));
        int page = Integer.parseInt(req.getParameter("page"));
        List<ScoreVo> scoreVos = informationService.selectScore(stuId, page);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("list",scoreVos);
        return jsonDto;
    }
}
