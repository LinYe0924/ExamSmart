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
public class ProblemPojo {
   private int problem_id;
    private String problem_text;
    private String problem_answer;
    private int type_id;
    private int project_id;
    private  int user_id;
    private  int problem_state;
    private String type_name;
    private String project_name;
    private String user_name;

    public ProblemPojo() {
    }

    public ProblemPojo(String problem_text, String problem_answer, int type_id, int project_id, int user_id) {
        this.problem_text = problem_text;
        this.problem_answer = problem_answer;
        this.type_id = type_id;
        this.project_id = project_id;
        this.user_id = user_id;
    }
}
