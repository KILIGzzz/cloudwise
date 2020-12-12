package com.Ivan.dao;

import com.Ivan.entity.Dept;
import com.Ivan.entity.Emp;
import com.Ivan.entity.EmpDept;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Emp)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 15:24:36
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
     * @description : 查询所有
     * @create time: 2020/12/11 22:34
     * @param map:
     * @return java.util.List<com.Ivan.entity.Emp>
     */
    List<EmpDept> findAll(Map map);

    /**
     * @create by: IvanZ
     * @description : 一共多少条数据
     * @create time: 2020/12/11 22:34
     * @param :
     * @return int
     */
    int totalCount();

    /**
     * @create by: IvanZ
     * @description : 找到所有工作
     * @create time: 2020/12/11 22:39
     * @param :
     * @return java.util.List<java.lang.String>
     */
    List<String> findJob();

    /**
     * @create by: IvanZ
     * @description : 找到所有部门
     * @create time: 2020/12/11 22:39
     * @param :
     * @return java.util.List<java.lang.String>
     */
    List<Dept> findDept();
}