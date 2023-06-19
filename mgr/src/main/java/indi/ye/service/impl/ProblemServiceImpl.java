package indi.ye.service.impl;

import indi.ye.mapper.ProblemMapper;
import indi.ye.pojo.ChoosePojo;
import indi.ye.pojo.ProblemPojo;
import indi.ye.pojo.UserManagePojo;
import indi.ye.service.ProblemService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
        problemMapper.addProblem(problemPojo);
        int problemId = problemPojo.getProblem_id();

        problemMapper.addChoose("A",chooseA,problemId);
        problemMapper.addChoose("B",chooseB,problemId);
        problemMapper.addChoose("C",chooseC,problemId);
        problemMapper.addChoose("D",chooseD,problemId);
        return true;
    }

    @Override
    public boolean addMoreChooseProblem(int typeId, int projectId, String problemText, String answer,int userId, ChoosePojo[] chooseList) {
        ProblemPojo problemPojo=new ProblemPojo(problemText,answer,typeId,projectId,userId);
        problemMapper.addProblem(problemPojo);
        int problemId = problemPojo.getProblem_id();
        int charFlag = 63;
        char letter = 0;
        for (int i = 0; i < chooseList.length; i++) {
            charFlag++;
            if(i>0) {
                letter = (char) charFlag;
                problemMapper.addChoose(String.valueOf(letter), chooseList[i].getChooseText(), problemId);
            }
        }
        return true;
    }

    @Override
    public boolean addYesOrNoAndBlank(int typeId, int projectId, String problemText, String answer, int userId) {
        ProblemPojo problemPojo=new ProblemPojo(problemText,answer,typeId,projectId,userId);
        problemMapper.addProblem(problemPojo);
        int problemId = problemPojo.getProblem_id();
        if(problemId>0) {
            return true;
        }else {
            return false;
        }
    }
    @Override
    public int selectProblemSize() {
        int num = problemMapper.selectProblemSize();
        if(num%5==0) {
            num = num / 5;
        }else {
            num = (num / 5)+1;
        }
        return num;
    }
    @Override
    public List<ProblemPojo> selectProblem(int page) {
        int num=(page-1)*5;
        List<ProblemPojo> list = problemMapper.selectProblem(num);
        return list;
    }
}
