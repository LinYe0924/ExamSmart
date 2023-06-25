package indi.ye.service;

import java.util.Date;

/**
 * @InterfaceName: ExamService
 * @Description: 考试的service
 * @Author: ye
 * @Date: 2023/6/25 16:15
 */
public interface ExamService {
    public boolean addExam(String examNameValue, int paperId,int userId, Date startDate,Date endDate,Date endRegDate);
}
