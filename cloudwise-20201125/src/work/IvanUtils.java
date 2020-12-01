package work;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 15:40
 * @description ：Ivan的工具类
 * @modified By：
 */
public class IvanUtils {
    static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * @create by: IvanZ
     * @description : 获取随机分钟
     * @create time: 2020/11/24 15:39
     * @param :
     * @return java.lang.String
     */
    public static String getRandomMin(){
        Random random = new Random();
        int minute = random.nextInt(60);
        String str = "0";
        if (minute < 10){
            str = str + minute;
        } else {
            str = minute+ "" ;
        }
        return str;
    }

    /**
     * @create by: IvanZ
     * @description : 输入日期字符串，通过格式化后的时间获取LocalDateTime
     * @create time: 2020/11/25 17:25
     * @param string:
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getLocalDateTime(String string){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDateTime.parse(string,dtf);
    }

}
