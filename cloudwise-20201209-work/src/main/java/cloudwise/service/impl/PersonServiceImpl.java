package cloudwise.service.impl;

import cloudwise.dao.PersonDao;
import cloudwise.service.PersonService;
import cloudwise.util.MysqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;


public class PersonServiceImpl implements PersonService {
    SqlSession sqlSession = MysqlSessionFactory.getSQLSession();
    PersonDao personDao = sqlSession.getMapper(PersonDao.class);

    @Override
    public List<Map<String, Object>> findAllPerson() {
        return personDao.findAllPerson();
    }

    @Override
    public List<Map<String, Object>> findAllPersonPage(Map map) {
        int pageSize=Integer.parseInt(map.get("pageSize").toString());
        int pageNo=Integer.parseInt(map.get("pageNo").toString());
        int start=(pageNo-1)*(pageSize);
        return personDao.findAllPersonPage(start,pageSize);
    }

    @Override
    public List<Map<String, Object>> findAllArea() {
        return personDao.findAllArea();
    }

    @Override
    public Map<String, Object> findPersonById(String personid) {
        Map<String, Object> map = personDao.findPersonById(personid);
        if (map != null) {
            return map;
        }
        return null;
    }

    @Override
    public void updatePersonInfo(String updatePersonid, String updatePersonname, String updatePersonareaid, String updatePersonage, String updatePersonaddress) {
        personDao.updatePersonInfo(updatePersonid, updatePersonname, updatePersonareaid, updatePersonage, updatePersonaddress);
        sqlSession.commit();
    }

    @Override
    public void deletePersonById(String personId) {
        personDao.deletePersonById(personId);
        sqlSession.commit();
    }

    @Override
    public long getRowCount() {
        return personDao.getRowCount();
    }

    /**
     * @create by: Teacher陈
     * @description: 校验用户名是否合法，如果可以用，返回true，不能用（重复）返回false
     * @create time: 2020/12/1 15:44
     * @param personName
     * @return boolean
     */
    @Override
    public boolean checkPersonName(String personName) {
        Map<String, Object> map = personDao.checkPersonName(personName);
        if(map!=null){
            return false;
        }
        return true;
    }
}
