package work;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/27 14:33
 * @description ：输入一个字符串，统计字符个数
 * @modified By：
 */
public class Work1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String string = sc.nextLine();
        String[] strings = string.split("");

        Map<String,Integer> map = new HashMap<>(100);

        for (String s : strings) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        System.out.println(map);
    }
}
