import work.JDBCUtils;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/27 17:17
 * @description ：测试JDBC工具类
 * @modified By：
 */
public class TestJDBCUtils {
    public static void main(String[] args) {
        //编写sql语句
        String sql1 = "update dept set loc = ? where deptid = ?";
        String sql2 = "delete from dept where deptid = ?";
        String sql3 = "insert into dept values(?,?,?)";
        String sql4 = "select * from dept";
        System.out.println(JDBCUtils.executeQuery(sql4));
    }
}
