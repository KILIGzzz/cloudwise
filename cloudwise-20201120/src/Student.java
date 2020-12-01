/**
 * @author ：IvanZ
 * @version :
 * @date ：Created in 2020/11/20 11:19
 * @description ：
 * @modified By：
 */
public class Student {

    int id;

    String name;

    int age;


    public void introduce(Student student){
        System.out.println("我叫"+student.name+",我的学号是"+student.id+",我今年"+student.age+"岁了");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.id=1;
        student.name="IvanZ";
        student.age=20;
        student.introduce(student);

    }
}
