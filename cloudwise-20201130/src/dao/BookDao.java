package dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/30 11:05
 * @description ：图书dao接口
 * @modified By：
 */
public interface BookDao {
    /**
     * @create by: IvanZ
     * @description : 查询所有
     * @create time: 2020/11/30 11:07
     * @param :
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> findAll();

    /**
     * @create by: IvanZ
     * @description : 根据isbn删除图书
     * @create time: 2020/11/30 11:08
     * @param :
     * @return void
     */
    boolean deleteByIsbn(int isbn);

    /**
     * @create by: IvanZ
     * @description : 查询小于库存上限的书
     * @create time: 2020/11/30 11:10
     * @param currcount:
     * @return int
     */
    int findLessCurrcount(int currcount);

    /**
     * @create by: IvanZ
     * @description : 根据出版社查询图书
     * @create time: 2020/11/30 11:12
     * @param publish:
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> findBookByPublish(String publish);

    /**
     * @create by: IvanZ
     * @description : 添加图书
     * @create time: 2020/11/30 14:30
     * @param map:
     * @return int
     */
    int insertBook(Map<String,Object> map);
}
