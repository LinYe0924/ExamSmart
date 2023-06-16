package indi.ye.service.impl;

import indi.ye.service.ProblemService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: ProblemServiceImpl
 * @Description: 考题管理的service的实现类
 * @Author: ye
 * @Date: 2023/6/15 17:36
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class ProblemServiceImpl implements ProblemService {
    @Override
    public boolean addOneChooseProblem(int typeId,int projectId,String problemText,String answer,String chooseA,String chooseB,String chooseC,String chooseD) {

        return false;
    }
}
