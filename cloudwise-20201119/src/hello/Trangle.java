package hello;

/**
 * @author ：IvanZ
 * @date ：Created in 2020/11/19 18:17
 * @description：等边三角形
 * @modified By：
 * @version: 1.0
 */
public class Trangle {
    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            for (int j = 0; j <i ; j++) {
                print(i,j);
            }
            System.out.println("");
        }

        for (int i = 10; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                print(i,j);
            }
            System.out.println("");
        }
    }

    public static void print(int i,int j){
        if (i%2==0&&j%2==1){
            System.out.print(" ");
        }else if (i%2==1&&j%2==0){
            System.out.print(" ");
        }else {
            System.out.print("*");
        }
        System.out.print("     ");
    }
}
