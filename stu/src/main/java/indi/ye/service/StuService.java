package indi.ye.service;

import indi.ye.pojo.StuPojo;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName: StuService
 * @Description: 学生的service层
 * @Author: ye
 * @Date: 2023/6/28 14:17
 */
public interface StuService {
    public int regStu(StuPojo stu);
    public int login(String uTel ,String uPwd);
    StuPojo selectStuInfo(int stuId);
}
