package indi.ye.service;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.ExamPojo;

/**
 * @InterfaceName: ExamService
 * @Description: 考试的service
 * @Author: ye
 * @Date: 2023/6/29 17:20
 */
public interface ExamInfoService {
    ExamPojo selectExamInfo(int examId);
}
