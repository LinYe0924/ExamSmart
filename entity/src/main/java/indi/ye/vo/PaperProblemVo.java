package indi.ye.vo;

import lombok.Data;

/**
 * @ClassName: PaperProblemVo
 * @Description: 考试试题的vo
 * @Author: ye
 * @Date: 2023/6/30 20:45
 */
@Data
public class PaperProblemVo {
    private int problem_id;
    private String problem_text;
    private String problem_answer;
    private int type_id;
    private int problem_point;
}
