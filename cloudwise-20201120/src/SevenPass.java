/**
 * @author ：IvanZ
 * @version :
 * @date ：Created in 2020/11/20 14:40
 * @description ：逢七过
 * @modified By：
 */
public class SevenPass {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 || i % 10 == 7 || i / 10 == 7){
                System.out.println("过");
                count++;
                continue;
            }
            System.out.println(i);
        }
        System.out.println("一共"+count+"个过");
    }
}
