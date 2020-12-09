import com.Ivan.dao.UserDao;
import com.Ivan.entity.Usersinfo;
import com.Ivan.util.MysqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = null;
    SqlSession sqlSession = null;
    @Before
    public void setUp() throws Exception {
        sqlSession = MysqlSessionFactory.getSQLSession();
        userDao =sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void findAll() {
        List<Usersinfo> all = userDao.findAll();
        for (Usersinfo usersinfo : all) {
            System.out.println(usersinfo);
        }
    }

    @Test
    public void insertUser() {
        Usersinfo usersinfo = new Usersinfo(0,"Ivan4","qepwq","123456789",20,null);
        userDao.insertUser(usersinfo);
        sqlSession.commit();
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(8);
        sqlSession.commit();
    }

    @Test
    public void updateUserById() {
        Usersinfo usersinfo = new Usersinfo(8,"Ivan5","qepwq","123456789000",20,null);
        userDao.updateUserById(usersinfo);
        sqlSession.commit();
    }

    @Test
    public void findById() {
        Usersinfo byId = userDao.findById(1);
        System.out.println(byId);
    }
}