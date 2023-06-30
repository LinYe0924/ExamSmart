package indi.ye.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ExamPojo
 * @Description: 考试的pojo
 * @Author: ye
 * @Date: 2023/6/25 19:05
 */
@Data
public class ExamPojo {
    private int exam_id;
    private String exam_name;
    private Date start_time;
    private Date end_time;
    private Date reg_end_time;
    private int paper_id;
    private int user_id;
    private String paper_name;
    private String user_name;
    private int exam_state;
    private String project_name;
    private int regState;
}
