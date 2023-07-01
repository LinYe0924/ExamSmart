package indi.ye.service;

import indi.ye.dto.JsonDto;
import indi.ye.pojo.ExamPojo;
import indi.ye.vo.ChooseVo;
import indi.ye.vo.PaperProblemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName: ExamService
 * @Description: 考试的service
 * @Author: ye
 * @Date: 2023/6/29 17:20
 */
public interface ExamInfoService {
    ExamPojo selectExamInfo(int examId);
    List<PaperProblemVo> selectPaperProblem(int examId);
    List<ChooseVo> selectChoose(int problem);
    boolean setExamState(int regId);
    boolean setScore(int examId,int stuId,int score);
}
