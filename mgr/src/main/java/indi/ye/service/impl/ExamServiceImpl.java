package indi.ye.service.impl;

import indi.ye.mapper.ExamMapper;
import indi.ye.service.ExamService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName: ExamServiceImpl
 * @Description: 考试service的实现类
 * @Author: ye
 * @Date: 2023/6/25 16:17
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class ExamServiceImpl implements ExamService {
    @Resource
    ExamMapper examMapper;
    @Override
    public boolean addExam(String examNameValue, int paperId,int userId, Date startDate, Date endDate, Date endRegDate) {
        examMapper.addExam(examNameValue,paperId,userId,startDate,endDate,endRegDate);
        return true;
    }
}
