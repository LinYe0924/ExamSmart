package indi.ye.mapper;

import indi.ye.pojo.ProblemPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ProblemMapper
 * @Description: 考题管理的mapper
 * @Author: ye
 * @Date: 2023/6/15 18:45
 */
@Component
public interface ProblemMapper {
    public void addProblem(@Param("problemPojo") ProblemPojo problemPojo);
    public void addChoose(@Param("letter") String choose_letter,@Param("text") String choose_text,@Param("problem_id")int problem_id);
    public List selectProblem(@Param("page") int page);
    public Integer selectProblemSize();

}
