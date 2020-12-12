package com.Ivan.entity;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created on 2020/12/10 14:59
 * @description ：学生类
 * @modified By：
 */
@Log
@Component
public class Student {
    @Value("1")
    int id;
    @Value("Ivan")
    String name;
    //优先按照类型注入
//    @Autowired
//    @Qualifier("teacher")
    //等同于上面两个结合
    @Resource(name="teacher")
    Teacher teacher;

    public void introduce(){
        log.info("我的学号是"+id+"，我的名字是"+name+"，是学生！，我的老师是"+teacher.name);
    }

    public Student() {
    }

    public Student(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
