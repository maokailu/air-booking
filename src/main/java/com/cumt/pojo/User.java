package com.cumt.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2018-05-13.
 */
public class User {
    private long id;
    private String userId;
    private String userName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String password;
    private String gender;
    private String phone;

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String idCardNumber;
    private Timestamp birthday;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
}
