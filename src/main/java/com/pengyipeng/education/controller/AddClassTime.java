package com.pengyipeng.education.controller;

import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.service.AddClassTimeService;
import com.pengyipeng.education.util.qiniu.QNUtil;
import com.pengyipeng.education.util.redis.RedisUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/9 16:17 星期四
 */
@Controller
@Api(tags = "添加课次和课程，作者：韩帅龙")
public class AddClassTime {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private QNUtil qnUtil;

    @Resource
    private AddClassTimeService service;

    @RequestMapping("/addclasstimes")
    public String init(){
        return "addclasstime";
    }


    /**
     * 添加课次
     * @param classKind 课程类型
     * @param className 课程名称
     * @param classTarget 课程目标
     * @param mp4File 课程视频
     * @return 返回json字符串
     */
    @ApiOperation(value = "输入课次类型，名称，目标，视频地址",notes = "获取添加是否成功")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classKind",value = "calssKind",dataType = "String",example = "正课"),
            @ApiImplicitParam(name = "className",value = "className",dataType = "String",example = "java从入门到如土1"),
            @ApiImplicitParam(name = "classTarget",value = "classTarget",dataType = "String",example = "放弃"),
            //@ApiImplicitParam(name = "mp4File",value = "mp4File",paramType = "formData",required = true,dataType = "file")
    })
    @ApiResponses({
            @ApiResponse(code = 500,message = "添加课次失败"),
            @ApiResponse(code = 200,message = "成功")

    })
    @PostMapping(value = "/addclasstime",headers = "content-type=multipart/form-data")
    @ResponseBody
    public Result addClassTime(String classKind, String className, String classTarget, @RequestParam(value = "mp4File", required = true)MultipartFile mp4File){
        //获取redis 里的课程id
          String courseId = (String) redisUtil.get("course_id");
//        System.out.println("从redis里获取到的courseid是"+courseId);
//        System.out.println("课程类别是"+classKind);
//        System.out.println("课程名称是"+className);
//        System.out.println("课程目标是"+classTarget);
//        System.out.println("视频文件是"+mp4File);
        String classVideoAddress = this.upload(mp4File);
   //     System.out.println(classVideoAddress);
        Result result = new Result();
        int i = service.addClassTime(courseId, classKind, className, classTarget, classVideoAddress);
        if (i > 0){
            System.out.println("添加成功");

            result.setCode(200);
            result.setMessage("添加成功");
            result.setData(classVideoAddress);
        }else{
            result.setCode(500);
            result.setMessage("添加失败");
        }


        //测试是否能返回视频的地址

        return result;
    }


    /**
     * 上传 视频， 接收路径
     * @param mp4File
     * @return
     */
    public String upload(MultipartFile mp4File) {
        try {
            String mp4url = qnUtil.fileUpload(mp4File.getInputStream(), mp4File.getOriginalFilename());
            return mp4url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将信息从redis 里拿出来存放到 数据库中
     * @return
     */
    public Result addCourse(){

        Result result = new Result();
        return  result;
    }





}
