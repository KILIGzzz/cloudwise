package dao.impl;

import dao.UserDao;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 18:31
 * @description ：用户Dao接口实现类
 * @modified By：
 */
public class UserDaoImpl extends JDBCUtils implements UserDao {
    @Override
    public List<Map<String, Object>> findAll() {
        String sql = "select * from emp";
        return executeQuery(sql);
    }

    @Override
    public List<Map<String, Object>> findAllPersonPage(Map map) {
        String sql="select e.*,d.dname from emp e inner join dept d on e.DEPTNO = d.deptid limit  ?,?";
        int pageSize=Integer.parseInt(map.get("pageSize").toString());
        int pageNo=Integer.parseInt(map.get("pageNo").toString());
        int  start=(pageNo-1)*(pageSize);
        return executeQuery(sql,start,pageSize);
    }


    @Override
    public long getRowCount() {
        String sql="select count(*)  mycount from emp";
        List<Map<String, Object>> mapList = executeQuery(sql);
        if(mapList!=null&&mapList.size()>0){
            Map<String, Object> map = mapList.get(0);
            Object mycount = map.get("mycount");
            long count=Long.parseLong(mycount.toString());
            return count;
        }
        return 0;
    }
}
