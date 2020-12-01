package test;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 11:53
 * @description ：彩色打印机
 * @modified By：
 */
public class ColorPrinter implements Printer {

    @Override
    public void print(String test) {
        System.out.println("彩色打印："+test);
    }
}
