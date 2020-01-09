package com.pengyipeng.education.model.vo;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/6 19:12 星期一
 */

/**
 * 课程-适应阶段 关联实体类（CourseApplyVo）
 */
public class CourseApplyVo {
    /*
    关联id
     */
    private int course_applyphase_id;
    /*
    课程id
     */
    private int course_id;
    /*
    课程适应阶段id
     */
    private int apply_phase_id;

    public int getCourse_applyphase_id() {
        return course_applyphase_id;
    }

    public void setCourse_applyphase_id(int course_applyphase_id) {
        this.course_applyphase_id = course_applyphase_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getApply_phase_id() {
        return apply_phase_id;
    }

    public void setApply_phase_id(int apply_phase_id) {
        this.apply_phase_id = apply_phase_id;
    }

    public CourseApplyVo() {
    }

    public CourseApplyVo(int course_applyphase_id, int course_id, int apply_phase_id) {
        this.course_applyphase_id = course_applyphase_id;
        this.course_id = course_id;
        this.apply_phase_id = apply_phase_id;
    }
}
