package cloudwise.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author ：Teacher陈
 * @date ：Created in 2020/11/24 15:36
 * @description：我的工具类
 * @modified By：
 * @version: 1.0
 */
public class MyTools {
    /**
     * @create by: Teacher陈
     * @description: 获取随机的分钟数
     * @create time: 2020/11/24 15:34
     * @return
     */
    public static String getRandomMin(){
        int a=1/0;
        Random random= new Random();
        //获取60以内的随机整数
        int minutes=random.nextInt(60);
        String minStr="0";
        if(minutes<10){
            minStr=minStr+minutes;
        }else
        {
            minStr=minutes+"";
        }
        return minStr;
    }
    /**
     * @create by: Teacher陈
     * @description: 传入字符串时间，返回localdatetime时间
     * @create time: 2020/11/24 15:26
     * @param time
     * @return dateTime
     */
    public  static LocalDateTime getLocalDateTimeFromString(String  time){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(MyConstants.TIME_PATTERN);
        LocalDateTime dateTime = LocalDateTime.parse(time, dateTimeFormatter);
        return dateTime;

    }


}
