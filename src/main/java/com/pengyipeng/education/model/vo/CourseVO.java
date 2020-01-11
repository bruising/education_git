package com.pengyipeng.education.model.vo;

import java.util.Date;

/**
 * @Author: Niuys
 * @Date: 2020/1/11 11:13
 * @Describe:
 */
public class CourseVO {
    private String courseId;
    private  String courseName;
    private double coursePrice;
    private String courseStatus;
    private  int courseSort;
    private Date courseDate;
    private String courseIntroduce;
    private String courseCycle;
    private String courseAbilityTraining;
    private String coursePic;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public int getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(int courseSort) {
        this.courseSort = courseSort;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseIntroduce() {
        return courseIntroduce;
    }

    public void setCourseIntroduce(String courseIntroduce) {
        this.courseIntroduce = courseIntroduce;
    }

    public String getCourseCycle() {
        return courseCycle;
    }

    public void setCourseCycle(String courseCycle) {
        this.courseCycle = courseCycle;
    }

    public String getCourseAbilityTraining() {
        return courseAbilityTraining;
    }

    public void setCourseAbilityTraining(String courseAbilityTraining) {
        this.courseAbilityTraining = courseAbilityTraining;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public CourseVO(String courseId, String courseName, double coursePrice, String courseStatus, int courseSort, Date courseDate, String courseIntroduce, String courseCycle, String courseAbilityTraining, String coursePic) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.courseStatus = courseStatus;
        this.courseSort = courseSort;
        this.courseDate = courseDate;
        this.courseIntroduce = courseIntroduce;
        this.courseCycle = courseCycle;
        this.courseAbilityTraining = courseAbilityTraining;
        this.coursePic = coursePic;
    }

    public CourseVO() {
    }
}
