package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.service.UserService;
import com.pengyipeng.education.util.MD5;
import com.pengyipeng.education.util.UserAgentUtils;
import com.pengyipeng.education.util.redis.RedisUtil;
import cz.mallat.uasparser.UserAgentInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 吕继伟
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.Controller
 * @Description:
 * @date 2020/1/4 星期六 15:48
 */
@Controller
@Api(tags = "这是吕继伟登录类")
public class UserController {


    @Resource
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(value = "进入登录")
    @RequestMapping(value = "/",method= RequestMethod.GET)
    public String login(){
        return "login";
    }
    @ApiOperation(value = "输入学号和密码，验证信息",notes = "对了就给学生数据跳转页面，错了就返回登录页面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "userid",dataType = "String",example = "2"),
            @ApiImplicitParam(name = "pwd",value = "pwd",dataType = "String",example = "123456")
    })
    @RequestMapping(value = "/loginByPwd",method= RequestMethod.POST)
    @ResponseBody
    public String  loginByPwd(User_Manager user_manager ,HttpServletRequest request)throws Exception{
        String ua=request.getHeader("User-Agent");
        System.out.println("ua:"+ua);
        UserAgentInfo userAgentInfo= UserAgentUtils.uaSparser.parse(ua);
        String type=userAgentInfo.getDeviceType();
        Object[] loginResult=this.login(user_manager,type);

        if (loginResult==null){
           request.setAttribute("shibai","shibai");

            return "login";
        }else{
            User_Manager user=( User_Manager)loginResult[0];
            int status=user.getUserstatus();
            if(1==status){
                return "#1";
            }else if(2==status){
                return "#2";
            }else {
                return "#3";
            }
        }

    }
    @ApiOperation(value = "接受学号和密码",notes = "返回md5密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "userid",dataType = "String",example = "2"),
            @ApiImplicitParam(name = "pwd",value = "pwd",dataType = "String",example = "123456")
    })
    @RequestMapping( value="/chazhao", method= RequestMethod.POST, produces="application/json;charset=UTF-8" )
    public void chazhao(String pwd,int userid,HttpServletResponse response) {
        String Md5=pwd;
        String shipwd=userService.getpwd(userid);
        String md5pwd=userService.getMd5pwd(userid);
            if (pwd.length() != 32) {
                Md5 = MD5.getMD5(pwd, 32);
            }

             if(pwd.equals(shipwd) || pwd.equals(md5pwd)) {
                 int i = userService.updateUser(userid, Md5);

             }else {
                 userService.updateUser(userid,"");
             }
            String result = JSON.toJSONString(Md5);
            response.setContentType("text/json; charset=utf-8");

            PrintWriter out;
            try {
                out = response.getWriter();
                out.print(result);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    @ApiOperation(value = "接受学号，验证信息",notes = "对返回md5密码，错无返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "userid",dataType = "String",example = "2")
    })
    @RequestMapping( value="/chazhao1", method= RequestMethod.POST, produces="application/json;charset=UTF-8" )
    public void chazhao1(int userid,HttpServletResponse response) {
        String key="user"+userid;

        Boolean flag=redisUtil.exists(key);
        System.out.println(flag);
        if(flag) {
            String Md5=userService.getMd5pwd(userid);
            String result = JSON.toJSONString(Md5);
            response.setContentType("text/json; charset=utf-8");

            PrintWriter out;
            try {
                out = response.getWriter();
                out.print(result);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Object[] login(User_Manager user_manager,String type)throws Exception{
        User_Manager stuDb= userService.getUser(user_manager.getUserid(),user_manager.getPwd());
        if (stuDb==null){
            return null;
        }
        //到这里，说明登录信息没有问题，生成token
        String token=this.createToken(stuDb, type);
        //保存
        this.saveToken(token,stuDb);
        return new Object[]{stuDb,token};
    }

    private String createToken(User_Manager user_manager,String type){
        StringBuilder builder=new StringBuilder();
        builder.append("token-");
        builder.append(type+"-");
        String info= MD5.getMD5(user_manager.getUserid().toString(),32);
        builder.append(info+"-");
        builder.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        builder.append(UUID.randomUUID().toString().substring(0,6));
        return builder.toString();
    }

    private void saveToken(String token,User_Manager user_manager){

        String tokenKey="user"+user_manager.getUserid();
        String tokenValue=null;
        if ((tokenValue=(String)redisUtil.get(tokenKey))!=null){
            redisUtil.delete(tokenKey);
            redisUtil.delete(tokenValue);
        }
        redisUtil.set(tokenKey,token,10);
        redisUtil.set(token, JSON.toJSONString(user_manager),10);
    }

}
