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
    public List<Map<String, Object>> findAllPersonPage(Map map) {
        return userDao.findAllPersonPage(map);
    }

    @Override
    public long getRowCount() {
        return userDao.getRowCount();
    }

}
