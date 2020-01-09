package com.pengyipeng.education.model.entity;


public class CourseStudent {

  private Integer courseStudentId;
  private Integer courseId;
  private Integer studentId;
  private double courseProgress;


  public Integer getCourseStudentId() {
    return courseStudentId;
  }

  public void setCourseStudentId(Integer courseStudentId) {
    this.courseStudentId = courseStudentId;
  }


  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }


  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }


  public double getCourseProgress() {
    return courseProgress;
  }

  public void setCourseProgress(double courseProgress) {
    this.courseProgress = courseProgress;
  }

}
