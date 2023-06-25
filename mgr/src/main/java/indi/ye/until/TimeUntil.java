package indi.ye.until;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TimeUntil
 * @Description: 这是用于时间格式转化的工具类
 * @Author: ye
 * @Date: 2023/6/25 16:03
 */
public class TimeUntil {
    public Date stringToDate(String time){
        // 日期格式化对象 线程不安全，需定义为局部变量保证线程安全（常用格式 2020-01-01 00:00:00）
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=null;
        try {
            // 字符串转Date
            date = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
