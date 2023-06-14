package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.service.InsertUserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: InsertUserServiceImpl
 * @Description: 新增用户的service的实现类
 * @Author: ye
 * @Date: 2023/6/11 18:25
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class InsertUserServiceImpl implements InsertUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean insertUser(String userName, String userTel, String userEmail, int roleId) {
        userMapper.insertUser(userName,userTel,userEmail,roleId);
        return true;
    }
}
