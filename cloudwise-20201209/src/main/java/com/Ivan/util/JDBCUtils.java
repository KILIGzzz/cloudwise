package com.Ivan.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/9 9:29
 * @description ：
 * @modified By：
 */
public class JDBCUtils {
    static String url = "jdbc:mysql://localhost:3306/cloudwise?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String driver = "com.mysql.jdbc.Driver";
    static String user = "root";
    static String password = "qepwq";

    static {
        try {
            //加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @create by: IvanZ
     * @description : 通用增删改
     * @create time: 2020/12/9 9:42
     * @param sql:
 * @param objects:
     * @return boolean
     */
    public static boolean executeUpdate(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql);
            //设置参数
            setParam(ps,objects);
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
            //关闭所有连接
            closeAll(ps,connection,null);
        }
        return false;
    }

    /**
     * @create by: IvanZ
     * @description : 通用增删改，并返回主键值
     * @create time: 2020/12/9 9:46
     * @param sql:
 * @param objects:
     * @return java.lang.Integer
     */
    public static Integer executeUpdateRetPk(String sql,Object ...objects){
        //获取连接
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            //获取执行sql的对象
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //设置参数
            setParam(ps,objects);
            int i = ps.executeUpdate();
            if (i > 0){
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
            //关闭所有连接
            closeAll(ps,connection,null);
        }
        return null;
    }

    /**
     * @create by: IvanZ
     * @description : 通用查询
     * @create time: 2020/12/9 9:46
     * @param sql:
 * @param objects:
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
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
            resultSet = ps.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<Map<String,Object>> rowList = new ArrayList<>();
            while (resultSet.next()){
                Map<String,Object> rowMap = new HashMap<>();
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
            //关闭所有连接
            closeAll(ps,connection,null);
        }
        return null;
    }

    /**
     * @create by: IvanZ
     * @description : 获取连接
     * @create time: 2020/12/9 9:37
     * @param :
     * @return java.sql.Connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @create by: IvanZ
     * @description : 设置参数
     * @create time: 2020/12/9 9:34
     * @param :
     * @return void
     */
    public static void setParam(PreparedStatement ps,Object[] objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i+1,objects[i]);
        }
    }

    /**
     * @create by: IvanZ
     * @description : 关闭所有连接
     * @create time: 2020/12/9 9:34
     * @param ps:
 * @param connection:
 * @param resultSet:
     * @return void
     */
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
