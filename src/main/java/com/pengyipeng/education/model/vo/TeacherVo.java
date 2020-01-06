package com.pengyipeng.education.model.vo;

import java.util.Date;
import java.util.List;

/**
 * @author 胡婷婷
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/6 15:03 星期一
 */
public class TeacherVo {

    private Integer status;
    private String tid, tname, phone, email, info;
    private Date registration_time;
    private List<String> cnames;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
    }

    public List<String> getCnames() {
        return cnames;
    }

    public void setCnames(List<String> cnames) {
        this.cnames = cnames;
    }
}
