package indi.ye.service;



import indi.ye.pojo.UserManagePojo;

import java.util.List;

/**
 * @InterfaceName: SelectUserService
 * @Description: 这是查询用户信息的service
 * @Author: ye
 * @Date: 2023/5/28 19:53
 */
public interface SelectUserService {
    List<UserManagePojo> selectUsers(int page, int size,int roleId);
    int selectUserSize(int roleId);
}
