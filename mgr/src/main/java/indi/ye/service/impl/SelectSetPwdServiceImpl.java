package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.pojo.UserPojo;
import indi.ye.service.SelectSetPwdService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: SelectSetPwdServiceImpl
 * @Description: 这是修改密码时验证原密码是否正确的service的实现类
 * @Author: ye
 * @Date: 2023/6/12 14:44
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class SelectSetPwdServiceImpl implements SelectSetPwdService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean selectPwd(int userId, String oldPwd) {
        System.out.println("更改密码的用户编号："+userId);
        UserPojo userPojo = userMapper.selectPwd(userId);
        if(oldPwd.equals(userPojo.getUser_pwd())){
            return true;
        }
        return false;
    }
}
