package com.pengyipeng.education.model.entity;


public class ClassTimes {

  private Integer classId;
  private String courseId;
  private String classKind;
  private String className;
  private String classTarget;
  private String classVideoAddress;


  public Integer getClassId() {
    return classId;
  }

  public void setClassId(Integer classId) {
    this.classId = classId;
  }


  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }


  public String getClassKind() {
    return classKind;
  }

  public void setClassKind(String classKind) {
    this.classKind = classKind;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public String getClassTarget() {
    return classTarget;
  }

  public void setClassTarget(String classTarget) {
    this.classTarget = classTarget;
  }


  public String getClassVideoAddress() {
    return classVideoAddress;
  }

  public void setClassVideoAddress(String classVideoAddress) {
    this.classVideoAddress = classVideoAddress;
  }

}
