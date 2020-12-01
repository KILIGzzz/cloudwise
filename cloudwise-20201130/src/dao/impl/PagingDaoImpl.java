package dao.impl;

import dao.PagingDao;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/30 16:45
 * @description ：分页dao实现类
 * @modified By：
 */
public class PagingDaoImpl extends JDBCUtils implements PagingDao {
    @Override
    public List<Map<String, Object>> paging(int page, int count) {
        String sql = "select * from dept limit ?,?";
        int i = (page-1)*count;
        return executeQuery(sql,i,count);
    }
}
