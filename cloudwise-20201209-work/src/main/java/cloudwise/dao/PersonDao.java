package cloudwise.dao;
import cloudwise.entity.Sal;

import java.util.List;
import java.util.Map;


public interface PersonDao {
    List<Map<String,Object>> findAllPerson();
    List<Map<String,Object>> findAllPersonPage(int start,int pageSize);
    List<Map<String,Object>> findAllArea();
    Map<String,Object> findPersonById(String personid);
    void updatePersonInfo(String updatePersonid, String updatePersonname, String updatePersonareaid, String updatePersonage, String updatePersonaddress);
    void deletePersonById(String personId);
    long getRowCount();
    Map<String,Object> checkPersonName(String personName);

    List<Map<String,Object>> findEmp(Sal sal);
}
