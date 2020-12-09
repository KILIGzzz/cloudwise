package com.Ivan.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/9 11:05
 * @description ：获取sqlSession工具类
 * @modified By：
 */
public class MysqlSessionFactory {
    static String resource="mybatis-config.xml";
    static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * @create by: IvanZ
     * @description : 获取sqlSession的方法
     * @create time: 2020/12/9 11:22
     * @param :
     * @return org.apache.ibatis.session.SqlSession
     */
    public static SqlSession getSQLSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
