package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.pojo.UserPojo;
import indi.ye.service.LoginService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: LoginServiceImpl
 * @Description: 登录service接口的实现类
 * @Author: ye
 * @Date: 2023/5/26 15:17
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class LoginServiceImpl implements LoginService {
    @Resource
    UserMapper userMapper;

    @Override
    public String login(String uTel, String uPwd) {
        UserPojo userPojo = userMapper.login(uTel, uPwd);
        if (userPojo == null) {
            return "error";
        } else {
            String res = String.valueOf(userPojo.getUser_id()) + "," + String.valueOf(userPojo.getRole_id())+","+userPojo.getUser_name()+","+userPojo.getUser_state();
            return res;
        }

    }
}
