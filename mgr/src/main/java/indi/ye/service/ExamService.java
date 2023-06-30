package indi.ye.service;

import indi.ye.pojo.ExamPojo;
import indi.ye.vo.RegVo;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName: ExamService
 * @Description: 考试的service
 * @Author: ye
 * @Date: 2023/6/25 16:15
 */
public interface ExamService {
boolean addExam(String examNameValue, int paperId,int userId, Date startDate,Date endDate,Date endRegDate);
     List<ExamPojo> updateExamTable(int userId, int page);
     boolean setExamState(int examId, int state);
     List<ExamPojo> selectExam(int userId);
     boolean addInformation(String informationTittle,String informationText,int userId,int examId);
     List<RegVo> selectRegs(int examId,int page);
     boolean getReg(int regId );
     boolean passReg(int regId );
}
