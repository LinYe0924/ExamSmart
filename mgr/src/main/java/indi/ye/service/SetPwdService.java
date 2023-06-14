package indi.ye.service;

/**
 * @InterfaceName: SetPwdService
 * @Description: 修改密码的service接口
 * @Author: ye
 * @Date: 2023/6/12 15:12
 */
public interface SetPwdService {
    public boolean setPwd(int userId, String newPwd);
}
