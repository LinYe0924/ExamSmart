package indi.ye.service;

/**
 * @InterfaceName: ProblemService
 * @Description: 考题管理的service
 * @Author: ye
 * @Date: 2023/6/15 17:26
 */

public interface ProblemService {
public boolean addOneChooseProblem(int typeId,int projectId,String problemText,String answer,int userId,String chooseA,String chooseB,String chooseC,String chooseD);
}
