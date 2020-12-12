package com.Ivan.entity;

import lombok.Data;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created on 2020/12/12 20:37
 * @description ：带人员部门名称的实体类
 * @modified By：
 */
@Data
public class EmpDept {
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private String hiredate;

    private Double sal;

    private Double comm;

    private Integer deptno;

    private String dname;


}
