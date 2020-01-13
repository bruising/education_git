package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.service.SupplementaryStudentService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/10 22:00 星期五
 */
@Controller
@Api(tags = "课程管理之补录学生-李陈")
public class SupplementaryStudentController {
    @Resource
    private SupplementaryStudentService supplementaryStudentService;
    @ApiOperation(value = "根据用户昵称或电话模糊查询用户信息",notes = "查询成功返回查询结果，失败就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickname", value = "用户昵称", dataType = "String", example = "小米"),
            @ApiImplicitParam(name = "phone", value = "用户电话", dataType = "String", example = "")
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "查询用户失败"),
            @ApiResponse(code = 200,message = "成功")

    })

    @PostMapping("/getUserByNicknameOrPhone")
    @ResponseBody
    public Result getUserByNicknameOrPhone(@RequestParam("nickname")String nickname,@RequestParam("phone")String phone){
        List<User_Manager> list=supplementaryStudentService.getUserByNicknameOrPhone(nickname,phone);
        String result1= JSON.toJSONString(list);
        Result result=new Result();
        result.setCode(200);
        result.setMessage("用户信息");
        result.setData(result1);
        System.out.println(result1);
        return result;

    }

    @ApiOperation(value = "获取对应的用户的学生信息",notes = "查询成功返回结果，失败就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid" , value = "用户id", dataType = "int" , example = ""),
            //@ApiImplicitParam(name = "phone", value = "用户电话", dataType = "String", example = "")
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "查询学生失败"),
            @ApiResponse(code = 200,message = "成功")

    })
    @PostMapping("/getStudentByUserid")
    @ResponseBody
    public Result getStudentByUserid(@RequestParam("userid")int userid){
        List<StudentManagement> list=supplementaryStudentService.getStudentByUserid(userid);
        String result1= JSON.toJSONString(list);
        Result result=new Result();
        result.setCode(200);
        result.setMessage("学生信息");
        result.setData(result1);
        System.out.println(result1);
        return result;
    }

    @ApiOperation(value = "添加学生信息到相应的用户",notes = "添加成功返回结果，失败就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid" , value = "用户id", dataType = "int" , example = ""),
            @ApiImplicitParam(name = "sname", value = "学生姓名", dataType = "String", example = "笑笑"),
            @ApiImplicitParam(name = "birth" , value = "出生年月", dataType = "String" , example = "1990-09-09"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "添加学生失败"),
            @ApiResponse(code = 200,message = "成功")

    })
    @PostMapping("/addStudentByUserid")
    @ResponseBody
    public Result addStudentByUserid(@RequestParam("userid")int userid, @RequestParam("sname") String sname,@RequestParam("birth") String birth){
        int status=0;
        Result result=new Result();
        try {
            status=supplementaryStudentService.addStudentByUserid(userid,sname,birth);
            String result1= JSON.toJSONString(status);

            result.setCode(200);
            result.setMessage("添加状态（1 成功 -1  失败）");
            result.setData(result1);
            System.out.println(result1);
            //return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "向课程中添加补录学生信息",notes = "添加成功返回结果，失败就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id" , value = "课程id", dataType = "int" , example = ""),
            @ApiImplicitParam(name = "sid", value = "学生id", dataType = "int", example = "5"),
            @ApiImplicitParam(name = "payment_method" , value = "支付方式", dataType = "String" , example = "微信"),
            @ApiImplicitParam(name = "payment_price", value = "支付金额", dataType = "int", example = "125")
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "添加补录学生失败"),
            @ApiResponse(code = 200,message = "添加补录学生成功")

    })
    @PostMapping("/addSupplementaryStudentByCourse_id")
    @ResponseBody
    public Result addSupplementaryStudentByCourse_id(@RequestParam("course_id")int course_id, @RequestParam("sid")int sid,
                                                     @RequestParam("payment_method")String payment_method, @RequestParam("payment_price")int payment_price){
        int status=0;
        Result result=new Result();
        try {
            status=supplementaryStudentService.addSupplementaryStudentByCourse_id( course_id,  sid, payment_method, payment_price);
            String result1= JSON.toJSONString(status);
            result.setCode(200);
            result.setMessage("添加状态（1成功  -1失败）");
            result.setData(result1);
            System.out.println(result1);
            //return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
