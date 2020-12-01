package test;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 11:52
 * @description ：黑白打印机
 * @modified By：
 */
public class BwPrinter implements Printer {

    @Override
    public void print(String test) {
        System.out.println("黑白打印："+test);
    }
}
