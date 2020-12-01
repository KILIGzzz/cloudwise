package work;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 17:08
 * @description ：trycatch作业
 * @modified By：
 */
public class TryCatchWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时间字符串：");
        String s = sc.nextLine();
        try {
            LocalDateTime localDateTime = IvanUtils.getLocalDateTime(s);
            System.out.println(localDateTime);
        } catch (Exception e) {
            Logger logger = Logger.getLogger(TryCatchWork.class);
            logger.debug("日期格式错误！");
        }

    }
}
