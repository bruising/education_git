package com.pengyipeng.education.model.vo;

public class ProStuUserVO {
    /**
     *@author 牛岩松
     * @version V1.0
     * @Project: education
     * @Package com.pengyipeng.education.Model
     * @date 2020/1/8 21:28 星期日
     * 项目和学生和用户的vo实体类
     */
    private Integer sid;
    private String sname;
    private Integer age;
    private String phone;
    private String nickname;
    private Integer updateProjectCount;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Integer getUpdateProjectCount() {
        return updateProjectCount;
    }

    public void setUpdateProjectCount(Integer updateProjectCount) {
        this.updateProjectCount = updateProjectCount;
    }

    public ProStuUserVO(Integer sid, String sname, Integer age, String phone, String nickname, Integer updateProjectCount) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.phone = phone;
        this.nickname = nickname;
        this.updateProjectCount = updateProjectCount;
    }

    public ProStuUserVO() {
    }
}
