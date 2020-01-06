package com.pengyipeng.education.controller;


import com.pengyipeng.education.model.vo.CourseStudentVo;
import com.pengyipeng.education.service.SearchCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程展示和搜索
 * 作者:韩帅龙
 */
@Controller
public class Searchcourse {

    @Resource
    private SearchCourseService service;

    /**
     * 展示所有的课程
     * @param request
     * @return
     */
    @RequestMapping("/coursemanage")
    public String init(HttpServletRequest request){
        List<CourseStudentVo> courses = service.searchCourse();
        if (courses.size() > 0){
            request.setAttribute("course",courses);
            return "coursemanage";
        }else{
            return "coursemanage";
        }

    }

    /**
     * 根据条件查询课程
     * @param course_name
     * @param course_date
     * @param course_status
     * @param request
     * @return
     */
    @RequestMapping("/coursesearch")
    public String  searchCourseBycondition(String course_name, String course_date, String course_status, HttpServletRequest request){

        List<CourseStudentVo> courses = service.searchCourseByCondition(course_name, course_date, course_status);
        if (courses.size() > 0){

            request.setAttribute("course",courses);
            return "coursemanage";
        }else {
            request.setAttribute("course",courses);
            return "coursemanage";
        }

    }


    /**
     * 根据课程id下架课程
     * @param course_id
     * @param request
     * @return
     */
    @RequestMapping("/lshelf")
    public String lshelfBycourseid(String course_id, HttpServletRequest request){
        int i = service.lshelftBycourseid(course_id);
        if (i >0){
            System.out.println("下架成功");
            return init(request);
        }else{
            System.out.println("下架失败");
            return  init(request);
        }

    }




}
