
/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/24 9:48
 * @description ：数组测试
 * @modified By：
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,2,5,4,8};


        //冒泡排序
        for (int i = 1; i <arr1.length ; i++) {
            for (int j = 0; j <arr1.length-i ; j++) {
                if (arr1[j] > arr1[j+1]){
                    int temp = arr1[j+1];
                    arr1[j+1] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        for (int i : arr1) {
            System.out.println(i);
        }
    }

}
