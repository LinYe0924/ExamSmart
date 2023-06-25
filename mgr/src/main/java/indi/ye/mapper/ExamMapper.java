package indi.ye.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @InterfaceName: ExamMapper
 * @Description: 考试的mapper
 * @Author: ye
 * @Date: 2023/6/25 16:22
 */
@Component
public interface ExamMapper {
    public void addExam(@Param("examNameValue") String examNameValue,@Param("paperId") int paperId,@Param("userId") int userId,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("endRegDate") Date endRegDate);
}
