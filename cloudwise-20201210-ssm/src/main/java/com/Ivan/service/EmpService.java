package com.Ivan.service;

import com.Ivan.entity.Dept;
import com.Ivan.entity.Emp;
import com.Ivan.entity.EmpDept;

import java.util.List;
import java.util.Map;

/**
 * (Emp)表服务接口
 *
 * @author makejava
 * @since 2020-12-11 15:24:36
 */
public interface EmpService {

    /**
     * 通过ID查询单条数据
     *
     * @param empno 主键
     * @return 实例对象
     */
    Emp queryById(Integer empno);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Emp> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    int insert(Emp emp);

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    Emp update(Emp emp);

    /**
     * 通过主键删除数据
     *
     * @param empno 主键
     * @return 是否成功
     */
    boolean deleteById(Integer empno);

    List<EmpDept> findAll(Map map);

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