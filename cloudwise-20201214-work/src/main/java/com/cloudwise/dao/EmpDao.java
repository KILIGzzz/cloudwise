package com.cloudwise.dao;

import com.cloudwise.entity.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Emp)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-14 17:31:30
 */
public interface EmpDao {

    /**
     * 通过ID查询单条数据
     *
     * @param empno 主键
     * @return 实例对象
     */
    Emp queryById(Integer empno);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Emp> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param emp 实例对象
     * @return 对象列表
     */
    List<Emp> queryAll(Emp emp);

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 影响行数
     */
    int insert(Emp emp);

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 影响行数
     */
    int update(Emp emp);

    /**
     * 通过主键删除数据
     *
     * @param empno 主键
     * @return 影响行数
     */
    int deleteById(Integer empno);

    /**
     * @create by: IvanZ
     * @description : 获取行数
     * @create time: 2020/12/14 17:54
     * @param :
     * @return long
     */
    long getCount();

}