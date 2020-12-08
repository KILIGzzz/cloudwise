package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 18:32
 * @description ：用户Service实现类
 * @modified By：
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<Map<String, Object>> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<Map<String, Object>> findByUser(String username, String password) {
        return userDao.findByUser(username,password);
    }

    @Override
    public void insert(String insertUserName, String insertPassword, String insertPhone, String insertUserDeptId) {
        userDao.insert(insertUserName, insertPassword, insertPhone, insertUserDeptId);
    }


    @Override
    public Map<String, Object> findPersonById(String personid) {
        return userDao.findPersonById(personid);
    }


    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void update(String updateUserId, String updateUserName, String updatePassword, String updatePhone, String updateUserDeptId) {
        userDao.update(updateUserId,updateUserName,updatePassword,updatePhone,updateUserDeptId);
    }


    @Override
    public List<Map<String, Object>> findAllDept() {
        return userDao.findAllDept();
    }

    @Override
    public boolean checkUserName(String updateUserName) {
        return userDao.checkUserName(updateUserName);
    }
}
