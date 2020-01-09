package com.pengyipeng.education.model.entity;


public class CourseTeacher {

  private Integer courseTeacherId;
  private Integer courseId;
  private String teacherId;


  public Integer getCourseTeacherId() {
    return courseTeacherId;
  }

  public void setCourseTeacherId(Integer courseTeacherId) {
    this.courseTeacherId = courseTeacherId;
  }


  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }


  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

}
