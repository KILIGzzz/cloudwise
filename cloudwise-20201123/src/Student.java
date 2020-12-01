/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 9:30
 * @description ：学生类
 * @modified By：
 */
public class Student extends Teacher{
    Teacher teacher;

    public Student(String name, int age, Teacher teacher) {
        super(name, age);
        this.teacher = teacher;
    }


    /**
     * @create by: IvanZ
     * @description : 自我介绍
     * @create time: 2020/11/23 9:40
     * @param null
     * @return void
     */
    public void introduce(){
        System.out.println("我是"+name+",今年"+age+",老师是"+teacher.name);
    }

    /**
     * @create by: IvanZ
     * @description : 两数相加
     * @create time: 2020/11/23 9:41
     * @param a:
     * @param b:
     * @return int
     */
    public static int add(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        Student student = new Student("IvanZ",20,new Teacher("Teacher陈"));
        student.introduce();

        add(3,4);
    }
}
