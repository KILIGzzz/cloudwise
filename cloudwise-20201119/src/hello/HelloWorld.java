package hello;

/**
 * @author ：IvanZ
 * @date ：Created in 2020/11/19 15:15
 * @description：xxx
 * @modified By：
 * @version: 1.0
 */
public class HelloWorld {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        three(a, b);

    }

    public static void three(int a, int b) {
        System.out.println(a > b ? "大于" : "小于等于");
    }


}
