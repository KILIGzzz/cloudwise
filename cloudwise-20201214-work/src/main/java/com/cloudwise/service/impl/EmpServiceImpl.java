package com.cloudwise.service.impl;

import com.cloudwise.entity.Emp;
import com.cloudwise.dao.EmpDao;
import com.cloudwise.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Emp)表服务实现类
 *
 * @author makejava
 * @since 2020-12-14 17:31:31
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
     * @param limit  查询条数
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
     * @return 实例对象
     */
    @Override
    public Emp insert(Emp emp) {
        this.empDao.insert(emp);
        return emp;
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
    public long getCount() {
        return empDao.getCount();
    }
}