package com.Ivan.entity;


import java.sql.Timestamp;

public class Usersinfo {

  private long id;
  private String username;
  private String password;
  private String phone;
  private long deptid;
  private java.sql.Timestamp createtime;

  public Usersinfo(long id, String username, String password, String phone, long deptid, Timestamp createtime) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.phone = phone;
    this.deptid = deptid;
    this.createtime = createtime;
  }

  public Usersinfo() {
  }

  @Override
  public String toString() {
    return "Usersinfo{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", phone='" + phone + '\'' +
            ", deptid=" + deptid +
            ", createtime=" + createtime +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getDeptid() {
    return deptid;
  }

  public void setDeptid(long deptid) {
    this.deptid = deptid;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

}
