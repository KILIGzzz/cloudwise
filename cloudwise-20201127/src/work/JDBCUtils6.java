package work;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/29 20:58
 * @description ：JDBC工具类
 * @modified By：
 */
public class JDBCUtils6 {
    static String url = "jdbc:mysql://localhost:3306/cloudwise?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String driver = "com.mysql.jdbc.Driver";
    static String user = "root";
    static String password = "qepwq";

    static {
        //加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sql:
     * @param objects:
     * @return boolean
     * @create by: IvanZ
     * @description : 通用增删改
     * @create time: 2020/11/29 21:07
     */
    public static boolean executeUpdate(String sql, Object... objects) {
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps, objects);
            //执行sql
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("操作成功");
                return true;
            } else {
                System.out.println("操作失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            closeAll(ps, connection, null);
        }
        return false;
    }

    /**
     * @param sql:
     * @param objects:
     * @return java.lang.Integer
     * @create by: IvanZ
     * @description : 通用增删改，并返回主键值
     * @create time: 2020/11/29 21:09
     */
    public static Integer executeUpdateRetPk(String sql, Object... objects) {
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //设置参数
            setParam(ps, objects);
            //执行sql
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("操作成功");
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            } else {
                System.out.println("操作失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            closeAll(ps, connection, null);
        }
        return null;
    }

    /**
     * @param sql:
     * @param objects:
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @create by: IvanZ
     * @description : 通用查询
     * @create time: 2020/11/29 21:09
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... objects) {
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps, objects);
            //执行sql
            resultSet = ps.executeQuery();
            List<Map<String, Object>> rowList = new ArrayList<>();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String key = metaData.getColumnName(i + 1);
                    Object value = resultSet.getObject(i + 1);
                    rowMap.put(key, value);
                }
                rowList.add(rowMap);
            }
            return rowList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            closeAll(ps, connection, resultSet);
        }
        return null;
    }


    /**
     * @param :
     * @return java.sql.Connection
     * @create by: IvanZ
     * @description : 获取连接
     * @create time: 2020/11/29 21:04
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @param ps:
     * @param objects:
     * @return void
     * @create by: IvanZ
     * @description : 设置参数
     * @create time: 2020/11/29 21:03
     */
    public static void setParam(PreparedStatement ps, Object[] objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i + 1, objects[i]);
        }
    }

    /**
     * @param ps:
     * @param connection:
     * @param resultSet:
     * @return void
     * @create by: IvanZ
     * @description : 关闭所有连接
     * @create time: 2020/11/29 21:02
     */
    public static void closeAll(PreparedStatement ps, Connection connection, ResultSet resultSet) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
