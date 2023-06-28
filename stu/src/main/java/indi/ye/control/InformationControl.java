package indi.ye.control;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.InformationPojo;
import indi.ye.service.SelectInformationService;
import indi.ye.vo.InformationInfoVo;
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
    SelectInformationService selectInformationService;
    @PostMapping("/selectInformation")
    public JsonDto selectInformation(HttpServletRequest req){
        int page = Integer.parseInt(req.getParameter("page"));
        List<InformationPojo> informationList = selectInformationService.selectInformation(page);
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
        InformationInfoVo informationInfoVo = selectInformationService.selectExamName(examId, userId);
        JsonDto jsonDto=new JsonDto();
        jsonDto.getData().put("userName",informationInfoVo.getUser_name());
        jsonDto.getData().put("examName",informationInfoVo.getUser_name());
        return jsonDto;
    }
}
