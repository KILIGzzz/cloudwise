import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 17:00
 * @description ：由员工上下班时间求员工工作时间，不满8小时提示早退
 * @modified By：
 */
public class Employee {
    int id;
    String name;
    LocalDateTime checkOnTime;
    LocalDateTime checkOutTime;

    public Employee() {
    }

    public Employee(int id, String name, LocalDateTime checkOnTime, LocalDateTime checkOutTime) {
        this.id = id;
        this.name = name;
        this.checkOnTime = checkOnTime;
        this.checkOutTime = checkOutTime;
    }

    /**
     * @param employee: 传递员工对象
     * @return void
     * @create by: IvanZ
     * @description : 自我介绍
     * @create time: 2020/11/23 18:01
     */
    public void introduce(Employee employee) {
        System.out.println("我是" + employee.name + "，我的员工编号是" + id);
    }

    /**
     * @param employee: 传递员工对象
     * @return java.lang.String
     * @create by: IvanZ
     * @description : 获取员工工作的时间，若工作时间不到8小时提示早退
     * @create time: 2020/11/23 18:01
     */
    public String getWorkTime(Employee employee) {
        //获取上下班秒数的时间差
         long workSeconds = employee.checkOnTime.until(employee.checkOutTime,ChronoUnit.SECONDS);
        //工作的小时数
        long hour = workSeconds / (60 * 60);
        //工作的分钟数
        long minute = workSeconds / 60 % 60;
        //工作的秒数
        long second = workSeconds % 60;
        //距工作8小时还需多少秒
        long restSeconds = 8 * 60 * 60 - workSeconds;
        //如果工作时间不到8小时
        if (hour < 8) {
            System.out.println("早退！还需工作" + restSeconds / (60 * 60) + "小时" + restSeconds / 60 % 60 + "分钟" + restSeconds % 60 + "秒" + "可以下班");
            return "";
        } else {
            return "工作时间为："+hour + "小时" + minute + "分钟" + second + "秒";
        }
    }

    public static void main(String[] args) {
        //设置上班时间
        LocalDateTime checkOnTime = LocalDateTime.parse("2020-11-23T08:20:00");
        //设置下班时间
        LocalDateTime checkOutTime = LocalDateTime.parse("2020-11-23T20:30:00");
        //实例化员工对象并传值
        Employee employee = new Employee(1, "IvanZ", checkOnTime, checkOutTime);
        //调用introduce和getWorkTime方法
        employee.introduce(employee);
        System.out.println(employee.getWorkTime(employee));
    }
}
