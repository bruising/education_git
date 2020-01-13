package com.pengyipeng.education.controller;

import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.vo.CourseStudentUserVo;
import com.pengyipeng.education.service.impl.CourseStudentInforServiceImpl;
import com.pengyipeng.education.util.swagger.SwaggerConfig;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/11 15:08 星期六
 */
@Controller
@Api(tags = "根据课程id查看该课程的学生信息，作者：韩帅龙")
public class CourseStudent {
    @Resource
    private CourseStudentInforServiceImpl service;


    @ApiOperation(value = "输入课程id",notes = "获取到学生信息和用户信息")
    @ApiImplicitParams({
      @ApiImplicitParam(name ="courseId",value = "courseId",dataType = "String",example = "181022090")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "获取信息成功"),
            @ApiResponse(code = 500,message = "获取信息失败")
    })
    @PostMapping("showStudentInforByCourseId")
    @ResponseBody
    public Result showStudentInforByCourseId(String courseId){
        System.out.println("课程的id是"+courseId);
        Result result = new Result();
        List<CourseStudentUserVo> courseStudentUserVos = service.showStudentInforByCourseId(courseId);
//        for (CourseStudentUserVo vo:courseStudentUserVos
//             ) {
//            System.out.println(courseStudentUserVos);
//        }
        if (courseStudentUserVos.size() > 0){
            System.out.println("查询成功");
            result.setCode(200);
            result.setMessage("查询成功");
            result.setData(courseStudentUserVos.toString());
            return  result;
        }else{
            System.out.println("查询失败");
            result.setCode(500);
            result.setMessage("查询失败");
            result.setData(courseStudentUserVos.toString());
            return  result;
        }
    }

}
