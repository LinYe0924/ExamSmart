package indi.ye.mapper;

import indi.ye.pojo.StuPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @InterfaceName: StuMapper
 * @Description: 学生的mapper
 * @Author: ye
 * @Date: 2023/6/28 14:20
 */
@Component
public interface StuMapper {
     void regStu(@Param("stu") StuPojo stu);
     Integer login(@Param("uTel") String uTel ,@Param("uPwd") String uPwd);
     StuPojo selectStuInfo(@Param("stuId") int stuId);
}
