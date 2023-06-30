package indi.ye.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: RegVo
 * @Description: 考试报名的vo
 * @Author: ye
 * @Date: 2023/6/29 10:45
 */
@Data
public class RegVo {
    private int reg_id;
    private int pass_state;
    private Date reg_time;
    private int stu_id;
    private int exam_id;
    private String exam_name;
    private String stu_name;
}
