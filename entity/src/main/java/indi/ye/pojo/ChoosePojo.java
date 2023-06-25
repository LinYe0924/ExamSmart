package indi.ye.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName: ChoosePojo
 * @Description: 这是用于接收前端发回的多选题选项的pojo
 * @Author: ye
 * @Date: 2023/6/18 19:46
 */
@Data
public class ChoosePojo {
    private String choose_id;
    private String choose_text;
    private String yeNoAnswer;
    private String choose_letter;



    @JsonCreator
    public ChoosePojo(@JsonProperty("chooseId") String choose_id, @JsonProperty("chooseText") String choose_text, @JsonProperty("yeNoAnswer") String yeNoAnswer) {
        this.choose_id = choose_id;
        this.choose_text = choose_text;
        this.yeNoAnswer = yeNoAnswer;
    }
}
