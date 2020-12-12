package com.Ivan.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2020-12-11 15:24:36
 */
@Data
public class Emp implements Serializable {

    private Integer empno;
    
    private String ename;
    
    private String job;
    
    private Integer mgr;
    
    private String hiredate;
    
    private Double sal;
    
    private Double comm;
    
    private Integer deptno;


}