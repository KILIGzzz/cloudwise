
import java.util.Random;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 15:40
 * @description ：Ivan的工具类
 * @modified By：
 */
public class IvanUtils {
    static final String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

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

}
