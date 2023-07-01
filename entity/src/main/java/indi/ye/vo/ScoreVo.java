package indi.ye.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ScoreVo
 * @Description: 成绩的vo
 * @Author: ye
 * @Date: 2023/7/1 23:14
 */
@Data
public class ScoreVo {
    private int score_id;
    private int score_num;
    private int reg_id;
    private String exam_name;
    private int paper_score;
    private String stu_name;
    private Date score_time;
}
