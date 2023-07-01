package indi.ye.service.impl;

import indi.ye.mapper.ExamMapper;
import indi.ye.pojo.ExamPojo;
import indi.ye.service.ExamService;
import indi.ye.vo.RegVo;
import indi.ye.vo.ScoreVo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public List<ExamPojo> updateExamTable(int userId,int page){
        int num=(page-1)*10;
        List<ExamPojo> examList=examMapper.updateExamTable(userId,num);
        return examList;
    }

    @Override
    public boolean setExamState(int examId, int state) {
        examMapper.setExamState(examId,state);
        return true;
    }

    @Override
    public List<ExamPojo> selectExam(int userId) {
        List<ExamPojo> list = examMapper.selectExam(userId);
        return list;
    }

    @Override
    public boolean addInformation(String informationTittle, String informationText, int userId, int examId) {
        examMapper.addInformation(informationTittle,informationText,userId,examId);
        return true;
    }

    @Override
    public List<RegVo> selectRegs(int examId,int page) {
        int num=(page-1)*5;
        List<RegVo> list = examMapper.selectRegs(examId,num);
        return list;
    }

    @Override
    public boolean getReg(int regId) {
        examMapper.getReg(regId);
        return true;
    }

    @Override
    public boolean passReg(int regId) {
        examMapper.passReg(regId);
        return true;
    }

    @Override
    public List<ScoreVo> selectScore(int examId, int page) {
        int num=(page-1)*5;
        List<ScoreVo> list = examMapper.selectScore(examId, num);
        return list;
    }

}
