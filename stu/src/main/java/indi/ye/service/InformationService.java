package indi.ye.service;

import indi.ye.pojo.ExamPojo;
import indi.ye.pojo.InformationPojo;
import indi.ye.vo.InformationInfoVo;

import java.util.List;

/**
 * @InterfaceName: SelectInformationService
 * @Description: 查看考试资讯的service
 * @Author: ye
 * @Date: 2023/6/27 18:16
 */
public interface InformationService {
    List<InformationPojo> selectInformation(int page);
    InformationInfoVo selectExamName(int examId, int userId);
    List<ExamPojo> selectRegExam(int stuId);
    boolean regExam(int examId, int stuId);
    List<ExamPojo> selectRegEdExam(int stuId);
}
