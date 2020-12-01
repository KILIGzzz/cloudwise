import java.util.ArrayList;
import java.util.List;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 11:55
 * @description ：测试泛型方法以及通配符
 * @modified By：
 */
public class TestGeneric {
    public static void main(String[] args) {
        //测试泛型方法
        int i = 1;
        System.out.println(test(i));

        //测试通配符上限
        List<String> list = new ArrayList<>();
        list.add("Ivan");
        list.add("Ivan1");
        list.add("Ivan2");
        test(list);

        //测试通配符下限
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Number> list2 = new ArrayList<>();
        list2.add(3);
        fromSonListToFatherList(list1,list2);
        System.out.println(list2.toString());
    }
    /**
     * @create by: IvanZ
     * @description : 泛型方法
     * @create time: 2020/11/26 12:03
     * @param t:
     * @return T
     */
    public static  <T> T test(T t){
        return t;
    }

    /**
     * @create by: IvanZ
     * @description : 通配符上限
     * @create time: 2020/11/26 12:06
     * @param list:
     * @return void
     */
    public static <Z> void test(List<? extends Z> list){
        for (Z z: list) {
            System.out.println(z);
        }
    }

    /**
     * @create by: IvanZ
     * @description : 通配符下限
     * @create time: 2020/11/26 15:09
     * @param a:
     * @param b:
     * @return void
     */
    public static <Z> void fromSonListToFatherList(List<Z> a, List<? super Z> b) {
        b.addAll(a);
    }
}
