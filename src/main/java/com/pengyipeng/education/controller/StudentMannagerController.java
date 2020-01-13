package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Message;
import com.pengyipeng.education.model.vo.StudentMangerVo;
import com.pengyipeng.education.model.vo.StudentProjectCourseVo;
import com.pengyipeng.education.service.StudentManagerService;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 庞冉
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/6 16:35 星期一
 */
@RestController
@Api(tags = "这是庞冉写的Controller")
public class StudentMannagerController {
    @Resource
    StudentManagerService studentManagerService;
    /**
     *查询
     * @param studentpaymentstatus 1 已付费，2 未付费
     */
    @ApiOperation(value = "输入条件查询的信息进行查询",notes = "对了就给学生数据，错了就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "phone",dataType = "String",example = "13405485400"),
            @ApiImplicitParam(name = "latest_login_time",value = "latest_login_time",dataType = "String",example = "2020-01-15"),
            @ApiImplicitParam(name = "studentpaymentstatus",value = "studentpaymentstatus",dataType = "String",example = "1"),
            @ApiImplicitParam(name = "registration_time",value = "registration_time",dataType = "String",example = "2020-01-15")
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "查询失败！"),
            @ApiResponse(code = 200,message = "查询成功")
    })
    @PostMapping(value = "studentInfo")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Message studentInfo(@RequestParam(value = "phone" ,required = false,defaultValue ="")String phone,
                               @RequestParam(value = "latest_login_time",required = false,defaultValue ="")String latest_login_time,
                               @RequestParam(value = "studentpaymentstatus",required = false,defaultValue ="0")Integer studentpaymentstatus,
                               @RequestParam(value = "registration_time",required = false,defaultValue ="") String registration_time
                               ){
        System.out.println("进入方法进行查询");
        System.out.println(phone);
        System.out.println(latest_login_time);
        Integer pay=studentpaymentstatus;
        System.out.println(registration_time);
        Message message = new Message();
        Map<String,Object>map=new HashMap<>();
        if (registration_time!="" && registration_time!=null){
            System.out.println(registration_time+"_____++++++++");
            //Date registration_time=(new SimpleDateFormat("yyyy-MM-dd")).parse(registration_times);
            map.put("registration_time",registration_time);
        }
        if (phone!=""){
            map.put("phone",phone);
        }
        if (latest_login_time!="" && latest_login_time!=null){
            map.put("latest_login_time",latest_login_time);
        }
        if (pay>0){
            System.out.println("----------------------------");
            System.out.println(studentpaymentstatus);
            map.put("studentpaymentstatus",pay);
        }
        System.out.println("++++++++++++++++++++++");
         System.out.println(map.get("registration_time").toString());
           List<StudentMangerVo> studentMangerVoList =studentManagerService.studentManInforQuery(map);
           if (studentMangerVoList != null && studentMangerVoList.size() > 0) {
               for (StudentMangerVo student:studentMangerVoList) {
                   System.out.println(student.getRegistration_time());
                   System.out.println(student.getNickname());
                   System.out.println(student.getSname());
               }
               message.setCode("200");
               message.setMsg(JSON.toJSONString(studentMangerVoList));
           } else {
               message.setCode("123");
               message.setMsg("查询失败");
           }
        return message;
    }
    /**
     *查询该学生参与项目
     */
    @ApiOperation(value = "输入学生的id进行查询参与项目",notes = "对了就给学生数据，错了就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid",value = "sid",dataType = "int",example = "00001"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "查询失败！"),
            @ApiResponse(code = 200,message = "查询成功")
    })
    @PostMapping(value = "queryProjectNameBySid")
    public Message queryProjectNameBySid(@RequestParam(value = "sid" ,required = false,defaultValue ="")int sid){
        Message message = new Message();
        List<StudentProjectCourseVo> studentProjectVoList=studentManagerService.selectProjectNameBySid(sid);
        if (studentProjectVoList!=null&&studentProjectVoList.size()>0){
            message.setCode("200");
            message.setMsg(JSON.toJSONString(studentProjectVoList));
        }else {
            message.setCode("123");
            message.setMsg("查询失败");
        }
        return message;
    }
    /**
     *查询该学生报名课程
     */
    @ApiOperation(value = "输入学生的id进行查询报名课程",notes = "对了就给学生数据，错了就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid",value = "sid",dataType = "int",example = "00001"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "查询失败！"),
            @ApiResponse(code = 200,message = "查询成功")
    })
    @PostMapping(value = "selectCourseNameBySid")
    public Message selectCourseNameBySid(@RequestParam(value = "sid" ,required = false,defaultValue ="")int sid){
        Message message = new Message();
        List<StudentProjectCourseVo> studentCourseVoList=studentManagerService.selectCourseNameBySid(sid);
        if (studentCourseVoList!=null&&studentCourseVoList.size()>0){
            message.setCode("200");
            message.setMsg(JSON.toJSONString(studentCourseVoList));
        }else {
            message.setCode("123");
            message.setMsg("查询失败");
        }
        return message;
    }
}
