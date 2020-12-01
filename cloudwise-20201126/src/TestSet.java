import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 15:23
 * @description ：测试Set
 * @modified By：
 */
public class TestSet {
    public static void main(String[] args){
        //测试HashSet
        Set<Person> hashSet = new HashSet<>();
        hashSet.add(new Person(1, "Ivan1"));
        hashSet.add(new Person(3, "Ivan3"));
        hashSet.add(new Person(2, "Ivan2"));
        hashSet.add(new Person(4, "Ivan4"));
        System.out.println(hashSet);

        //测试TreeSet
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person(1, "Ivan1"));
        treeSet.add(new Person(3, "Ivan3"));
        treeSet.add(new Person(2, "Ivan2"));
        treeSet.add(new Person(4, "Ivan4"));
        System.out.println(treeSet);

    }
}
