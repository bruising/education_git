package com.pengyipeng.education.model.vo;

import com.pengyipeng.education.model.entity.Course;

import java.util.List;

/**
 * @Author: Niuys
 * @Date: 2020/1/9 17:00
 * @Describe: 项目与课程的VO实体类
 */
public class ProCourseVO {
    private List<Course> list;
    private Integer count;
    private Integer code;
    private String msg;

    public List<Course> getList() {
        return list;
    }

    public void setList(List<Course> list) {
        this.list = list;
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

    public ProCourseVO() {
    }

    public ProCourseVO(List<Course> list, Integer count, Integer code, String msg) {
        this.list = list;
        this.count = count;
        this.code = code;
        this.msg = msg;
    }
}
