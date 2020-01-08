package com.pengyipeng.education.service.impl;


import com.pengyipeng.education.mapper.SearchcourseDao;
import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.vo.CourseStudentVo;
import com.pengyipeng.education.service.SearchCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程管理
 * 作者：韩帅龙
 */
@Service
public class SearchCourseServiceImpl implements SearchCourseService {

    @Resource
    private SearchcourseDao dao;
    @Override
    public List<CourseStudentVo> searchCourse() {
        List<CourseStudentVo> courses = dao.SearchCourse();
        return courses;
    }

    @Override
    public List<CourseStudentVo> searchCourseByCondition(String course_name, String course_date, String course_status) {
        List<CourseStudentVo> courses = dao.SearchCourseBycondition(course_name, course_date, course_status);
        return courses;
    }

    @Override
    public int lshelftBycourseid(String course_id) {
        int i = dao.lshelfBycourse_id(course_id);
        return i;
    }

    @Override
    public List<Course> checkByOrder(String sort) {
        List<Course> courses = dao.checkByOrder(sort);
        return courses;
    }

    @Override
    public int updateSortByCourseid(String sort, String courseid) {
        int i = dao.updateBycourseOrder(sort, courseid);
        return i;
    }
}
