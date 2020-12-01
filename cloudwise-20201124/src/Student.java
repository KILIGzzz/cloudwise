import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 11:47
 * @description ：比较器
 * @modified By：
 */
public class Student implements Comparable<Student>{
    String name;
    int age;
    LocalDateTime checkInTime;
    LocalDateTime checkOutTime;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                '}';
    }

    public Student(String name, int age, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        this.name = name;
        this.age = age;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public Student() {
    }


    /**
     * @create by: IvanZ
     * @description : 比较器，需实现Comparable接口，并重写compareTo方法，负数< 0= 正数>
     * @create time: 2020/11/24 11:50
     * @param o:
     * @return int
     */
    @Override
    public int compareTo(Student o) {
        //比较上下班时间差
        if (time(this)<time(o)) {
            return -1;
        }
        if (time(this)>time(o)){
            return 1;
        }
        return 0;
    }

    /**
     * @create by: IvanZ
     * @description : 返回上下班时间差
     * @create time: 2020/11/24 14:54
     * @param student:
     * @return long
     */
    public long time(Student student){
        return Duration.between(student.checkInTime,student.checkOutTime).toMillis();
    }


    public static void main(String[] args) {
        Student[] students = new Student[4];

        //随机传入LocalDateTime参数
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Ivan"+i,18,LocalDateTime.parse("2020-11-24T08:"+IvanUtils.getRandomMin()+":13"),LocalDateTime.parse("2020-11-24T20:"+IvanUtils.getRandomMin()+":13"));
        }

        System.out.println("排序前：");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        //进行排序
        Arrays.sort(students);

        System.out.println("排序后：");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

    }
}
