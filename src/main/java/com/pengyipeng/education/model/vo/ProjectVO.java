package com.pengyipeng.education.model.vo;

import com.pengyipeng.education.model.entity.Project;

import java.util.List;

public class ProjectVO {
    private List<Project> data;
    private Integer count;
    private Integer code;
    private String msg;

    public List<Project> getData() {
        return data;
    }

    public void setData(List<Project> data) {
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

    public ProjectVO(List<Project> data, Integer count, Integer code, String msg) {
        this.data = data;
        this.count = count;
        this.code = code;
        this.msg = msg;
    }

    public ProjectVO() {
    }
}
