package com.pengyipeng.education.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xinhai
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/8 13:58 星期三
 * 学生
 */
@ApiModel(description = "学生用户")
public class StudentVo {
    @ApiModelProperty(value = "用户id")
    private int userid; // 用户(学生)id
    @ApiModelProperty(value = "用户手机号")
    private String phone; // 学生手机号
    @ApiModelProperty(value = "用户昵称")
    private String nickname; // 昵称
    @ApiModelProperty(value = "用户邮箱")
    private String email; // 邮箱
    @ApiModelProperty(value = "用户头像url")
    private String userPhoto; // 头像地址

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
