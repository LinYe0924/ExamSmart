package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.pojo.UserManagePojo;
import indi.ye.service.FindUserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FindUserServiceImpl
 * @Description: 模糊查询的service的实现类
 * @Author: ye
 * @Date: 2023/6/11 21:27
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class FindUserServiceImpl implements FindUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<UserManagePojo> findUser(String userName, String userTel, int selectRoleId, int stateId) {
        List<UserManagePojo> userList;
        userList=userMapper.findUser(userName,userTel,selectRoleId,stateId);
        return userList;
    }
}
