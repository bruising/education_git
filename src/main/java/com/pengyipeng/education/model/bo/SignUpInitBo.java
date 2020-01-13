package com.pengyipeng.education.model.bo;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/9 15:38 星期四
 * 该类存储用户id和课程id 用于辅助
 */
public class SignUpInitBo {

    private int userId;
    private int courseId;

    public SignUpInitBo(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
