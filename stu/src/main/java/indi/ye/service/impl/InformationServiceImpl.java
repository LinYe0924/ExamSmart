package indi.ye.service.impl;

import indi.ye.mapper.InformationMapper;
import indi.ye.pojo.ExamPojo;
import indi.ye.pojo.InformationPojo;
import indi.ye.service.InformationService;
import indi.ye.vo.InformationInfoVo;
import indi.ye.vo.ScoreVo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SelectInformationServiceImpl
 * @Description: SelectInformationService的实现类
 * @Author: ye
 * @Date: 2023/6/27 18:22
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class InformationServiceImpl implements InformationService {
    @Resource
    InformationMapper informationMapper;
    @Override
    public List<InformationPojo> selectInformation(int page) {
        int num=(page-1)*12;
        List<InformationPojo> informationList = informationMapper.selectInformation(num);
        return informationList;
    }

    @Override
    public InformationInfoVo selectExamName(int examId, int userId) {
        InformationInfoVo selectUserName = informationMapper.selectUserName(userId);
        if(examId!=0) {
            InformationInfoVo selectExamName = informationMapper.selectExamName(examId);
            selectUserName.setExam_name(selectExamName.getExam_name());
        }else {
            selectUserName.setExam_name("无");
        }
        return selectUserName;
    }

    @Override
    public List<ExamPojo> selectRegExam(int stuId) {
        List<ExamPojo> list = informationMapper.selectRegExam();
        int res=0;
        for (int i = 0; i < list.size(); i++) {
            try {
                res=informationMapper.selectRegState(stuId,list.get(i).getExam_id());
            } catch (Exception e) {
                System.out.println("未报名该考试！");
                res=0;
            }
            if(res!=0){
                list.get(i).setRegState(1);
            }else {
                list.get(i).setRegState(0);
            }
        }
        return list;
    }

    @Override
    public boolean regExam(int examId, int stuId) {
        informationMapper.regExam(examId,stuId);
        return true;
    }

    @Override
    public List<ExamPojo> selectRegEdExam(int stuId) {
        List<ExamPojo> list = informationMapper.selectRegEdExam(stuId);
        return list;
    }

    @Override
    public List<ScoreVo> selectScore(int stuId, int page) {
        int num=(page-1)*5;
        List<ScoreVo> list = informationMapper.selectScore(stuId, num);
        return list;
    }
}
