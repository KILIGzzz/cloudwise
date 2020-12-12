package com.Ivan.controller;

import com.Ivan.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2020-12-11 10:57:11
 */
@Controller
public class DeptController {
    @RequestMapping("/toHelloPage")
    public String toHelloPage(HttpSession session, Dept dept){
        /*  Dept dept= new Dept(111,"国防部","郑州");*/
        session.setAttribute("dept",dept);
        return "hello";
    }

    @RequestMapping("/getJson")
    @ResponseBody
    public Dept getJson(){
        Dept dept= new Dept(111,"国防部","郑州");
        return dept;
    }

}