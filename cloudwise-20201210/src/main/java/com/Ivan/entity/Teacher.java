package com.Ivan.entity;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created on 2020/12/10 14:59
 * @description ：教师类
 * @modified By：
 */
@Log
@Component
public class Teacher {
    @Value("1")
    int id;
    @Value("陈建")
    String name;

    public void introduce(){
        log.info("我的工号是"+id+"，我的名字是"+name+"，是老师！");
    }
    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
