package dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @date ：Created in 2020/11/19 19:03
 * @description 人员信息dao接口
 * @modified By：
 * @version 1.0
 */
public interface PersonDao {
    /**
     * @create by: IvanZ
     * @description : 查询所有人员信息
     * @create time: 2020/11/19 19:42
     * @return 返回list
     */
    public List<Map<String,Object>> findAllPerson();
}
