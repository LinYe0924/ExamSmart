package indi.ye.pojo;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: PaperPojo
 * @Description: 试卷的pojo
 * @Author: ye
 * @Date: 2023/6/22 11:00
 */
@Data
public class PaperPojo {
    private int paper_id;
    private String paper_name;
    private Date paper_time;
    private int paper_score;
    private int project_id;
    private int user_id;
}
