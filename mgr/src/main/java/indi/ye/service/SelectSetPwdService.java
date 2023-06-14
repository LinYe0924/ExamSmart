package indi.ye.service;

/**
 * @InterfaceName: SelectSetPwdService
 * @Description: 这是修改密码时查看原密码是否正确的service接口
 * @Author: ye
 * @Date: 2023/6/12 14:42
 */
public interface SelectSetPwdService {
    public boolean  selectPwd(int userId,String oldPwd);
}
