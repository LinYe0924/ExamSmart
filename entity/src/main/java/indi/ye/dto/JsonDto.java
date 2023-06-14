package indi.ye.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JsonDto
 * @Description: 这是登录的dto
 * @Author: ye
 * @Date: 2023/5/15 15:53
 */
@Component
public class JsonDto {
    private Map<String, Object> data=new HashMap<>();



    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
