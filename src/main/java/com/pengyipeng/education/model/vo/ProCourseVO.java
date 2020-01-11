package com.pengyipeng.education.model.vo;

import com.pengyipeng.education.model.entity.Course;

import java.util.List;

/**
 * @Author: Niuys
 * @Date: 2020/1/9 17:00
 * @Describe: 项目与课程的VO实体类
 */
public class ProCourseVO {
    private List<CourseVO> data;
    private Integer count;
    private Integer code;
    private String msg;

    public List<CourseVO> getData() {
        return data;
    }

    public void setData(List<CourseVO> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ProCourseVO(List<CourseVO> data, Integer count, Integer code, String msg) {
        this.data = data;
        this.count = count;
        this.code = code;
        this.msg = msg;
    }

    public ProCourseVO() {
    }
}
