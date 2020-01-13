package com.pengyipeng.education.controller;


import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.vo.CourseStudentVo;
import com.pengyipeng.education.service.SearchCourseService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Api(tags = "课程显示，搜索和下架 作者:韩帅龙")
public class Searchcourse {

    @Resource
    private SearchCourseService service;

    /**
     * 展示所有的课程
     * @param request
     * @return
     */
    @ApiOperation(value = "查询所有的课程",notes ="获取所有的课程")
    @ApiResponses({
            @ApiResponse(code=200,message = "搜索成功"),
            @ApiResponse(code=500,message = "搜索失败")
    })
    @PostMapping ("/coursemanage")
    @ResponseBody
    public Result init(HttpServletRequest request){
        Result result = new Result();
        List<CourseStudentVo> courses = service.searchCourse();
        if (courses.size() > 0){
            request.setAttribute("course",courses);
            result.setCode(200);
            result.setMessage("搜索成功");
            result.setData(courses.toString());
            return result;
        }else{
            result.setCode(500);
            result.setMessage("查询失败");
            result.setData(courses.toString());
            return result;
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
    @ApiOperation(value = "通过条件查询课程",notes = "获取到查询的课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_name",value = "course_name",dataType = "String",example = "181022090"),
            @ApiImplicitParam(name = "course_date",value = "course_date",dataType = "String",example = "2020-01-14"),
            @ApiImplicitParam(name = "course_status",value = "course_status",dataType = "String",example = "1")
    })
    @ApiResponses({
            @ApiResponse(code=200,message = "查询成功"),
            @ApiResponse(code=500,message = "查询失败")
    })
    @PostMapping("/coursesearch")
    @ResponseBody
    public Result  searchCourseBycondition(String course_name, String course_date, String course_status, HttpServletRequest request){

        List<CourseStudentVo> courses = service.searchCourseByCondition(course_name, course_date, course_status);
        Result result = new Result();
        if (courses.size() > 0){
            result.setCode(200);
            result.setMessage("查询到结果");
            result.setData(courses.toString());
            request.setAttribute("course",courses);
            return result;
        }else {
            result.setCode(200);
            result.setData(courses.toString());
            result.setMessage("未查到结果");
            return result;
        }

    }


    /**
     * 根据课程id下架课程
     * @param course_id
     * @param request
     * @return
     */
    @ApiOperation(value = "通过课程id，下架课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id",value = "course_id",dataType = "String",example = "181022090")

    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "下架成功"),
            @ApiResponse(code = 500,message = "下架失败")
    })
    @PostMapping("/lshelf")
    @ResponseBody
    public Result lshelfBycourseid(String course_id, HttpServletRequest request){
        int i = service.lshelftBycourseid(course_id);
        Result result = new Result();
        if (i >0){
            System.out.println("下架成功");
            result.setCode(200);
            result.setMessage("下架成功");
            result.setData(i+"");
            return result;
        }else{
            System.out.println("下架失败");
            result.setCode(500);
            result.setMessage("下架失败");
            result.setData(i+"");
            return  result;
        }

    }

    /**
     * 修改顺序
     * @param sort
     */
    @ApiOperation(value = "修改课程显示的顺序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sort",value = "sort",dataType = "String",example = "100"),
            @ApiImplicitParam(name = "courseid",value = "courseid",dataType = "String",example = "181022090")
    })
    @ApiResponses({
            @ApiResponse(code=200,message = "顺序修改成功"),
            @ApiResponse(code=300,message = "该顺序存在"),
            @ApiResponse(code=500,message ="修改失败")
    })
    @PostMapping(value = "updateByorder")
    @ResponseBody
    public Result updateByOrder(@RequestParam(value = "sort") String sort,@RequestParam(value = "courseid") String courseid) throws IOException {
        System.out.println("课程id"+courseid);
        Result result = new Result();
        Map<String,Object> message=new HashMap<String, Object>();
        //验证该顺序是否存在 存在返回false
        Boolean aBoolean = this.checkByorder(sort);
        if (aBoolean){
         //可以修改
            message.put("status","yes");
            //修改顺序
            int i = service.updateSortByCourseid(sort, courseid);
            if (i>0){
                result.setCode(200);
                result.setMessage("修改成功");
                result.setData(i+"");

                System.out.println("修改成功");
                return result;
            }else{

                System.out.println("修改失败");
                result.setCode(500);
                result.setMessage("修该失败");
                result.setData(i+"");
                return result;
            }
        }else{
            //不可以修改
            message.put("status","no");
            result.setCode(300);
            result.setMessage("该顺序已存在");
            result.setData("0");
            return result;
        }

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
