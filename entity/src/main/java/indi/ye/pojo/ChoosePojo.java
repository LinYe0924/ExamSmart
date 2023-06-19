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
    private String chooseId;
    private String chooseText;
    private String yeNoAnswer;



    @JsonCreator
    public ChoosePojo(@JsonProperty("chooseId") String chooseId, @JsonProperty("chooseText") String chooseText, @JsonProperty("yeNoAnswer") String yeNoAnswer) {
        this.chooseId = chooseId;
        this.chooseText = chooseText;
        this.yeNoAnswer = yeNoAnswer;
    }
}
