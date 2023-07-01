package indi.ye.service.impl;

import indi.ye.dto.JsonDto;
import indi.ye.mapper.ExamInfoMapper;
import indi.ye.pojo.ExamPojo;
import indi.ye.service.ExamInfoService;
import indi.ye.vo.ChooseVo;
import indi.ye.vo.PaperProblemVo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ExamServiceImpl
 * @Description: ExamService的实现类
 * @Author: ye
 * @Date: 2023/6/29 17:21
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class ExamInfoServiceImpl implements ExamInfoService {
    @Resource
    ExamInfoMapper examInfoMapper;
    @Override
    public ExamPojo selectExamInfo(int examId) {
        ExamPojo exam = examInfoMapper.selectExamInfo(examId);
        System.out.println("考试科目："+exam.getProject_name());
        return exam;
    }

    @Override
    public List<PaperProblemVo> selectPaperProblem(int examId) {
        List<PaperProblemVo> list = examInfoMapper.selectPaperProblem(examId);
        return list;
    }

    @Override
    public List<ChooseVo> selectChoose(int problem) {
        List<ChooseVo> list = examInfoMapper.selectChoose(problem);
        return list;
    }

    @Override
    public boolean setExamState(int regId) {
        examInfoMapper.setExamState(regId);
        return true;
    }

    @Override
    public boolean setScore(int examId, int stuId, int score) {
        examInfoMapper.setScore(examId,stuId,score);
        return true;
    }
}
