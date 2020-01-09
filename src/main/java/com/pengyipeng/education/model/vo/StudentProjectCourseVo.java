package com.pengyipeng.education.model.vo;

/**
 * @author 庞冉
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/7 12:08 星期二
 */
public class StudentProjectCourseVo {
    /**
     *学生id
     */
    private int sid;
    /**
     *项目名称
     */
    private String name;
    /**
     *课程名称
     */
    private String course_name;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
