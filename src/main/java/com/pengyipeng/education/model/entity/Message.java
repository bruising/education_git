package com.pengyipeng.education.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "这是返回的对象")
public class Message {
    @ApiModelProperty(value = "这是状态码")
    private String code;
    @ApiModelProperty(value = "这是信息")
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}