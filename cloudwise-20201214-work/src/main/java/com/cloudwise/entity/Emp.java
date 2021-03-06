package com.cloudwise.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2020-12-14 17:31:29
 */
@Data
public class Emp implements Serializable {
    private static final long serialVersionUID = 807843339816159733L;
    
    private Integer empno;
    
    private String ename;
    
    private String job;
    
    private Integer mgr;
    
    private String hiredate;
    
    private Double sal;
    
    private Double comm;
    
    private Integer deptno;
}