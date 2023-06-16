package indi.ye.service.impl;

import indi.ye.mapper.ProblemMapper;
import indi.ye.pojo.ProblemPojo;
import indi.ye.service.ProblemService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: ProblemServiceImpl
 * @Description: 考题管理的service的实现类
 * @Author: ye
 * @Date: 2023/6/15 17:36
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class ProblemServiceImpl implements ProblemService {
    @Resource
    ProblemMapper problemMapper;
    @Override
    public boolean addOneChooseProblem(int typeId,int projectId,String problemText,String answer,int userId,String chooseA,String chooseB,String chooseC,String chooseD) {
        ProblemPojo problemPojo=new ProblemPojo(problemText,answer,typeId,projectId,userId);
        problemMapper.addOneChooseProblem(problemPojo);
        int problemId = problemPojo.getProblem_id();

        problemMapper.addOneChoose("A",chooseA,problemId);
        problemMapper.addOneChoose("B",chooseB,problemId);
        problemMapper.addOneChoose("C",chooseC,problemId);
        problemMapper.addOneChoose("D",chooseD,problemId);
        return true;
    }
}
