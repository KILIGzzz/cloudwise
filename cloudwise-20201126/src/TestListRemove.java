import java.util.ArrayList;
import java.util.List;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 10:10
 * @description ：测试删除集合的某个元素
 * @modified By：
 */
public class TestListRemove {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        //集合添加元素
        list.add(new Person(1,"Ivan1"));
        list.add(new Person(2,"Ivan2"));

        System.out.println("删除前："+list.toString());
        Person person = new Person(1,"Ivan1");
        list.remove(person);
        System.out.println("删除后："+list.toString());
    }
}
