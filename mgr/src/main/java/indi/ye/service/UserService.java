package indi.ye.service;

import indi.ye.pojo.UserManagePojo;

import java.util.List;

/**
 * @InterfaceName: UserService
 * @Description: 用户的service接口
 * @Author: ye
 * @Date: 2023/6/15 16:32
 */
public interface UserService {
    public boolean insertUser(String userName,String userTel,String userEmail,int roleId);
    public List<UserManagePojo> findUser(String userName, String userTel, int selectRoleId, int stateId);
    public boolean setUserInfo(int userId,String userName,String userTel,int roleId);
    public boolean setUserState(int userId,int setNum);
    public boolean setPwd(int userId, String newPwd);
    List<UserManagePojo> selectUsers(int page, int size,int roleId);
    int selectUserSize(int roleId);
    public boolean  selectPwd(int userId,String oldPwd);
    public boolean resettingPwd(int userId);
    String login(String uTel,String uPwd);
}
