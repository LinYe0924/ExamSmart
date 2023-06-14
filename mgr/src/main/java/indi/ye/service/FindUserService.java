package indi.ye.service;

import indi.ye.pojo.UserManagePojo;

import java.util.List;

/**
 * @InterfaceName: FindUserService
 * @Description: 模糊查询的service
 * @Author: ye
 * @Date: 2023/6/11 21:25
 */
public interface FindUserService {
    public List<UserManagePojo> findUser(String userName,String userTel,int selectRoleId,int stateId);
}
