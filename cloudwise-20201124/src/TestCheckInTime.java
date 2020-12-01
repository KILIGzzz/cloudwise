import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 10:13
 * @description ：签到时间按从早到晚排序
 * @modified By：
 */
public class TestCheckInTime {
    public static void main(String[] args) {
        LocalDateTime[] times = new LocalDateTime[4];
        times[0] = LocalDateTime.parse("2020-11-24T08:53:13");
        times[1] = LocalDateTime.parse("2020-11-24T08:52:25");
        times[2] = LocalDateTime.parse("2020-11-24T08:57:45");
        times[3] = LocalDateTime.parse("2020-11-24T08:43:20");
        System.out.println("排序前：");
        for (LocalDateTime time : times) {
            System.out.println(time);
        }
        for (int i = 1; i < times.length ; i++) {
            for (int j = 0; j < times.length-i; j++) {
                if (times[j].until(LocalDateTime.now(), ChronoUnit.SECONDS) < times[j+1].until(LocalDateTime.now(),ChronoUnit.SECONDS)){
                    LocalDateTime temp = times[j];
                    times[j] = times[j+1];
                    times[j+1] = temp;
                }
            }
        }
        System.out.println("排序后：");
        for (LocalDateTime time : times) {
            System.out.println(time);
        }


    }

}
