package work;

import java.util.Arrays;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/27 21:53
 * @description ：给定一个整数数组和一个目标值Target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标.
 * 你可以假设每种输入只会对应一个答案.但是，数组中同一个元素不能使用两遍.
 * @modified By：
 */
public class Work2 {
    public static void main(String[] args) {
        //定义数组
        int[] nums = {4,5,7,3,2,6};
        //定义target
        int target = 10;
        //结果数组
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    System.out.println(Arrays.toString(result));
                    break;
                }
            }
        }
    }
}
