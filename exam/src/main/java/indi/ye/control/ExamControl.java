package indi.ye.control;

import indi.ye.dto.JsonDto;

import indi.ye.pojo.ExamPojo;
import indi.ye.service.ExamInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
}
