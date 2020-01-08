package com.pengyipeng.education.controller;

import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.service.TeacherService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡婷婷
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/6 15:57 星期一
 */
@RestController
@Api(tags = "这是胡婷婷写的")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    /**
     * 根据条件返回教师信息
     * @param phone 手机号
     * @param tname 教师姓名
     * @param latest_login_time 最近登录时间
     * @param status 教师状态
     * @return 教师数据
     */
    @ApiOperation(value = "根据条件返回查询到的教师信息", notes = "成功则返回教师数据，失败则返回提示字符串（教师详情可以从返回数据中按照教师ID提取）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "phone", dataType = "String", example = "13322221111"),
            @ApiImplicitParam(name = "tname", value = "tname", dataType = "String", example = "xx"),
            @ApiImplicitParam(name = "latest_login_time", value = "latest_login_time", dataType = "String", example = "yyyy-MM-dd"),
            @ApiImplicitParam(name = "status", value = "status", dataType = "String", example = "1"),
            @ApiImplicitParam(name = "tid", value = "tid", dataType = "String", example = "T2940")
    })
    @ApiResponses({
            @ApiResponse(code = 123, message = "未找到符合该条件的信息"),
            @ApiResponse(code = 200, message = "找到符合条件的信息")
    })
    @PostMapping(value = "/teacherInfo")
    public Result teacherInfo(@RequestParam(value = "phone", required = false, defaultValue = "") String phone,
                              @RequestParam(value = "tname", required = false, defaultValue = "") String tname,
                              @RequestParam(value = "latest_login_time", required = false, defaultValue = "") String latest_login_time,
                              @RequestParam(value = "status", required = false, defaultValue = "0") Integer status,
                              @RequestParam(value = "tid", required = false, defaultValue = "") String tid){
        Map<String, Object> map = new HashMap<>();
        if (phone!=""){
            map.put("phone", phone);
        }
        if (tname!=""){
            map.put("tname", tname);
        }
        if (latest_login_time!=""){
            map.put("latest_login_time", latest_login_time);
        }
        if (status>0){
            map.put("status", status);
        }
        if (tid!=""){
            map.put("tid", tid);
        }
        return teacherService.selectTeacherMessage(map);
    }

    /**
     * 修改教师的状态
     * @param tid 教师ID
     * @param status 想要修改的状态
     * @return 修改结果
     */
    @ApiOperation(value = "修改教师的状态", notes = "成功或失败都有修改结果，返回提示字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tid", value = "tid", dataType = "String", example = "T2940"),
            @ApiImplicitParam(name = "status", value = "status", dataType = "String", example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 123, message = "修改失败"),
            @ApiResponse(code = 200, message = "修改成功")
    })
    @PostMapping(value = "/updateTeacherStatus")
    public Result updateTeacherStatus(@RequestParam(value = "tid", required = false, defaultValue = "") String tid,
                                      @RequestParam(value = "status", required = false, defaultValue = "0") Integer status){
        return teacherService.updateTeacherStatus(status, tid);
    }

    /**
     * 新建教师
     * @param phone 手机号
     * @param tname 名字
     * @param photo 头像
     * @param status 状态
     * @param email 登录状态
     * @param info 教师介绍
     * @return 新建结果
     */
    @ApiOperation(value = "新建教师", notes = "成功或失败都有新增的结果，返回提示字符串(如果传入头像则添加，没有则不添加)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "photo", value = "photo", dataType = "String", example = "xxx"),
            @ApiImplicitParam(name = "tname", value = "tname", dataType = "String", example = "xxx"),
            @ApiImplicitParam(name = "phone", value = "phone", dataType = "String", example = "13322221111"),
            @ApiImplicitParam(name = "email", value = "email", dataType = "String", example = "xxx@qq.com"),
            @ApiImplicitParam(name = "info", value = "info", dataType = "String", example = "xxx"),
            @ApiImplicitParam(name = "status", value = "status", dataType = "String", example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 123, message = "该登录账号不存在"),
            @ApiResponse(code = 234, message = "新增失败"),
            @ApiResponse(code = 200, message = "新增教师成功")
    })
    @PostMapping(value = "/addTeacher")
    public Result addTeacher(@RequestParam(value = "phone", required = false, defaultValue = "") String phone,
                           @RequestParam(value = "tname", required = false, defaultValue = "") String tname,
                           @RequestParam(value = "photo", required = false, defaultValue = "") String photo,
                           @RequestParam(value = "status", required = false, defaultValue = "0") Integer status,
                           @RequestParam(value = "email", required = false, defaultValue = "") String email,
                           @RequestParam(value = "info", required = false, defaultValue = "") String info){
        Map<String, Object> map = new HashMap<>();
        if (photo!=""){
            map.put("photo", photo);
        }
        if (phone!=""){
            map.put("phone", phone);
        }
        if (tname!=""){
            map.put("tname", tname);
        }
        if (status>0){
            map.put("status", status);
        }
        if (email!=""){
            map.put("email", email);
        }
        if (info!=""){
            map.put("info", info);
        }
        return teacherService.addTeacher(map);
    }
}
