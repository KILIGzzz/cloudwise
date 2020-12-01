import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 16:41
 * @description ：测试LocalDateTime类
 * @modified By：
 */
public class TestLocalDateTime {
    public static void main(String[] args) {
        System.out.println(ChronoUnit.SECONDS.between(LocalDateTime.parse("2020-11-23T13:30:00"),LocalDateTime.parse("2020-11-23T20:30:00")));
        System.out.println(ChronoUnit.MINUTES.between(LocalDateTime.parse("2020-11-23T13:30:00"),LocalDateTime.parse("2020-11-23T20:30:00")));
        System.out.println(ChronoUnit.HOURS.between(LocalDateTime.parse("2020-11-23T13:30:00"),LocalDateTime.parse("2020-11-23T20:30:00")));
    }
}
