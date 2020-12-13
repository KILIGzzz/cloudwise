package com.Ivan.controller;

import com.Ivan.entity.Dept;
import com.Ivan.entity.Emp;
import com.Ivan.entity.EmpDept;
import com.Ivan.entity.ReturnBean;
import com.Ivan.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2020-12-11 15:24:36
 */
@Controller
@RequestMapping("emp")
public class EmpController {
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;

    final int PAGE_NO = 1;
    final int PAGE_SIZE = 5;
    Map<String, Object> map = new HashMap<>();

    @RequestMapping("findAll")
    @ResponseBody
    public ReturnBean findAllEmp(Integer empno, String ename, HttpServletRequest req) {
        if (empno != null || !"".equals(ename)) {
            System.out.println("条件");
            List<EmpDept> emps = empService.findByCondition(empno, ename);
            ReturnBean returnBean = new ReturnBean();
            returnBean.setCode(0);
            returnBean.setData(emps);
            returnBean.setCount(emps.size());
            return returnBean;
        } else {
            int pageNo = 0;
            int pageSize = 0;
            if (req.getParameter("page") != null && req.getParameter("limit") != null) {
                //如果前端页面传入分页参数，使用前端页面的分页参数
                pageNo = Integer.parseInt(req.getParameter("page"));
                pageSize = Integer.parseInt(req.getParameter("limit"));
            } else {
                //如果前端没有传入分页参数，使用系统默认
                pageNo = PAGE_NO;
                pageSize = PAGE_SIZE;
            }
            int start = (pageNo - 1) * pageSize;
            map.put("start", start);
            map.put("pageSize", pageSize);
            List<EmpDept> emps = empService.findAll(map);
            long count = empService.totalCount();
            //将map转换成json字符串
            ReturnBean returnBean = new ReturnBean();
            returnBean.setCode(0);
            returnBean.setData(emps);
            returnBean.setCount((int) count);
            return returnBean;
        }
    }

    @RequestMapping("toAdd")
    public ModelAndView toAdd() {
        ModelAndView mv = new ModelAndView();
        List<String> jobs = empService.findJob();
        List<Dept> depts = empService.findDept();
        mv.addObject("jobs", jobs);
        mv.addObject("depts", depts);
        mv.setViewName("add");
        return mv;
    }

    @RequestMapping("add")
    public String add(Emp emp) {
        empService.insert(emp);
        return "redirect:/index.jsp";
    }

    @RequestMapping("toUpdate")
    @ResponseBody
    public String toUpdate(Emp emp1, HttpServletRequest request) {
//        System.out.println(emp1);
//        ModelAndView mv = new ModelAndView();
        List<String> jobs = empService.findJob();
        List<Dept> depts = empService.findDept();
        Emp emp = empService.queryById(emp1.getEmpno());
        HttpSession session = request.getSession();
        session.setAttribute("jobs", jobs);
        session.setAttribute("depts", depts);
        session.setAttribute("emp", emp);
//        mv.addObject("jobs",jobs);
//        mv.addObject("depts",depts);
//        mv.addObject("emp",emp);
//        mv.setViewName("update");
//        return mv;
        return "update";
    }

    @RequestMapping("update")
    public String update(Emp emp) {
        System.out.println(emp);
        empService.update(emp);
        return "redirect:/index.jsp";
    }

    @RequestMapping("delete")
    public String delete(Emp emp) {
        System.out.println(emp);
        empService.deleteById(emp.getEmpno());
        return "redirect:/index.jsp";
    }

    @RequestMapping("findByCondition")
    public String findByCondition(Integer empno,String ename,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("empno",empno);
        session.setAttribute("ename",ename);
        return "redirect:/index.jsp";
    }
}