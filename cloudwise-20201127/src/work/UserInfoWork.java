package work;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/27 21:07
 * @description ：用户信息表增删改查
 * @modified By：
 */
public class UserInfoWork {
    public static void main(String[] args) {
        String sql1 = "insert into userinfo values(?,?,?,now())";
        String sql2 = "delete from userinfo where id = ?";
        String sql3 = "update userinfo set password = ? where id = ?";
        String sql4 = "select * from userinfo";
//        //添加数据
//        Integer integer = JDBCUtils.executeUpdateRetPk(sql1, null, "Ivan", "qepwq");
//        System.out.println(integer);
//
//        //删除数据
//        JDBCUtils.executeUpdate(sql2,3);
//
//        //修改数据
//        JDBCUtils.executeUpdate(sql3,"123456",1);

        //查询数据
        List<Map<String, Object>> list = JDBCUtils1.executeQuery(sql4);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
}
