package com.Ivan.dao;

import com.Ivan.entity.Usersinfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/9 11:02
 * @description ：
 * @modified By：
 */
public interface UserDao {
    List<Usersinfo> findAll();
    void insertUser(Usersinfo usersinfo);
    void deleteUserById(int id);
    void updateUserById(Usersinfo usersinfo);
    Usersinfo findById(int id);
}
