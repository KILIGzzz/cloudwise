package util;

import cn.hutool.core.util.StrUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Teacher陈
 * @date ：Created in 2020/9/29 9:47
 * @description：所有的dao实现类的基类
 * @modified By：
 * @version: 1.0
 */
public class BaseDao {
    /**
     * 四大金刚
     */
    static String url = "jdbc:mysql://localhost:3306/cloudwise?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static String driver = "com.mysql.jdbc.Driver";
    static String user = "root";
    //static String password = "123456Admin@123";
    static String password = "root";
    /**
     * @create by: Teacher陈
     * @description: 加载驱动
     * @create time: 2020/9/29 9:49
     * @param null
     * @return
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * @create by: Teacher陈
     * @description: 获取数据库连接
     * @create time: 2020/9/29 9:49
     * @return connection
     */
    public static Connection getConnection(){
        Connection connection=null;
        try {
             connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * @create by: Teacher陈
     * @description: 关闭数据库连接
     * @create time: 2020/9/29 9:49
     * @param connection  ps resultSet
     * @return
     */
    public static void closeAll(Connection connection, PreparedStatement ps, ResultSet resultSet){

        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * @create by: Teacher陈
     * @description: 增删改数据库数据
     * @create time: 2020/9/29 9:49
     * @param sql,objects
     * @return boolean
     */
    public static boolean executeUpdate(String sql,Object ...objects){
        Connection connection = getConnection();
        PreparedStatement ps=null;
        try {
            //获取PreparedStatement对象
             ps = connection.prepareStatement(sql);
             //设置参数
            //设置参数
            ps = setParam(ps, objects);
            //72行的ps对象存在占位符？，76行设置完参数之后，占位符被替换成具体的参数。
            int i = ps.executeUpdate();
            //i是受影响的行数
            if(i>0){
                System.out.println("操作成功");
                return true;
            }else
            {
                System.out.println("操作失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            closeAll(connection,ps,null);
        }
        return false;
    }
    /**
     * @create by: Teacher陈
     * @description: 增删改数据库数据,返回主键
     * @create time: 2020/9/29 9:49
     * @param sql,objects
     * @return boolean
     */
    public static Integer executeUpdateRetKey(String sql,Object ...objects){

        Connection connection = getConnection();
        PreparedStatement ps=null;
        try {
            //获取PreparedStatement对象
            ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //设置参数
            //设置参数
            ps = setParam(ps, objects);
            //72行的ps对象存在占位符？，76行设置完参数之后，占位符被替换成具体的参数。
            int i = ps.executeUpdate();
            //i是受影响的行数
            if(i>0){
                System.out.println("操作成功");
                ResultSet resultSet = ps.getGeneratedKeys();
                Integer key=null;
                if(resultSet.next()){
                     key = resultSet.getInt(1);
                }
                return key;
            }else
            {
                System.out.println("操作失败");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            closeAll(connection,ps,null);
        }
        return null;
    }
    /**
     * @create by: Teacher陈
     * @description: 查询数据库数据
     * @create time: 2020/9/29 9:49
     * @param  sql objects
     * @return rowList
     */

    public static List<Map<String,Object>>  executeQuery(String sql,Object ...objects){
        System.out.println(sql);
        Connection connection = getConnection();
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        List<Map<String,Object>> rowList= new ArrayList();
        try {
            //获取PreparedStatement对象
            ps = connection.prepareStatement(sql);
            //设置参数
            ps = setParam(ps, objects);
            //72行的ps对象存在占位符？，76行设置完参数之后，占位符被替换成具体的参数。
             resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()){
                //开始封装一行数据
                Map<String,Object> row= new HashMap();
                //遍历一行数据的所有的列
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    //获取列名
                    String columnName=metaData.getColumnName(i+1);
                    //按照列的顺序，获取列值
                    Object columnValueByIndex = resultSet.getObject(i + 1);
                    //按照列名获取列值
                    Object columnValueByName = resultSet.getObject(columnName);
                    row.put(columnName,columnValueByName);
                }

                rowList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            closeAll(connection,ps,resultSet);
        }
        return rowList;
    }
    /**
     * @create by: Teacher陈
     * @description: 拼接带条件的sql语句
     * @create time: 2020/11/19 9:17
     * @param map oldSql   objects
     * @return
     */
    public static List<Map<String,Object>>  executeQueryCondition(Map<String,String> map,String oldSql,Object ...objects){
        Map<String,String> whereCondtion= new HashMap();
        StringBuffer sql=new StringBuffer(oldSql);
        sql.append("where 1=1 ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getKey().contains("search_")){
                whereCondtion.put(entry.getKey().replace("search_",""),entry.getValue());
            }
        }
        for (Map.Entry condition : whereCondtion.entrySet()) {
            sql.append( " and "+condition.getKey()+" like '%"+condition.getValue()+"%' ");
        }
        //如果有排序，拼写排序sql
        String field=map.get("field");
        String order=map.get("order");
        if(StrUtil.isNotEmpty(field)){
            sql.append(" order by "+field +" "+ order);
        }
        //如果有分页，拼写分页的sql
        //String sql="select * from userinfo  order by "+field +" "+ order +" limit "+start+" , "+limit;
        if(StrUtil.isNotEmpty(map.get("page"))&&StrUtil.isNotEmpty(map.get("limit"))){
            int page= Integer.parseInt(map.get("page"));
            int limit = Integer.parseInt(map.get("limit"));
            int start=(page-1)*limit;
            sql.append(" limit "+start+" , "+limit);
        }
        Connection connection = getConnection();
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        List<Map<String,Object>> rowList= new ArrayList();
        try {
            //获取PreparedStatement对象
            ps = connection.prepareStatement(sql.toString());
            //设置参数
            ps = setParam(ps, objects);
            //72行的ps对象存在占位符？，76行设置完参数之后，占位符被替换成具体的参数。
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()){
                //开始封装一行数据
                Map<String,Object> row= new HashMap();
                //遍历一行数据的所有的列
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    //获取列名
                    String columnName=metaData.getColumnName(i+1);
                    //按照列的顺序，获取列值
                    Object columnValueByIndex = resultSet.getObject(i + 1);
                    //按照列名获取列值
                    Object columnValueByName = resultSet.getObject(columnName);
                    row.put(columnName,columnValueByName);
                }

                rowList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            closeAll(connection,ps,resultSet);
        }
        return rowList;
    }

    /**
     * @create by: Teacher陈
     * @description: 设置参数
     * @create time: 2020/9/29 10:19
     * @param ps  objects
     * @return PreparedStatement
     */
    public static PreparedStatement setParam(PreparedStatement ps ,Object ...objects){
        if(null!=objects){
            for (int i = 0; i < objects.length; i++) {
                try {
                    ps.setObject((i+1),objects[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ps;
    }

    public static void main(String[] args) {
       /* String sql="select * from emp where empno=?";
        List<Map<String, Object>> mapList = executeQuery(sql,7935);
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }*/
       String sql="insert into dept values(?,?,?)";
       executeUpdate(sql,46,"行政部","杨金路");
    }

}
