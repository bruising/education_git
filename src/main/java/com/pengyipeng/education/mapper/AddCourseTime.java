package com.pengyipeng.education.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/9 19:06 星期四
 */
public interface AddCourseTime {

    /**
     * 将课次信息存放到数据库中
     * @param classKind 课程类型
     * @param className  课程名称
     * @param classTarget 课程目标
     * @param classVideoAddress  视频地址
     * @return
     */
        int addCourseTime(@Param("courseId") String courseId,@Param("classKind") String classKind,@Param("className") String className,@Param("classTarget") String classTarget,@Param("classVideoAddress") String classVideoAddress);

    /**
     * 添加课程信息
     * @param map
     * @return
     */
    int addCourseinfo(Map<String,Object> map);


    /**
     * 添加教师id和课程id
     * @param teacher_id 教师的id
     * @param course_id 课程的id
     * @return
     */
    int addCourseTeacher(String teacher_id,String course_id);

    /**
     * 添加课程 id 和 项目的id
     * @param project_id 项目的id
     * @param course_id   课程的id
     * @return
     */
    int addCourseProject(String project_id,String course_id);

    /**
     * 添加课程的适应阶段
     * @param course_id
     * @param apply_phase_id
     * @return
     */
    int addCourseApplyphase(String course_id,String apply_phase_id);
}
