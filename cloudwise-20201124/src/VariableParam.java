/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 11:17
 * @description ：可变参数
 * @modified By：
 */
public class VariableParam {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(add1(a));
        System.out.println(add2(1,2,3,4,5));
    }
    /**
     * @create by: IvanZ
     * @description : 计算n个数之和
     * @create time: 2020/11/24 11:08
     * @param ints:
     * @return int
     */
    public static int add1(int[] ints){
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum;
    }

    /**
     * @create by: IvanZ
     * @description : 可变参数
     * @create time: 2020/11/24 11:20
     * @param ints:
     * @return int
     */
    public static int add2(int ...ints){
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum;
    }
}
