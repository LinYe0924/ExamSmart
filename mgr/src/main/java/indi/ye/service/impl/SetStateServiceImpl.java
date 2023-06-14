package indi.ye.service.impl;

import indi.ye.mapper.UserMapper;
import indi.ye.service.SetStateService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: SetStateServiceImpl
 * @Description: 更用户状态的serviced的实现类
 * @Author: ye
 * @Date: 2023/6/10 11:05
 */
@Component
@Transactional(rollbackFor = Exception.class)//出现异常就回滚
public class SetStateServiceImpl implements SetStateService {
    @Resource
    UserMapper userMapper;
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
}
