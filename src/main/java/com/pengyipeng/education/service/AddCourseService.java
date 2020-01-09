package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.Apply_Phase;
import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.entity.TeacherManage;

import java.util.List;
import java.util.Map;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/6 20:28 星期一
 */
public interface AddCourseService {
    /**
     * 获取项目
     * @return 所有项目
     */
    List<Project> getProject(String name);

    /**
     * 获取课程适应阶段
     * @return 所有阶段
     */
    List<Apply_Phase>  getApply_phase();

    /**
     * 获取教师信息
     * @return 所有教师信息
     */
    List<TeacherManage> getTeacher(String tname);

    /**
     * 添加课程
     * @return 状态（成功   失败）
     */
    int addCourse(Map<String,Object> map);

    /**
     * 添加课程-适应阶段关联信息
     * @return 状态（ 成功  失败）
     */
    int addCourse_applyphase(Map<String,Object> map);

    /**
     * 添加课程-项目关联信息
     * @return 状态（ 成功  失败）
     */
    int addCourse_project(Map<String,Object> map);

    /**
     * 添加课程-教师关联信息
     * @return 状态（ 成功  失败）
     */
    int addCourse_teacher(Map<String,Object> map);

    /**
     * 获取课程最大排序
     * @return
     */
    int selectCourse_sort();

    int getCourse(int course_id);
}
