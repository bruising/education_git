package com.pengyipeng.education.model.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.pengyipeng.education.model.entity.Project;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 课程实体类
 */
public class CourseProjectTeacherStudentVO {
    private String course_id;
    private String course_name;
    private Double course_price;
    private String course_status;
    private Integer course_sort;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date course_date;
    private String course_introduce;
    private String course_cycle;
    private String course_ability_training;
    private String course_pic;
    private String tname;//教师名称
    private Double course_progress;//课程进度
    private String class_video_address;//视频地址
    private List<Project> projects;//关联项目

    @Override
    public String toString() {
        return "CourseProjectTeacherStudentVO{" +
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
                ", tname='" + tname + '\'' +
                ", course_progress=" + course_progress +
                ", class_video_address='" + class_video_address + '\'' +
                ", projects=" + projects +
                '}';
    }

    public CourseProjectTeacherStudentVO() {
    }

    public CourseProjectTeacherStudentVO(String course_id, String course_name, Double course_price, String course_status, Integer course_sort, Date course_date, String course_introduce, String course_cycle, String course_ability_training, String course_pic, String tname, Double course_progress, String class_video_address, List<Project> projects) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_price = course_price;
        this.course_status = course_status;
        this.course_sort = course_sort;
        this.course_date = course_date;
        this.course_introduce = course_introduce;
        this.course_cycle = course_cycle;
        this.course_ability_training = course_ability_training;
        this.course_pic = course_pic;
        this.tname = tname;
        this.course_progress = course_progress;
        this.class_video_address = class_video_address;
        this.projects = projects;
    }

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

    public Double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(Double course_price) {
        this.course_price = course_price;
    }

    public String getCourse_status() {
        return course_status;
    }

    public void setCourse_status(String course_status) {
        this.course_status = course_status;
    }

    public Integer getCourse_sort() {
        return course_sort;
    }

    public void setCourse_sort(Integer course_sort) {
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Double getCourse_progress() {
        return course_progress;
    }

    public void setCourse_progress(Double course_progress) {
        this.course_progress = course_progress;
    }

    public String getClass_video_address() {
        return class_video_address;
    }

    public void setClass_video_address(String class_video_address) {
        this.class_video_address = class_video_address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
