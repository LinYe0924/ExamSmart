package indi.ye.service;

/**
 * @InterfaceName: SetUserInfoService
 * @Description: 修改用户信息service
 * @Author: ye
 * @Date: 2023/6/10 23:42
 */
public interface SetUserInfoService {
    public boolean setUserInfo(int userId,String userName,String userTel,int roleId);
}
