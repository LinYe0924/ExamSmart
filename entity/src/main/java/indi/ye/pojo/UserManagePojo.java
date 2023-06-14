package indi.ye.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: UserManagePojo
 * @Description: 用户管理的pojo
 * @Author: ye
 * @Date: 2023/6/8 16:18
 */
@Component
@Data
public class UserManagePojo {
    private int user_id;
    private String user_tel;
    private String user_name;
    private int role_id;
    private int user_state;
    private Date user_time;

}
