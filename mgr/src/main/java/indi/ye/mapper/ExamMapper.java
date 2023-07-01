package indi.ye.mapper;

import indi.ye.pojo.ExamPojo;
import indi.ye.vo.RegVo;
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
public interface ExamMapper {
    public void addExam(@Param("examNameValue") String examNameValue,@Param("paperId") int paperId,@Param("userId") int userId,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("endRegDate") Date endRegDate);
    public List updateExamTable(@Param("userId") int userId, @Param("page") int page);
    public void setExamState(@Param("examId") int examId,@Param("state") int state);
    public List selectExam(@Param("userId") int userId);
    public void addInformation(@Param("tittle") String informationTittle,@Param("text") String informationText,@Param("userId") int userId,@Param("examId") int examId);
    public List selectRegs(@Param("examId") int examId,@Param("page") int page);
    boolean getReg(@Param("regId") int regId);
    boolean passReg(@Param("regId") int regId);
    public List selectScore(@Param("examId") int examId,@Param("page") int page);
}
