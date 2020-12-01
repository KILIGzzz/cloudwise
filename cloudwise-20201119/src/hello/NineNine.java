package hello;

/**
 * @author ：IvanZ
 * @date ：Created in 2020/11/19 18:08
 * @description：九九乘法表
 * @modified By：
 * @version: 1.0
 */
public class NineNine {
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            for (int j = 1; j < i+1 ; j++) {
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println("");
        }
    }
}
