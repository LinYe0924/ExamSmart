package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.service.SetPwdService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: SetPwdServiceImpl
 * @Description: 修改密码的service的实现类
 * @Author: ye
 * @Date: 2023/6/12 15:15
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class SetPwdServiceImpl implements SetPwdService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean setPwd(int userId, String newPwd) {
        userMapper.setPwd(userId,newPwd);
        return true;
    }
}
