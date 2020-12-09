package cloudwise.util;

/**
 * @author ：Teacher陈
 * @date ：Created in 2020/11/19 16:17
 * @description：我的常量类
 * @modified By：
 * @version: 1.0
 */
public class MyConstants {
    /**
     * 错误代码
     */
    public static  final String ERROR_CODE="501";
    /**
     * 统一设置时间格式
     */
    public static final String TIME_PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 默认的分页参数，当前默认第一页
     */
    public  static final int PAGE_NO=1;
    /**
     * 默认的分页参数，当前默认一页显示5条数据
     */
    public  static final int PAGE_SIZE=20;

    public static int  a=100;

    public static void main(String[] args) {
        long b=300;
        double  d=543;
        Float e=424f;
        String  a="a";
        System.out.println(MyConstants.a);

        short aa=12;
/*        int bb=13;
        //自动转换
        int  cc =aa+bb;
        //强制类型转换
        short cc =(short)(aa+bb);*/
        short ff=23;
        int  gg=aa+ff;
    }
}
