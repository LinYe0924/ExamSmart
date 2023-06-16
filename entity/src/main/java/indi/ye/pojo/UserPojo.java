package indi.ye.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UserPojo {
    private int user_id;
    private String user_tel;
//    @Value("001")
    private String user_name;
//    @Value("001")
    private String user_pwd;
    private int role_id;
    private int user_state;
    public UserPojo() {
    }


    public UserPojo(String user_tel, String user_pwd) {
        this.user_tel = user_tel;
        this.user_pwd = user_pwd;
    }
}
