package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.bo.AddOrder;
import com.pengyipeng.education.model.bo.AddStudentBo;
import com.pengyipeng.education.model.bo.SignUpInitBo;
import com.pengyipeng.education.model.entity.Message;
import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.vo.CourseVO;
import com.pengyipeng.education.service.SignUpService;
import com.pengyipeng.education.util.CreateTradeNoUtil;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller.sign_up
 * @date 2020/1/6 17:06 星期一
 */
@Controller
@Api(tags = "报名课程——支付 姚顺")
@RestController
public class SignUpController {

    @Resource
    SignUpService signUpService;

    /**
     * 报名页面初始化 进入该初始化需要
     * @return
     */
    @ApiOperation(value = "读取用户id",notes ="读取课程id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "userId",dataType = "Integer",example = "1"),
            @ApiImplicitParam(name = "courseId",value = "courseId",dataType = "Integer",example = "181022090")
    })
    @RequestMapping("signUpInit")
    public String signUpInit(){
        int userId = 1;  //在这里模拟的是用户1号
        int courseId = 181022090; //在这里模拟的是课程
        SignUpInitBo signUpInit = new SignUpInitBo(userId, courseId);
        return JSON.toJSONString(signUpInit);
    }

    /**
     * 根据用户id获取到该用户id名下的所有学生 取默认选项的时候直接取第一个
     * @param userId 用户id
     * @return 该用户下的所有学生JSON字符串
     */
    @ApiOperation(value = "根据用户id获取所有的学生")
    @RequestMapping("getAllStudent")
    public String getAllStudnetByUserId(@RequestParam("userId")int userId){
        List<StudentManagement> studentManagementList = signUpService.getStudentManagementByUserId(userId);
        return JSON.toJSONString(studentManagementList);
    }

    /**
     * 获取课程信息
     * @param courseId 课程id
     * @return 课程信息json字符串
     */
    @ApiOperation(value = "根据课程id获取课程信息")
    @RequestMapping("getCourse")
    public String getCourseByCouseId(@RequestParam("courseId")int courseId){
        CourseVO course = signUpService.getCouseById(courseId);
        return JSON.toJSONString(course);
    }

    /**
     * 添加学生
     * @return 添加学生是否成功json
     */
    @ApiOperation(value = "添加学生信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "添加成功"),
            @ApiResponse(code = 500,message = "添加失败")
    })
    @RequestMapping("addStudent")
    public String addStudent(AddStudentBo addStudent){
        //添加学生后还需要添加用户所对应的学生
        AddStudentBo newStudent = signUpService.addStudentManagement(addStudent);
        System.out.println(newStudent);
        Message message = new Message();
        if(newStudent != null){
            message.setCode("200");
            message.setMsg(newStudent.getSid() + "");
        }else{
            message.setCode("500");
            message.setMsg("添加失败");
        }
        return JSON.toJSONString(message);
    }

    /**
     * 根据学生id查找单个学生
     * @param sid
     * @return
     */
    @ApiOperation(value = "根据学生id获取学生")
    @RequestMapping("getStudentManagementBySId")
    public String getStudentManagementBySId(@RequestParam("sid")int sid){
        StudentManagement student = signUpService.getStudentManagementBySId(sid);
        return JSON.toJSONString(student);
    }

    /**
     * 根据课程id查找单个课程
     * @param cid
     * @return
     */
    @ApiOperation(value = "根据课程id获取课程")
    @RequestMapping("getCourseByCId")
    public String getCourseByCId(@RequestParam("cid")int cid){
        CourseVO course = signUpService.getCourseByCId(cid);
        return JSON.toJSONString(course);
    }

    /**
     * 确认订单第一步 判断这个学生是否存在
     * 确认订单第二步 判断这个课程是否存在
     * 添加订单后进入一个页面 默认是1 如果点击了支付 则变成4
     * 支付完成后将会添加一条课程进度
     */
    /**
     * 添加订单 但是未支付
     * @param courseId
     * @param userId
     * @param radioSignupmethod
     * @return
     */
    @ApiOperation(value = "提交第一次订单 但不支付")
    @ApiResponses({
            @ApiResponse(code = 200,message = "创建订单成功"),
            @ApiResponse(code = 500,message = "创建订单失败")
    })
    @RequestMapping("submitPay")
    public String addOrder(@RequestParam(value="courseid")int courseId,
                           @RequestParam(value="userid")int userId,
                           @RequestParam(value="radio_signupmethod")int radioSignupmethod){

        double orderPrice = signUpService.getCourseByCId(courseId).getCoursePrice();
        //double payPrice = orderPrice;

        AddOrder order = new AddOrder(courseId, CreateTradeNoUtil.getAccountRandom20(),userId,orderPrice,  radioSignupmethod);
        AddOrder newOrder = signUpService.addOrder(order);

        Message message = new Message();
        if(newOrder != null){
            message.setCode("200");
            message.setMsg(JSON.toJSONString(newOrder));
        }else{
            message.setCode("500");
            message.setMsg(JSON.toJSONString("创建订单失败"));
        }
        return JSON.toJSONString(message);
    }

    //"o":orderId,"u":userId,"c":courseId,"s":sid
    @ApiOperation(value = "提交第一次订单 但不支付")
    @ApiResponses({
            @ApiResponse(code = 200,message = "支付成功"),
            @ApiResponse(code = 500,message = "支付失败")
    })
    @RequestMapping("pay")
    public String pay(@RequestParam(value="o")int oid,
                      @RequestParam(value="u")int uid,
                      @RequestParam(value="c")int cid,
                      @RequestParam(value="s")int sid){

        double orderPrice = signUpService.getCourseByCId(cid).getCoursePrice();
        double payPrice = orderPrice;
        boolean flag = signUpService.pay(oid,cid,sid,payPrice);
        Message message = new Message();
        if(flag){
            message.setCode("200");
            message.setMsg("支付成功");
        }else{
            message.setCode("500");
            message.setMsg("支付失败");
        }
        return JSON.toJSONString(message);

    }
}
