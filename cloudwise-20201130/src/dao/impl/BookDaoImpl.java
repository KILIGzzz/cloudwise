package dao.impl;

import dao.BookDao;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/30 11:05
 * @description ：图书dao实现类
 * @modified By：
 */
public class BookDaoImpl extends JDBCUtils implements BookDao {
    @Override
    public List<Map<String, Object>> findAll() {
        String sql = "select * from book";
        return executeQuery(sql);
    }

    @Override
    public boolean deleteByIsbn(int isbn) {
        String sql = "delete from book where isbn = ?";
        return executeUpdate(sql,isbn);
    }

    @Override
    public int findLessCurrcount(int currcount) {
        String sql = "select * from book where currcount < ?";
        List<Map<String, Object>> list = executeQuery(sql,currcount);
        return list.size();
    }

    @Override
    public List<Map<String, Object>> findBookByPublish(String publish) {
        String sql = "select * from book where publish = ?";
        return executeQuery(sql,publish);
    }

    @Override
    public int insertBook(Map<String, Object> map) {
        String sql = "insert into book values(null,?,?,?,?,?)";
        return executeUpdateRetPk(sql,map.get("name"),map.get("author"),map.get("publish"),map.get("price"),map.get("currcount"));
    }
}
