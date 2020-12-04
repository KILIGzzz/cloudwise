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
        String sql = "select * from usersinfo";
        return executeQuery(sql);
    }

    @Override
    public List<Map<String, Object>> findByUser(String username, String password) {
        String sql = "select * from usersinfo where username = ? and password = ?";
        return executeQuery(sql,username,password);
    }

    @Override
    public void insert(String insertUserName, String insertPassword, String insertPhone, String insertUserDeptId) {
        String sql = "insert into usersinfo values(null,?,?,?,?,now())";
        executeUpdate(sql,insertUserName,insertPassword,insertPhone,insertUserDeptId);
    }

    @Override
    public Map<String, Object> findPersonById(String personid) {
        String sql = "select * from usersinfo where id=?";
        List<Map<String, Object>> maps = executeQuery(sql, personid);
        if (maps != null && maps.size() > 0) {
            return maps.get(0);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from usersinfo where id = ?";
        executeUpdate(sql,id);
    }

    @Override
    public void update(String updateUserId,String updateUserName, String updatePassword, String updatePhone, String updateUserDeptId) {
        String sql = "update usersinfo set username = ?,password = ?,phone = ?,deptid = ? where id = ?";
        executeUpdate(sql,updateUserName,updatePassword,updatePhone,updateUserDeptId,updateUserId);
    }

    @Override
    public List<Map<String, Object>> findAllDept() {
        String sql = "select * from dept";
        return executeQuery(sql);
    }

    @Override
    public boolean checkUserName(String updateUserName) {
        String sql="select * from usersinfo where username=?";
        List<Map<String, Object>> mapList = executeQuery(sql, updateUserName);
        if(mapList!=null&&mapList.size()>0){
            return false;
        }
        return true;
    }
}
