package indi.ye.service;

import indi.ye.pojo.InformationPojo;
import indi.ye.vo.InformationInfoVo;

import java.util.List;

/**
 * @InterfaceName: SelectInformationService
 * @Description: 查看考试资讯的service
 * @Author: ye
 * @Date: 2023/6/27 18:16
 */
public interface SelectInformationService {
    public List<InformationPojo> selectInformation(int page);
    public InformationInfoVo selectExamName(int examId, int userId);
}
