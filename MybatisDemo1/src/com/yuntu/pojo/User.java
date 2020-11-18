package com.yuntu.pojo;

import java.util.Date;

public class User {
    private int id;
    private String userCode;
    private String userName;
    private String userPassword;
    private int gender;
    private Date birthday;
    private String phone;
    private String address;
    private int userRole;
    private Integer createdBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;

    //属性，get、set、有参无参，去id
    public User(String userCode, String userName, String userPassword, int gender, Date birthday, String phone, String address, int userRole, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public User(int id, String userCode, String userName, String userPassword, int gender, Date birthday, String phone, String address, int userRole, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getId() {
        return id;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getUserRole() {
        return userRole;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

}
