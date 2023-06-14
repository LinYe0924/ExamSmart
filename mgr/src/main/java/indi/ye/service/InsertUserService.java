package indi.ye.service;

/**
 * @InterfaceName: InsertUserService
 * @Description: 新增用户的service
 * @Author: ye
 * @Date: 2023/6/11 18:20
 */
public interface InsertUserService {
    public boolean insertUser(String userName,String userTel,String userEmail,int roleId);
}
