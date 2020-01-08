package com.pengyipeng.education.controller;


import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.vo.CourseStudentVo;
import com.pengyipeng.education.service.SearchCourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 修改顺序
     * @param sort
     */
    @RequestMapping(value = "updateByorder")
    public void updateByOrder(@RequestParam(value = "sort") String sort,@Param(value = "courseid") String courseid, HttpServletResponse response) throws IOException {
        System.out.println("课程id"+courseid);
        Map<String,Object> message=new HashMap<String, Object>();
        //验证该顺序是否存在 存在返回false
        Boolean aBoolean = this.checkByorder(sort);
        if (aBoolean){
         //可以修改
            message.put("status","yes");
            //修改顺序
            int i = service.updateSortByCourseid(sort, courseid);
            if (i>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }else{
            //不可以修改
            message.put("status","no");

        }
        String data = JSON.toJSONString(message);
        System.out.println(data);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write(data);
        writer.flush();
        writer.close();
    }

    /**
     * 判断修改的顺序是否存在，存在的话 返回false
     * 不存在的话返回true
     * @return
     */
    public Boolean checkByorder(String sort){
        List<Course> courses = service.checkByOrder(sort);
        if (courses.size() > 0){

            return  false;
        }
        return true;
    }





}
