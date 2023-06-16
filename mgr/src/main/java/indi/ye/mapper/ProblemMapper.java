package indi.ye.mapper;

import indi.ye.pojo.ProblemPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ProblemMapper
 * @Description: 考题管理的mapper
 * @Author: ye
 * @Date: 2023/6/15 18:45
 */
@Component
public interface ProblemMapper {
    public void addOneChooseProblem(@Param("problemPojo") ProblemPojo problemPojo);
    public void addOneChoose(@Param("letter") String choose_letter,@Param("text") String choose_text,@Param("problem_id")int problem_id);
}
