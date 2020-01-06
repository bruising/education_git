package com.pengyipeng.education.service;



import com.pengyipeng.education.model.vo.CourseStudentVo;

import java.util.List;

/**
 * 课程管理 service 接口
 * 作者：韩帅龙
 */
public interface SearchCourseService {

    /**
     * 展示所有的课程
     * @return
     */
    List<CourseStudentVo> searchCourse();

    /**
     * 根据条件查询课程
     * @param course_name 课程名称
     * @param course_date  课程时间
     * @param course_status  课程状态
     * @return
     */
    List<CourseStudentVo> searchCourseByCondition(String course_name, String course_date, String course_status);


    /**
     * 根据课程id下架课程
     * @param course_id
     * @return
     */
     int lshelftBycourseid(String course_id);
}
