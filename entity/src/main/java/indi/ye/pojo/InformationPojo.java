package indi.ye.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: InformationPojo
 * @Description: 考试资讯的pojo
 * @Author: ye
 * @Date: 2023/6/27 16:56
 */
@Data
public class InformationPojo {
    private int informatation_id;
    private String informatation_tittle;
    private String informatation_text;
    private Date informatation_time;
    private int exam_id;
    private int user_id;
}
