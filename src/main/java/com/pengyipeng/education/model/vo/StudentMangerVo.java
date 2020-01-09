package com.pengyipeng.education.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 庞冉
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/6 14:03 星期一
 */

@AllArgsConstructor
@NoArgsConstructor
public class StudentMangerVo {
    private int userid;
    private String phone;
    private String nickname;
    private String payment_status;
    private String sname;
    private int age;
    private Date birth;
    private Date registration_time;
    private int project_id;
    private int course_id;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public StudentMangerVo(String phone, String nickname, String payment_status, Date registration_time) {
        this.phone = phone;
        this.nickname = nickname;
        this.payment_status = payment_status;
        this.registration_time = registration_time;
    }

    public StudentMangerVo(String sname, int age, Date birth) {
        this.sname = sname;
        this.age = age;
        this.birth = birth;
    }
}
