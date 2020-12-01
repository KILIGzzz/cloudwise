import java.util.Scanner;

/**
 * @author ：IvanZ
 * @version :1.0
 * @date ：Created in 2020/11/20 9:52
 * @description ：循环输入周一到周五的成绩，要求成绩不能是负数，如果为负数，重新输入，结果显示，平均分，最高分，最低分。
 * @modified By：
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println("请输入成绩：");
        Scanner sc = new Scanner(System.in);
        int[] score = new int[5];
        for (int i = 0; i < 5 ; i++) {
            int j = i;
            System.out.println("请输入周"+(++j)+"的成绩：");
            int t = sc.nextInt();
            if (t < 0){
                i--;
                System.out.println("输入错误，请重新输入：");
                continue;
            }
            score[i] = t;
        }
        int totalScore = 0;
        int avgScore = 0;
        int maxScore = score[0];
        int minScore = score[0];
        for (int i = 0; i < score.length; i++) {
            totalScore += score[i];
            if (maxScore < score[i]){
                maxScore = score[i];
            }
            if (minScore > score[i]){
                minScore = score[i];
            }
        }
        avgScore = totalScore/5;

        System.out.println("平均分："+avgScore);
        System.out.println("最高分："+maxScore);
        System.out.println("最低分："+minScore);

    }
}
