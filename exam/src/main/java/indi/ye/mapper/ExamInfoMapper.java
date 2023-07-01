package indi.ye.mapper;

import indi.ye.pojo.ExamPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @InterfaceName: ExamInfoMapper
 * @Description: 考试的mapper
 * @Author: ye
 * @Date: 2023/6/29 18:18
 */
@Component
public interface ExamInfoMapper {
    ExamPojo selectExamInfo(@Param("examId") int examId);
    List selectPaperProblem(@Param("examId") int examId);
    List selectChoose(@Param("problemId") int problemId);
    void setExamState(@Param("regId") int regId);
    void setScore(@Param("examId") int examId,@Param("stuId") int stuId,@Param("score") int score);
}
