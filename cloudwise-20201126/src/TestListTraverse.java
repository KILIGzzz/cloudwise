import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 9:42
 * @description ：集合的遍历
 * @modified By：
 */
public class TestListTraverse {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        //fori遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("==================");

        //for遍历
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("==================");

        //迭代器遍历
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
