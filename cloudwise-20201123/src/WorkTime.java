import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 15:46
 * @description ：每天工作时长
 * @modified By：
 */
public class WorkTime {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始工作的时间：");
        String start = sc.nextLine();
        System.out.println("请输入结束工作的时间：");
        String end = sc.nextLine();

        //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        //将时间转换为毫秒数
        long startTime = sdf.parse(start).getTime();
        long endTime = sdf.parse(end).getTime();
        //计算出工作时间的毫秒数
        long time = endTime - startTime;

        System.out.println("一共工作了"+time/(1000*60*60)+"小时"+(time/1000/60)%60+"分钟"+(time/1000)%60+"秒");

    }
}
