/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/23 11:21
 * @description ：String StringBuffer StringBuilder时间
 * @modified By：
 */
public class Compare {
    public static void main(String[] args) {
        //String
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i <5000 ; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String时间："+(end - start));

        //StringBuffer
        StringBuffer stringBuffer = new StringBuffer("");
        long start1 = System.currentTimeMillis();
        for (int i = 0; i <500000 ; i++) {
            stringBuffer.append(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("StringBuffer时间："+(end1 - start1)  );

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder("");
        long start2 = System.currentTimeMillis();
        for (int i = 0; i <500000 ; i++) {
            stringBuilder.append(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder时间："+(end2 - start2));
    }
}
