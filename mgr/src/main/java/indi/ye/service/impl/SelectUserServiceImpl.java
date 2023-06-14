package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;

import indi.ye.pojo.UserManagePojo;
import indi.ye.service.SelectUserService;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SelectUserServiceImpl
 * @Description: 查询用户信息的service的实现类
 * @Author: ye
 * @Date: 2023/5/28 20:00
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class SelectUserServiceImpl implements SelectUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<UserManagePojo> selectUsers(int page, int size,int roleId) {
//        System.out.println(222222222);
        int num;
        int pageId=(page-1)*5;
        if(size-pageId>=5){
            num=5;
        }else {
            num=size-pageId;
        }
        List<UserManagePojo> userList;
        if(roleId==2){
            userList = userMapper.selectUsers(pageId,num,3);
        }else {
            userList = userMapper.selectManages(pageId,num);
        }

//        System.out.println("adad"+userList.get(1).getUid());

        return userList;
    }

    @Override
    public int selectUserSize(int roleId) {
        int num;
        if(roleId==1) {
            num = userMapper.selectUserSize();
        }else {
            num= userMapper.selectManageSize();
        }
        return num;
    }
}
