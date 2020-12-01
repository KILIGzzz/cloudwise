import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 15:16
 * @description ：测试trycatch
 * @modified By：
 */
public class TestTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入被除数：");
            int i = sc.nextInt();
            System.out.println("请输入除数：");
            int j = sc.nextInt();
            System.out.println("结果：" + i / j);
        } catch (InputMismatchException e) {
            System.out.println("只能输入数字！");
        } catch (Exception e) {
            System.out.println("除数不能为0");
        } finally {
            System.out.println("结束...");
        }
    }
}
