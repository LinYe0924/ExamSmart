package indi.ye.mapper;

import indi.ye.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @InterfaceName: UserMapper
 * @Description: 用户mybatis的接口
 * @Author: ye
 * @Date: 2023/5/26 14:58
 */
@Component
public interface UserMapper {
 UserPojo login(@Param("user_tel") String user_tel,@Param("user_pwd") String user_pwd);
 List selectUsers(@Param("page") int page,@Param("size") int size,@Param("role_id") int roleId);
 List selectManages(@Param("page") int page,@Param("size") int size);
 Integer setUserState(@Param("user_id") int user_id,@Param("setNum") int setNum);
 Integer resettingPwd(@Param("user_id") int user_id);
 Integer setUserInfo(@Param("user_id") int userId, @Param("userName") String userName, @Param("userTel") String userTel, @Param("roleId") int roleId);
 Integer insertUser(@Param("userName") String userName, @Param("userTel") String userTel, @Param("userEmail") String userEmail, @Param("roleId") int roleId);
 Integer selectUserSize();
 Integer selectManageSize();
 List findUser(@Param("userName") String userName, @Param("userTel") String userTel, @Param("selectRoleId") int selectRoleId, @Param("stateId") int stateId);
 UserPojo selectPwd(@Param("user_id") int user_id);
 Integer setPwd(@Param("user_id") int user_id,@Param("user_pwd") String user_pwd);
}
