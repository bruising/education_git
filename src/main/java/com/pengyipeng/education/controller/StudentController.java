package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.vo.StudentVo;
import com.pengyipeng.education.service.QNService;
import com.pengyipeng.education.service.StudentService;
import com.pengyipeng.education.util.qiniu.QNUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author xinhai
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/8 15:54 星期三
 */

@Controller
@Api(tags = "账号管理中的(学生)个人信息-zhaoxinhai")
public class StudentController {

    @Value("${qiniu.path}")
    private String path;

    @Resource
    private QNService qnService;
    @Resource
    private StudentService studentService;

    /**
     * 账号管理中的(学生)个人信息
     * @param userid
     * @param model
     * @return
     */
    @ApiOperation(value = "根据用户编号查询个人信息", notes = "查询到实体，返回给前端")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mark", value = "进行展示还是修改的标记", dataType = "String", example = "show"),
            @ApiImplicitParam(name = "userid", value = "用户的id号", dataType = "String", example = "2")
    })
    @GetMapping(value = "/checkStuByUserId")
    public String checkStuByUserId(@RequestParam(value = "mark",required = false,defaultValue = "show")String mark,@RequestParam(value = "userid",defaultValue = "2")int userid, Model model){
        StudentVo studentVo=studentService.checkStuByUserId(userid);
        model.addAttribute("user",studentVo);
        Result result = new Result();
        result.setData(JSON.toJSONString(studentVo));
        //System.out.println(studentVo.getUserPhoto());
        if("update".equals(mark)){
            return "updateInfo";
        }else {
            return "userinfo";
        }
    }


    /**
     * 修改信息，头像上传
     * @param file
     * @param model
     * @return
     */
    @ApiOperation(value = "修改个人信息", notes = "前端提交个人信息数据，后台保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "头像文件", dataType = "file"),
    })
    @PostMapping("/updateInfo")
    public String update(@RequestParam("file") MultipartFile file, StudentVo stu,Model model) throws  Exception{
        int userid=stu.getUserid();
        Response response=qnService.uploadFile(file.getInputStream());
        DefaultPutRet putRet=new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        String url =path+"/"+putRet.key;
        stu.setUserPhoto(url);
        model.addAttribute("url",url);
        System.out.println(url);
        studentService.updateInfo(stu);
        return "redirect:checkStuByUserId?userid="+userid;
    }
}
