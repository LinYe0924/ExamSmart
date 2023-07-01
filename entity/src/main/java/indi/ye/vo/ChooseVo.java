package indi.ye.vo;

import lombok.Data;

/**
 * @ClassName: ChooseVo
 * @Description: 选项的vo
 * @Author: ye
 * @Date: 2023/6/30 21:18
 */
@Data
public class ChooseVo {
    private int problem_id;
    private String choose_letter;
    private String choose_text;
    private int choose_id;
}
