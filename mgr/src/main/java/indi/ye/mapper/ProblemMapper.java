package indi.ye.mapper;

import indi.ye.pojo.ChoosePojo;
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
    public void delProblem(@Param("problem_id") int problemId);
    public void reProblem(@Param("problem_id") int problemId);
    public List selectChoose(@Param("problem_id") int problemId);
    public void addPaper(@Param("paperName") String paperName,@Param("projectId") int projectId,@Param("userId") int userId);
    public List selectPaper(@Param("userId") int userId);
    public List<ProblemPojo> selectBankProblem(@Param("paperId") int paperId,@Param("page") int page);
    public List<ProblemPojo> selectPaperProblem(@Param("paperId") int paperId,@Param("page") int page);
    public void addPaperProblem(@Param("paperId") int paperId, @Param("problemId") int problemId, @Param("score") int score);
    public void setPaperScore(@Param("paperId") int paperId,@Param("sumScore") int sumScore);
}
