package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.service.ResettingPwdService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: ResettingPwdServiceImpl
 * @Description: 重置密码的service的实现类
 * @Author: ye
 * @Date: 2023/6/10 17:36
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class ResettingPwdServiceImpl implements ResettingPwdService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean resettingPwd(int userId) {
        userMapper.resettingPwd(userId);
        return true;
    }
}
