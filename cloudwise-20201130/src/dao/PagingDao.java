package dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/30 16:45
 * @description ：分页dao接口
 * @modified By：
 */
public interface PagingDao {
    /**
     * @create by: IvanZ
     * @description : 输入第几页和每页显示条数，输出表中数据
     * @create time: 2020/11/30 16:46
     * @param page:
 * @param count:
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> paging(int page,int count);
}
