
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 18:18
 * @description ：
 * @modified By：
 */
public class Students implements Comparable<Students>{
    int id;
    String name;
    LocalDateTime checkInTime;
    LocalDateTime checkOutTime;
    String message;

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
        if (time(this)/1000/60/60 < 8) {
            System.out.println(this.name+"同学的工作时长不到8小时！");
            this.setMessage("不满8小时，早退！");
        }else {
            this.setMessage("已满8小时，正常下班！");
        }
    }


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

    /**
     * @create by: IvanZ
     * @description : 返回上下班时间差
     * @create time: 2020/11/24 18:34
     * @param student:
     * @return long
     */
    public long time(Students student){
        return Duration.between(student.checkInTime,student.checkOutTime).toMillis();
    }

    /**
     * @create by: IvanZ
     * @description : 比较器
     * @create time: 2020/11/24 18:32
     * @param o:
     * @return int
     */
    @Override
    public int compareTo(Students o) {
        if (time(this)<time(o)){
            return -1;
        }
        if (time(this)>time(o)){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Students[] students = new Students[5];

        for (int i = 0; i < students.length; i++) {
            Students stu = new Students();
            stu.setId(i);
            stu.setName("Ivan"+i);
            stu.setCheckInTime(LocalDateTime.parse("2020-11-24T08:"+getRandomMin()+":27"));
            stu.setCheckOutTime(LocalDateTime.parse("2020-11-24T16:"+getRandomMin()+":27"));
            students[i] = stu;
        }

        System.out.println("按工作时长排序前：");
        for (Students student : students) {
            System.out.println(student);
        }
        //排序
        Arrays.sort(students);

        System.out.println("按工作时长排序后：");
        for (Students student : students) {
            System.out.println(student);
        }

    }

}
