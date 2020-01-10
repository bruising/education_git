package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.entity.UserMangerResult;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.model.vo.User_TeacherVo;
import com.pengyipeng.education.service.User_ManagerService;
import com.pengyipeng.education.util.PageNto.PageNto;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

/**
 * @author 宁坤
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller.User_ManagerController
 * @Description:用户管理的controller层
 */
@RestController
@Api(tags = "这是宁坤写的用户管理")
public class User_ManagerController {

    @Resource
    private User_ManagerService ums;


    @ApiOperation(value = "根据查询条件返回用户的信息",notes = "成功返回用户数据，失败返回提示字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name="phone",value = "phone",dataType = "String",example = "13405485400"),
            @ApiImplicitParam(name="latest_login_time",value = "latest_login_time",dataType = "String",example = "yyyy-MM-dd"),
            @ApiImplicitParam(name="payment_status",value = "payment_status",dataType = "Integer",example = "1"),
            @ApiImplicitParam(name="registration_time",value = "registration_time",dataType = "String",example = "yyyy-MM-dd"),
            @ApiImplicitParam(name="pageindex",value = "pageindex",dataType = "Integer",example = "1"),
            @ApiImplicitParam(name="pagecount",value = "pagecount",dataType = "Integer",example = "4"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "未找到符合该条件的信息"),
            @ApiResponse(code = 200,message = "找到符合该条件的信息"),
    })
    @PostMapping(value = "/getUser")
    public Result  getUserByPhoneAndLogintimeAndpayment_statusAndregistration_time(
            @RequestParam(name = "phone",required = false) String phone,
            @RequestParam(name = "latest_login_time",required = false) String latest_login_time,
            @RequestParam(name = "payment_status",required = false)String payment_status,
            @RequestParam(name = "registration_time",required = false)String registration_time,
            @RequestParam(name = "pageindex",required = false,defaultValue = "1")Integer pageindex,
            @RequestParam(name = "pagecount",required = false,defaultValue = "5")Integer pagecount,
            Model model){
        //获取分页对象
        PageNto<User_Manager> userPageNto=ums.getUserByPhoneAndLogintimeAndpayment_statusAndregistration_time(
                phone, latest_login_time, payment_status, registration_time, pageindex, pagecount);
        //判断是否有上一页
        if(pageindex>1){
            userPageNto.setHasPrevPage(true);
        }else{
            userPageNto.setHasPrevPage(false);
        }
        //获取总页数
        Integer pagetotal=userPageNto.getPagetotal();
        //获取总条数
        long total=userPageNto.getTotal();
        //判断是否有下一页
        if (pageindex>=pagetotal){
            userPageNto.setHasNextPage(false);
        }else{
            userPageNto.setHasNextPage(true);
        }
        model.addAttribute("phone",phone);
        model.addAttribute("latest_login_time",latest_login_time);
        model.addAttribute("payment_status",payment_status);
        model.addAttribute("registration_time",registration_time);
        model.addAttribute("pageindex",pageindex);
        model.addAttribute("userPageNto",userPageNto);
        model.addAttribute("pagetotal",pagetotal);
        model.addAttribute("total",total);
        Result result=new Result();
        if(userPageNto.getData().size()>0&&userPageNto.getData()!=null){
            result.setCode(200);
            result.setMessage("找到符合条件的信息");
            result.setData(JSON.toJSONString(userPageNto));
        }else{
            result.setCode(123);
            result.setMessage("未找到符合该条件的信息");
        }
        return result;
    }


    @ApiOperation(value = "根据用户id和用户类型查询用户详情",notes = "成功返回用户数据，失败返回提示字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userid",value = "userid",dataType = "Integer",example = "1"),
            @ApiImplicitParam(name="usertype",value = "usertype",dataType = "Integer",example = "0"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "未找到符合该条件的信息"),
            @ApiResponse(code = 200,message = "找到符合该条件的信息"),
    })
    @PostMapping(value = "/userdetails")
    public Result getUsrByUserid(Integer userid,Integer usertype,Model model){
        Result result=new Result();
        if(usertype==0){
            List<User_Manager>userList=ums.getUserByUserid(userid);
            model.addAttribute("userList",userList);
            if(userList!=null&&userList.size()>0){
                result.setCode(200);
                result.setMessage("找到符合该条件的用户详细信息");
                result.setData(JSON.toJSONString(userList));
            }else{
                result.setCode(123);
                result.setMessage("未找到符合该条件的用户详细信息");
            }
        }else if(usertype==1){
            User_TeacherVo userTea=ums.getTeaUserByUserid(userid);
            model.addAttribute("userTea",userTea);
            if(userTea!=null){
                result.setCode(200);
                result.setMessage("找到符合该条件的用户详细信息");
                result.setData(JSON.toJSONString(userTea));
            }else{
                result.setCode(123);
                result.setMessage("未找到符合该条件的用户详细信息");
            }

        }
        return result;
    }

    @ApiOperation(value = "查询所有用户数 每新增用户数  每天新增付费用户数  活跃用户数")

   @PostMapping("/UserManager")
    public UserMangerResult UserManager(Model  model){
        int  AllUserCount=ums.queryAllUserCount();//获取所有得用户数
        model.addAttribute("AllUserCount",AllUserCount);
        int  addUserUserCountEveyDay=ums.queryAddUserEveryday();//获取每天得新增用户数
        model.addAttribute("addUserUserCountEveyDay",addUserUserCountEveyDay);

        int addPaymentUserCountEveryDay=ums.queryAddPaymentUserCountEveryday();//获取每天得新增付费用户数
        model.addAttribute("addPaymentUserCountEveryDay",addPaymentUserCountEveryDay);
        int  activeUserCount=ums.queryActiveUserCount();//获取活跃用户数
        model.addAttribute("activeUserCount",activeUserCount);

        UserMangerResult  result=new UserMangerResult();
        result.setAllUserCount(AllUserCount);
        result.setAddUserUserCountEveyDay(addUserUserCountEveyDay);
        result.setAddPaymentUserCountEveryDay(addPaymentUserCountEveryDay);
        result.setActiveUserCount(activeUserCount);

        return result;
    }


}
