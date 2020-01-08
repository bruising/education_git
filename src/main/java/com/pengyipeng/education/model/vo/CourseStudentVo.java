package com.pengyipeng.education.model.vo;

import java.util.Date;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.Model
 * @date 2020/1/5 21:28 星期日
 * 课程和学生数量的vo实体类
 */
public class CourseStudentVo {
    private String course_id;
    private String course_name;
    private double course_price;
    private String course_status;
    private int course_sort;
    private Date course_date;
    private String course_introduce;
    private String course_cycle;
    private String course_ability_training;
    private String course_pic;
    //选该课程的学生的数量
    private String course_stunum;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(double course_price) {
        this.course_price = course_price;
    }

    public String getCourse_status() {
        return course_status;
    }

    public void setCourse_status(String course_status) {
        this.course_status = course_status;
    }

    public int getCourse_sort() {
        return course_sort;
    }

    public void setCourse_sort(int course_sort) {
        this.course_sort = course_sort;
    }

    public Date getCourse_date() {
        return course_date;
    }

    public void setCourse_date(Date course_date) {
        this.course_date = course_date;
    }

    public String getCourse_introduce() {
        return course_introduce;
    }

    public void setCourse_introduce(String course_introduce) {
        this.course_introduce = course_introduce;
    }

    public String getCourse_cycle() {
        return course_cycle;
    }

    public void setCourse_cycle(String course_cycle) {
        this.course_cycle = course_cycle;
    }

    public String getCourse_ability_training() {
        return course_ability_training;
    }

    public void setCourse_ability_training(String course_ability_training) {
        this.course_ability_training = course_ability_training;
    }

    public String getCourse_pic() {
        return course_pic;
    }

    public void setCourse_pic(String course_pic) {
        this.course_pic = course_pic;
    }

    public String getCourse_stunum() {
        return course_stunum;
    }

    public void setCourse_stunum(String course_stunum) {
        this.course_stunum = course_stunum;
    }

    @Override
    public String toString() {
        return "CourseStudentVo{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_price=" + course_price +
                ", course_status='" + course_status + '\'' +
                ", course_sort=" + course_sort +
                ", course_date=" + course_date +
                ", course_introduce='" + course_introduce + '\'' +
                ", course_cycle='" + course_cycle + '\'' +
                ", course_ability_training='" + course_ability_training + '\'' +
                ", course_pic='" + course_pic + '\'' +
                ", course_stunum='" + course_stunum + '\'' +
                '}';
    }
}
