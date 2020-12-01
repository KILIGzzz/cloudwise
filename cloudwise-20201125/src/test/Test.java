package test;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 15:33
 * @description ：
 * @modified By：
 */
public class Test {
    public static void main(String[] args) {
        Master master = new Master("Ivan",20,new ColorPrinter(),"tom",2);
        Master.detail(master);

        Master master1 = new Master("Ivan1",20,new BwPrinter(),"jerry",2);
        Master.detail(master1);
    }
}
