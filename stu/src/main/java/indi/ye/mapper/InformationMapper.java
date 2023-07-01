package indi.ye.mapper;

import indi.ye.pojo.ExamPojo;
import indi.ye.vo.InformationInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName: ExamMapper
 * @Description: 考试的mapper
 * @Author: ye
 * @Date: 2023/6/25 16:22
 */
@Component
public interface InformationMapper {
    List selectInformation(@Param("page") int page);
    InformationInfoVo selectExamName(@Param("id") int id);
    InformationInfoVo selectUserName(@Param("id") int id);
    List selectRegExam();
    Integer selectRegState(@Param("stuId") int stuId,@Param("examId") int examId);
    void regExam(@Param("examId") int examId,@Param("stuId") int stuId);
    List selectRegEdExam(@Param("stuId") int stuId);
    public List selectScore(@Param("stuId") int stuId,@Param("page") int page);
    }
