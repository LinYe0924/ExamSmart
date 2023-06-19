package indi.ye.service;

import indi.ye.pojo.ChoosePojo;
import indi.ye.pojo.ProblemPojo;

import java.util.List;

/**
 * @InterfaceName: ProblemService
 * @Description: 考题管理的service
 * @Author: ye
 * @Date: 2023/6/15 17:26
 */

public interface ProblemService {
public boolean addOneChooseProblem(int typeId,int projectId,String problemText,String answer,int userId,String chooseA,String chooseB,String chooseC,String chooseD);
public boolean addMoreChooseProblem(int typeId, int projectId, String problemText, String answer,int userId, ChoosePojo[] chooseList);
public boolean addYesOrNoAndBlank(int typeId, int projectId, String problemText, String answer,int userId);
public int selectProblemSize();
public List<ProblemPojo> selectProblem(int page);
}
