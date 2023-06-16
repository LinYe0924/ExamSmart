package indi.ye.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ProblemPojo
 * @Description: 问题的pojo模型
 * @Author: ye
 * @Date: 2023/6/16 9:18
 */
@Data
@Component
public class ProblemPojo {
    int problem_id;
    String problem_text;
    String problem_answer;
    int type_id;
    int project_id;
    int user_id;
}
