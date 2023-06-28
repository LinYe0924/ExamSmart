package indi.ye.mapper;

import indi.ye.vo.InformationInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName: ExamMapper
 * @Description: 考试的mapper
 * @Author: ye
 * @Date: 2023/6/25 16:22
 */
@Component
public interface InformationMapper {
    public List selectInformation(@Param("page") int page);
    public InformationInfoVo selectExamName(@Param("id") int id);
    public InformationInfoVo selectUserName(@Param("id") int id);
    }
