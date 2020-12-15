package com.cloudwise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created on 2020/12/14 17:39
 * @description ：跳转Controller
 * @modified By：
 */
@Controller
public class GotoController {
    @RequestMapping("show")
    public String toShowAll(){
        return "showAll";
    }
}
