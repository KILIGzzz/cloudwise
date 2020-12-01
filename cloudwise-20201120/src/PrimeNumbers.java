/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/20 17:07
 * @description ：100以内的质数
 * @modified By：
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 2; i < 100; i++) {
            int count = 0;
            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0){
                    count++;
                }
            }
            if (count == 1){
                System.out.print(i+" ");
                total++;
            }
        }
        System.out.println();
        System.out.println("100以内的质数一共有"+total+"个");
    }
}
