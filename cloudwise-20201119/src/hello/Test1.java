package hello;

/**
 * @author ：IvanZ
 * @date ：Created in 2020/11/19 17:14
 * @description：x
 * @modified By：
 * @version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        String stu = args[0];
        int score = 0;
        for (int i = 1;i < args.length ;i++){
            score += Integer.parseInt(args[i]);
        }
        int avgScore = score/5;
        System.out.println(stu+":"+avgScore);
    }
}
