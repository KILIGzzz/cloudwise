package com.Ivan.service.impl;

import com.Ivan.entity.Dept;
import com.Ivan.entity.Emp;
import com.Ivan.dao.EmpDao;
import com.Ivan.entity.EmpDept;
import com.Ivan.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Emp)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 15:24:36
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;

    /**
     * 通过ID查询单条数据
     *
     * @param empno 主键
     * @return 实例对象
     */
    @Override
    public Emp queryById(Integer empno) {
        return this.empDao.queryById(empno);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Emp> queryAllByLimit(int offset, int limit) {
        return this.empDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return int
     */
    @Override
    public int insert(Emp emp) {
        return empDao.insert(emp);
    }

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public Emp update(Emp emp) {
        this.empDao.update(emp);
        return this.queryById(emp.getEmpno());
    }

    /**
     * 通过主键删除数据
     *
     * @param empno 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer empno) {
        return this.empDao.deleteById(empno) > 0;
    }

    @Override
    public List<EmpDept> findAll(Map map) {
        return empDao.findAll(map);
    }

    @Override
    public int totalCount() {
        return empDao.totalCount();
    }

    @Override
    public List<String> findJob() {
        return empDao.findJob();
    }

    @Override
    public List<Dept> findDept() {
        return empDao.findDept();
    }

    @Override
    public List<EmpDept> findByCondition(Integer empno, String ename) {
        Map<String,Object> map = new HashMap<>();
        map.put("empno",empno);
        map.put("ename",ename);
        return empDao.findByCondition(map);
    }
}