package work;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 17:35
 * @description ：创建一个map<Person,Person>
 * @modified By：
 */
public class MapWork {
    public static void main(String[] args) {
        //创建Map
        Map<Person,Person> map = new HashMap<>(4);
        //创建4个Person对象
        Person ivan1 = new Person(1, "Ivan1");
        Person ivan2 = new Person(2, "Ivan1");
        Person ivan3 = new Person(3, "Ivan2");
        Person ivan4 = new Person(4, "Ivan3");
        //将Person对象放入map中
        map.put(ivan1,ivan1);
        map.put(ivan2,ivan2);
        map.put(ivan3,ivan3);
        map.put(ivan4,ivan1);
        //遍历输出
        for (Map.Entry<Person, Person> personPersonEntry : map.entrySet()) {
            System.out.println(personPersonEntry);
        }
    }
}
