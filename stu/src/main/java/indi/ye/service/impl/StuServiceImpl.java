package indi.ye.service.impl;

import indi.ye.mapper.StuMapper;
import indi.ye.pojo.StuPojo;
import indi.ye.service.StuService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: StuServiceImpl
 * @Description: StuService的实现类
 * @Author: ye
 * @Date: 2023/6/28 14:18
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class StuServiceImpl implements StuService {
    @Resource
    StuMapper stuMapper;
    @Override
    public int regStu(StuPojo stu) {
        stuMapper.regStu(stu);
        return stu.getStu_id();
    }

    @Override
    public int login(String uTel, String uPwd) {
        int res=0;
        try {
            res = stuMapper.login(uTel, uPwd);
        } catch (Exception e) {
            System.out.println("账号或密码错误");
            res=0;
        }
        return res;
    }
}
