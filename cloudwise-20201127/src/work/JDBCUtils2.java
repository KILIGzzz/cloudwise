package work;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/29 15:03
 * @description ：JDBC工具类2
 * @modified By：
 */
public class JDBCUtils2 {
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

    public static boolean executeUpdate(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps,objects);
            //执行sql
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
            closeAll(ps,connection,null);
        }
        return false;
    }

    public static Integer executeUpdateRetPk(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //设置参数
            setParam(ps,objects);
            //执行sql
            int i = ps.executeUpdate();
            //解析结果集
            if (i > 0){
                System.out.println("操作成功");
                //获取主键
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
            //获取执行sql的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps,objects);
            //执行sql
            resultSet = ps.executeQuery();
            List<Map<String,Object>> rowList = new ArrayList<>();
            //获取元数据
            ResultSetMetaData metaData = ps.getMetaData();
            //解析结果集
            while (resultSet.next()){
                //存入一行数据
                Map<String,Object> rowMap = new HashMap<>();
                //遍历一行数据
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    //获取列名作为key
                    String key = metaData.getColumnName(i + 1);
                    //获取列值作为value
                    Object value = resultSet.getObject(i + 1);
                    rowMap.put(key,value);
                }
                rowList.add(rowMap);
            }
            return rowList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
            connection = DriverManager.getConnection(url, user, password);
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
