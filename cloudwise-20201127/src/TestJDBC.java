import work.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/27 9:02
 * @description ：测试数据库
 * @modified By：
 */
public class TestJDBC {
    static String url = "jdbc:mysql://localhost:3306/cloudwise?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String driver = "com.mysql.jdbc.Driver";
    static String user = "root";
    static String password = "qepwq";
    //加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @create by: IvanZ
     * @description : 获取数据库连接
     * @create time: 2020/11/27 11:51
     * @param :
     * @return java.sql.Connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @create by: IvanZ
     * @description : 关闭所有连接
     * @create time: 2020/11/27 11:54
     * @param ps:
 * @param connection:
     * @return void
     */
    public static void closeAll(PreparedStatement ps,Connection connection){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //编写sql语句
        String sql1 = "update dept set loc = ? where deptid = ?";
        String sql2 = "delete from dept where deptid = ?";
        String sql3 = "insert into dept values(?,?,?)";
        String sql4 = "select * form dept";
        System.out.println(JDBCUtils.executeUpdateRetPk(sql3,"研发部","北京"));

//        //设置参数
//        PreparedStatement ps = null;
//        Connection connection = getConnection();
//        try {
//            ps = connection.prepareStatement(sql1);
//            ps.setString(1,"北京");
//            ps.setInt(2,50);
////            ps = connection.prepareStatement(sql2);
////            ps.setInt(1,50);
//            //执行sql，如果查询，返回结果集
//            int i = ps.executeUpdate();
//            if (i > 0){
//                System.out.println("操作成功！");
//            }else {
//                System.out.println("操作失败！");
//            }
//            //关闭数据连接
//            closeAll(ps,connection);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
