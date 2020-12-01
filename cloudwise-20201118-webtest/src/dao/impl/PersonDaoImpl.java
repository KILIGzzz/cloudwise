package dao.impl;

import dao.PersonDao;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version :     1.0
 * @date ：Created in 2020/11/19 19:34
 * @description ：人员信息dao实现类
 * @modified By：
 */
public class PersonDaoImpl implements PersonDao {
    @Override
    public List<Map<String, Object>> findAllPerson() {
        String sql = "select * from personinfo p inner areainfo"
        return null;
    }
}
