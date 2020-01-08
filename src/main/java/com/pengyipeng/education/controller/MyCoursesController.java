package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.vo.CourseProjectTeacherStudentVO;
import com.pengyipeng.education.service.MyCoursesService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郭新龙
 * @version V1.0
 * @Project education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/8 14:40 星期三
 * 我的学习中心-我的课程
 */
@Controller
@Api(tags = "我的学习中心-我的课程(郭新龙)")
public class MyCoursesController {

    @Resource
    private MyCoursesService myCoursesService;

    @ApiOperation(value = "输入学生编号(sid),获取数据",notes = "返回课程数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid",value = "sid",dataType = "String",example = "00001")
    })
    @RequestMapping(value = "selectMyCourses",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public String selectMyCourses(@RequestParam(value = "sid",required = false,defaultValue = "0") Integer sid){
        List<CourseProjectTeacherStudentVO> list=myCoursesService.selectMyCourses(sid);
        return JSON.toJSONString(list);
    }

}
