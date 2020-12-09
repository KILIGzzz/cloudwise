package cloudwise.service;

import java.util.List;
import java.util.Map;

/**
 * @create by: Teacher陈
 * @description: 人员信息dao接口
 * @create time: 2020/11/19 9:19
 */
public interface PersonService {
    List<Map<String, Object>> findAllPerson();
    List<Map<String,Object>> findAllPersonPage(Map map);
    List<Map<String, Object>> findAllArea();

    Map<String, Object> findPersonById(String personid);

    void updatePersonInfo(String updatePersonid, String updatePersonname, String updatePersonareaid, String updatePersonage, String updatePersonaddress);
    void deletePersonById(String personId);
    long getRowCount();
    boolean checkPersonName(String personName);
}
