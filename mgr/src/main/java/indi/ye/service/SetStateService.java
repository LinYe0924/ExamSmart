package indi.ye.service;

import org.springframework.stereotype.Service;

/**
 * @InterfaceName: SetStateService
 * @Description: 更改用户状态的service
 * @Author: ye
 * @Date: 2023/6/10 11:00
 */

public interface SetStateService {
    public boolean setUserState(int userId,int setNum);
}
