package com.pengyipeng.education.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 宁坤
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.entity.User_Manager
 * @Description:用户管理类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Manager {
    //用户ID
    private Integer userid;
    //用户头像
    private String user_photo;
    //用户密码
    private String pwd;
    //用户手机号
    private String phone;
    //用户昵称
    private String nickname;
    //用户邮箱
    private String email;
    //用户付费状态
    private Integer payment_status;
    //用户最近登录时间
    private String latest_login_time;
    //用户最近付费时间
    private String latest_payment_time;
    //用户注册时间
    private String registration_time;
    //md5加密密码
    private String md5pwd;

    public String getMd5pwd() {
        return md5pwd;
    }

    public void setMd5pwd(String md5pwd) {
        this.md5pwd = md5pwd;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Integer payment_status) {
        this.payment_status = payment_status;
    }

    public String getLatest_login_time() {
        return latest_login_time;
    }

    public void setLatest_login_time(String latest_login_time) {
        this.latest_login_time = latest_login_time;
    }

    public String getLatest_payment_time() {
        return latest_payment_time;
    }

    public void setLatest_payment_time(String latest_payment_time) {
        this.latest_payment_time = latest_payment_time;
    }

    public String getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(String registration_time) {
        this.registration_time = registration_time;
    }

    public User_Manager(Integer userid, String pwd) {
        this.userid = userid;
        this.pwd = pwd;
    }
}
