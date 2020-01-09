package com.pengyipeng.education.service;

import com.pengyipeng.education.model.vo.CourseProjectTeacherStudentVO;

import java.util.List;

/**
 * @author 郭新龙
 * @version V1.0
 * @Project education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/8 14:52 星期三
 */
public interface MyCoursesService {
    List<CourseProjectTeacherStudentVO> selectMyCourses(Integer sid);
}
