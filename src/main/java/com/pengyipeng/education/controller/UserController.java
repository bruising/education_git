package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.service.UserService;
import com.pengyipeng.education.util.MD5;
import com.pengyipeng.education.util.RedisUtils;
import com.pengyipeng.education.util.UserAgentUtils;
import cz.mallat.uasparser.UserAgentInfo;
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
public class UserController {


    @Resource
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/loginByPwd")
    @ResponseBody
    public String  loginByPwd(User_Manager user_manager ,HttpServletRequest request)throws Exception{
        String ua=request.getHeader("User-Agent");
        System.out.println("ua:"+ua);
        UserAgentInfo userAgentInfo= UserAgentUtils.uaSparser.parse(ua);
        String type=userAgentInfo.getDeviceType();
        Object[] loginResult=this.login(user_manager,type);
        System.out.println(loginResult==null);
        if (loginResult==null){
           request.setAttribute("shibai","shibai");

            return "login";
        }else{
            User_Manager user=( User_Manager)loginResult[0];
            int status=user.getPayment_status();
            if(1==status){
                return "#1";
            }else if(2==status){
                return "#2";
            }else {
                return "#3";
            }
        }

    }

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
    @RequestMapping( value="/chazhao1", method= RequestMethod.POST, produces="application/json;charset=UTF-8" )
    public void chazhao1(int userid,HttpServletResponse response) {
        String key="user"+userid;

        Boolean flag=redisUtils.exists(key);
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
        if ((tokenValue=(String)redisUtils.get(tokenKey))!=null){
            redisUtils.delete(tokenKey);
            redisUtils.delete(tokenValue);
        }
        redisUtils.set(tokenKey,token,30000);
        redisUtils.set(token, JSON.toJSONString(user_manager),30000);
    }

}
