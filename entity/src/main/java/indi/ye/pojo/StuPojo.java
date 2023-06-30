package indi.ye.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: StuPojo
 * @Description: 学生的pojo
 * @Author: ye
 * @Date: 2023/6/28 14:10
 */
@Data
public class StuPojo {
    private Integer stu_id;
    private String stu_name;
    private String stu_tel;
    private String id_num;
    private String stu_mail;
    private String stu_pwd;
    private Date stu_time;

    public StuPojo(String stu_name, String stu_tel, String id_num, String stu_mail, String stu_pwd) {
        this.stu_name = stu_name;
        this.stu_tel = stu_tel;
        this.id_num = id_num;
        this.stu_mail = stu_mail;
        this.stu_pwd = stu_pwd;
    }
}
