package com.yyq.doormanage1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    private String account;
    private String username;
    private String password;
    private Integer sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String phone;
    private Integer type;
    private Integer status;
    private String wechatId;
    private String token;
    private String Session_key;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;

    private List<Room> list;

    public List<Room> getList() {
        return list;
    }

    public void setList(List<Room> list) {
        this.list = list;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSession_key() {
        return Session_key;
    }

    public void setSession_key(String session_key) {
        Session_key = session_key;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
