import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 15:12
 * @description ：Int和Integer的测试
 * @modified By：
 */
public class IntTest {
    public static void main(String[] args) {
        int a = 100;
        int b = 100;
        int c = 1000;
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 1000;
        Integer i4 = 1000;
        Integer i5 = new Integer("1000");
        Integer i6 = new Integer("1000");

        System.out.println(a == i1);  //true
        System.out.println(a == i2);  //true
        System.out.println(i1 == i2); //true
        System.out.println(i3 == i4); //false
        System.out.println(c == i3);  //true
        System.out.println(c == i5);  //true
        System.out.println(i3 == i5);    //false
        System.out.println(i5 == i6);    //false

        int i = 123;
        Integer integer = 123;
        String str = "123";
        //int -> String
        System.out.println(i + "");
        System.out.println(String.valueOf(i));
        System.out.println(integer.toString());
        //String -> int
        System.out.println(Integer.parseInt(str));
        System.out.println(Integer.valueOf(str));
        System.out.println(new Integer("123"));


    }
}
