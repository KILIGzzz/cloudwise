import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 16:14
 * @description ：计算每天工作时长，输入错误重新输入
 * @modified By：
 */
public class WorkTime2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long startTime;
        long endTime;

        while (true) {
            try {
                System.out.println("请输入开始工作的时间：");
                String start = sc.nextLine();
                //转换为毫秒数
                startTime = sdf.parse(start).getTime();
                break;
            } catch (ParseException e) {
                System.out.println("输入错误，请重新输入：");
            }
        }

        while (true) {
            try {
                System.out.println("请输入结束工作的时间：");
                String end = sc.nextLine();
                //转换为毫秒数
                endTime = sdf.parse(end).getTime();
                break;
            } catch (ParseException e) {
                System.out.println("输入错误，请重新输入：");
                continue;
            }
        }

        //计算出工作时间的毫秒数
        long time = endTime - startTime;

        System.out.println("一共工作了" + time / (1000 * 60 * 60) + "小时" + (time / 1000 / 60) % 60 + "分钟" + (time / 1000) % 60 + "秒");

    }
}
