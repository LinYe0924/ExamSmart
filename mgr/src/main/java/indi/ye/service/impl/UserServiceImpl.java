package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.pojo.UserManagePojo;
import indi.ye.pojo.UserPojo;
import indi.ye.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户的service的实习类
 * @Author: ye
 * @Date: 2023/6/15 16:36
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<UserManagePojo> findUser(String userName, String userTel, int selectRoleId, int stateId) {
        List<UserManagePojo> userList;
        userList=userMapper.findUser(userName,userTel,selectRoleId,stateId);
        return userList;
    }
    @Override
    public boolean insertUser(String userName, String userTel, String userEmail, int roleId) {
        userMapper.insertUser(userName,userTel,userEmail,roleId);
        return true;
    }
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
    @Override
    public boolean resettingPwd(int userId) {
        userMapper.resettingPwd(userId);
        return true;
    }
    @Override
    public boolean selectPwd(int userId, String oldPwd) {
        System.out.println("更改密码的用户编号："+userId);
        UserPojo userPojo = userMapper.selectPwd(userId);
        if(oldPwd.equals(userPojo.getUser_pwd())){
            return true;
        }
        return false;
    }
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
    @Override
    public boolean setPwd(int userId, String newPwd) {
        userMapper.setPwd(userId,newPwd);
        return true;
    }
    @Override
    public boolean setUserState(int userId,int setNum) {
//        Integer res =
        userMapper.setUserState(userId, setNum);
//        System.out.println("res:"+res);
//        if(res>0){
        return true;
//        }else {
//            return false;
//        }
    }
    @Override
    public boolean setUserInfo(int userId, String userName, String userTel, int roleId) {
        userMapper.setUserInfo(userId,userName,userTel,roleId);
        return true;
    }
}
