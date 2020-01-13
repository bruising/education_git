package com.pengyipeng.education.service;

import java.util.Map;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/9 19:43 星期四
 */
public interface AddClassTimeService {

    /**
     * service接口
     * @param courseId
     * @param ClassKind
     * @param ClassName
     * @param classTarget
     * @param classVideoAddress
     * @return
     */
    int addClassTime(String courseId,String ClassKind,String ClassName,String classTarget,String classVideoAddress);

    /**
     * 添加课程信息
     * @param map
     * @return
     */
    int addCourseinfor(Map<String,Object> map);

    /**
     * 添加课程和教师的中间表
     * @param teacher_id
     * @param course_id
     * @return
     */
    int addCourseTeacher(String teacher_id,String course_id);

    /**
     * 添加课程的项目
     * @param course_id
     * @param project_id
     * @return
     */
    int addCourseProject(String project_id, String course_id);

    /**
     * 添加课程的适用阶段
     * @param course_id   课程id
     * @param apply_phase_id  使用阶段id
     * @return
     */
    int addCourseApplyphase(String course_id,String apply_phase_id);
}
