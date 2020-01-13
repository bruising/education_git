package com.pengyipeng.education.model.vo;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/11 15:24 星期六
 * 自己用的只有需要的字段
 */
public class CourseStudentUserVo {
    private String userid;
    private String phone;
    private String courseId;
    private String sname;
    private String age;
    private String courseProgress;
    private String paymentMethod;
    private String paymentPrice;
    private String registrationTime;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourseProgress() {
        return courseProgress;
    }

    public void setCourseProgress(String courseProgress) {
        this.courseProgress = courseProgress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(String paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }


    @Override
    public String toString() {
        return "CourseStudentUserVo{" +
                "userid='" + userid + '\'' +
                ", phone='" + phone + '\'' +
                ", courseId='" + courseId + '\'' +
                ", sname='" + sname + '\'' +
                ", age='" + age + '\'' +
                ", courseProgress='" + courseProgress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentPrice='" + paymentPrice + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                '}';
    }
}
