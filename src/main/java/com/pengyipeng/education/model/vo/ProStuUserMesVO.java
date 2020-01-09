package com.pengyipeng.education.model.vo;

import java.util.List;

public class ProStuUserMesVO {
    /**
     * author:niuys
     * 前端需要这样的结果格式
     * ProStuUserVO结果加工类
     */
    private List<ProStuUserVO> data;
    private Integer count;
    private Integer code;
    private String msg;

    public List<ProStuUserVO> getData() {
        return data;
    }

    public void setData(List<ProStuUserVO> data) {
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

    public ProStuUserMesVO() {
    }

    public ProStuUserMesVO(List<ProStuUserVO> data, Integer count, Integer code, String msg) {
        this.data = data;
        this.count = count;
        this.code = code;
        this.msg = msg;
    }
}
