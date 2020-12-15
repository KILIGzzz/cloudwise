package com.cloudwise.controller;

import com.cloudwise.entity.Emp;
import com.cloudwise.entity.PageBean;
import com.cloudwise.entity.ReturnBean;
import com.cloudwise.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2020-12-14 17:31:31
 */
@RestController
@RequestMapping("emp")
public class EmpController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Emp selectOne(Integer id) {
        return this.empService.queryById(id);
    }

    @GetMapping("findAll")
    public ReturnBean findAll(PageBean pageBean){
        List<Emp> emps = empService.queryAllByLimit(getOffset(pageBean), pageBean.getLimit());
        long count = empService.getCount();
        ReturnBean returnBean = returnSuccess(emps, count);
        return returnBean;
    }

    @RequestMapping("saveUser")
    public ReturnBean saveUser(Emp emp){
        try {
            Emp insert = empService.insert(emp);
            return returnSuccess(insert);
        }catch (Exception e){
            return returnFail(null);
        }
    }

    @RequestMapping("deleteById")
    public ReturnBean deleteById(Integer empno){
        System.out.println(empno);
        boolean b = empService.deleteById(empno);
        if (b){
            return returnSuccess(null);
        }
        return returnFail(null);
    }

    @RequestMapping("updateUser")
    public ReturnBean updateUser(Emp emp){
        System.out.println(emp);
        Emp update = empService.update(emp);
        if (update != null){
            return returnSuccess(null);
        }
        return returnFail(null);
    }
}