package work;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/29 15:23
 * @description ：JDBC工具类3
 * @modified By：
 */
public class JDBCUtils3 {
    static String url = "jdbc:mysql://localhost:3306/cloudwise?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String driver = "com.mysql.jdbc.Driver";
    static String user = "root";
    static String password = "qepwq";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean executeUpdate(String sql,Object ...objects){
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            setParam(ps,objects);
            int i = ps.executeUpdate();
            if (i > 1){
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
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            setParam(ps,objects);
            int i = ps.executeUpdate();
            if (i > 1){
                System.out.println("操作成功");
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

    public static List<Map<String,Object>> executeUpdateQuery(String sql,Object ...objects){
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            setParam(ps,objects);
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<Map<String,Object>> rowList = new ArrayList<>();
            while (resultSet.next()){
                Map<String,Object> rowMap  = new HashMap<>();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String key = metaData.getColumnName(i + 1);
                    Object value = resultSet.getObject(i + 1);
                    rowMap.put(key,value);
                }
                rowList.add(rowMap);
            }
            return rowList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(ps,connection,null);
        }
        return null;
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void setParam(PreparedStatement ps,Object[] objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i+1,objects[i]);
        }
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
