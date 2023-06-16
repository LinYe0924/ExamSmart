package indi.ye.mapper;

import org.springframework.stereotype.Component;

/**
 * @ClassName: ProblemMapper
 * @Description: 考题管理的mapper
 * @Author: ye
 * @Date: 2023/6/15 18:45
 */
@Component
public interface ProblemMapper {
    public void addOneChooseProblem(int typeId,String problemText,String answer);
}
