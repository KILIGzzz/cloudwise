package work;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/29 14:08
 * @description ：JDBC工具类1
 * @modified By：
 */
public class JDBCUtils1 {
    static String url = "jdbc:mysql://localhost:3306/cloudwise?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String driver = "com.mysql.jdbc.Driver";
    static String username = "root";
    static String password = "qepwq";

    //加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean executeUpdate(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql语句的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps,objects);
            //执行sql，如果查询，返回结果集
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("操作成功");
                return true;
            }else {
                System.out.println("操作失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            closeAll(ps,connection,null);
        }
        return false;
    }

    public static Integer executeUpdateRetPk(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql语句的对象
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //设置参数
            setParam(ps,objects);
            //执行sql，如果查询，返回结果集
            int i = ps.executeUpdate();
            //解析结果集
            if (i > 0){
                System.out.println("操作成功");
                //返回主键
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }else {
                System.out.println("操作失败");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            closeAll(ps,connection,null);
        }
        return null;
    }

    public static List<Map<String,Object>> executeQuery(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //获取执行sql语句的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps,objects);
            //执行sql，如果查询，返回结果集
            resultSet = ps.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<Map<String,Object>> rowList = new ArrayList<>();
            //解析结果集
            while (resultSet.next()){
                //装一整行数据
                Map<String,Object> rowMap = new HashMap<>();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    //遍历一行数据
                    String key = metaData.getColumnName(i + 1);
                    //获取列值，作为map集合的value
                    Object value = resultSet.getObject(i + 1);
                    rowMap.put(key,value);
                }
                rowList.add(rowMap);
            }
            return rowList;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            closeAll(ps,connection,resultSet);
        }
        return null;
    }

    public static void setParam(PreparedStatement ps,Object[] objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i+1,objects[i]);
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeAll(PreparedStatement ps, Connection connection, ResultSet resultSet){
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
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
