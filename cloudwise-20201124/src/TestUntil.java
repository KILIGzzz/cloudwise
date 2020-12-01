import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 20:22
 * @description ：测试Until
 * @modified By：
 */
public class TestUntil {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.parse("2020-11-24T08:02:27");
        LocalDateTime time2 = LocalDateTime.parse("2020-11-24T12:14:27");
        LocalDateTime time3 = LocalDateTime.parse("2020-11-24T16:29:27");
        System.out.println(time1.until(time2, ChronoUnit.SECONDS));
        System.out.println(time2.until(time3, ChronoUnit.SECONDS));
    }
}
