package indi.ye.service;

import indi.ye.pojo.ExamPojo;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName: ExamService
 * @Description: 考试的service
 * @Author: ye
 * @Date: 2023/6/25 16:15
 */
public interface ExamService {
    public boolean addExam(String examNameValue, int paperId,int userId, Date startDate,Date endDate,Date endRegDate);
    public List<ExamPojo> updateExamTable(int userId, int page);
    public boolean setExamState(int examId, int state);
    public List<ExamPojo> selectExam(int userId);
    public boolean addInformation(String informationTittle,String informationText,int userId,int examId);
}
