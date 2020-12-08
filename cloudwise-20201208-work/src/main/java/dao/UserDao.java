package dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 18:31
 * @description ：用户Dao接口
 * @modified By：
 */
public interface UserDao {
    /**
     * @create by: IvanZ
     * @description : 查询所有
     * @create time: 2020/12/4 18:49
     * @param : 
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> findAll();


    List<Map<String, Object>> findAllPersonPage(Map map);

    long getRowCount();
}
