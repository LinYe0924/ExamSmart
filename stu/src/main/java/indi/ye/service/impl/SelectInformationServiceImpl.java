package indi.ye.service.impl;

import indi.ye.mapper.InformationMapper;
import indi.ye.pojo.InformationPojo;
import indi.ye.service.SelectInformationService;
import indi.ye.vo.InformationInfoVo;
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
public class SelectInformationServiceImpl implements SelectInformationService {
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
}
