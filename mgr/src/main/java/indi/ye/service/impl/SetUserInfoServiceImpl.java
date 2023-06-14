package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.service.SetUserInfoService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: SetUserInfoServiceImpl
 * @Description: 修改用户信息的service的实现类
 * @Author: ye
 * @Date: 2023/6/10 23:43
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class SetUserInfoServiceImpl implements SetUserInfoService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean setUserInfo(int userId, String userName, String userTel, int roleId) {
        userMapper.setUserInfo(userId,userName,userTel,roleId);
        return true;
    }
}
