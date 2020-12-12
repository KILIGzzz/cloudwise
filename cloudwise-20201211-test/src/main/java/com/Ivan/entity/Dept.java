package com.Ivan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2020-12-11 10:57:10
 */
@Data
@AllArgsConstructor
public class Dept implements Serializable {
    private static final long serialVersionUID = 497138154743446624L;
    
    private Integer deptid;
    
    private String dname;
    
    private String loc;


    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}