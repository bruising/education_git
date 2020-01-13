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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
     * 添加课程
     * 从redis里拿出值
     * @return
     */
    @ApiOperation(value = "添加课程基本信息" )
    @ApiResponses({
            @ApiResponse(code = 500,message = "添加课程失败"),
            @ApiResponse(code = 200,message = "添加课程成功")

    })
    @PostMapping("addCourseinfro")
    @ResponseBody
    public Result addCourse(){
        //李陈写的从redisd里拿出 课程的信息
        Map<String,Object> map=new HashMap<>();
        String course_name=(String) redisUtil.get("course_name");
       // System.out.println("课程的名称是"+course_name);
        map.put("course_name",course_name);
        String course_price= (String) redisUtil.get("course_price");
        //System.out.println("课程的价格是"+course_price);
        map.put("course_price",course_price);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date course_date=null;
        String s=(String) redisUtil.get("course_date");
        try {
            course_date=simpleDateFormat.parse(s);
          //  System.out.println("课程的创建日期是"+course_date);
            map.put("course_date",course_date);
        } catch(ParseException px) {
            px.printStackTrace();
        }
        String course_introduce=(String) redisUtil.get("course_introduce");
       // System.out.println("课程的介绍"+course_introduce);
        map.put("course_introduce",course_introduce);
        String course_cycle=(String) redisUtil.get("course_cycle");
       // System.out.println("课程的周期"+course_cycle);
        map.put("course_cycle",course_cycle);
        String course_ability_training=(String)redisUtil.get("course_ability_training");
       // System.out.println("课程的训练能力"+course_ability_training);
        map.put("course_ability_training",course_ability_training);
        //int course_id=cid();
        // redisUtils.set("course_id",course_id+"");
        String course_id=(String) redisUtil.get("course_id");
       // System.out.println("课程的id"+course_id);
        map.put("course_id",course_id);
//        int sort=addCourseService.selectCourse_sort();
//        int course_sort=sort+1;
//        redisUtils.set("course_sort",course_sort+"");
        String course_sort=(String)redisUtil.get("course_sort") ;
       // System.out.println("课程的顺序"+course_sort);
        map.put("course_sort",course_sort);
        String course_pic = (String)redisUtil.get("course_pic");
       // System.out.println("课程的头像路径是"+course_pic);
        map.put("course_pic",course_pic);

        int i = service.addCourseinfor(map);
        Result result = new Result();
        if (i > 0){
            System.out.println("课程信息添加成功");

            result.setCode(200);
            result.setMessage("课程添加成功");
            result.setData("课程的名称是"+course_name+"课程的价格是"+course_price+"课程的创建日期是"+course_date+"课程的介绍"+course_introduce+
                    "课程的周期"+course_cycle+ "课程的训练能力"+course_ability_training+ "课程的id"+course_id+"课程的顺序"+course_sort+"课程的头像路径是"+course_pic);
            return  result;
        }else{
            System.out.println("课程信息添加失败");
            result.setCode(500);
            result.setMessage("添加课程失败");
            return result;
        }



    }


    /**
     * 添加课程的任课老师
     * @return
     */
  @ApiOperation(value = "添加课程的任课老师")
  @ApiResponses({
          @ApiResponse(code=200,message = "添加成功"),
          @ApiResponse(code=500,message = "添加失败")
  })
  @PostMapping(value = "addCourseTeacher")
  @ResponseBody
   public Result addCourseTeache(){
        //李陈写的 从redis里拿出来转成 数组
       String steacher_id=(String) redisUtil.get("teacher_id");
       String course_id = (String)redisUtil.get("course_id");
//       System.out.println("拿到的教师id是"+steacher_id);
//       System.out.println("拿到的课程id是"+course_id);
       String[] arr = steacher_id.split(","); // 用,分割
 //      System.out.println("数组是"+arr);

       int a ;
       int i=0;
       for(a=0;a<arr.length;a++){
           String teacher_id = arr[a];
            i = service.addCourseTeacher(teacher_id, course_id);
       }
       if(i > 0){
           Result result = new Result();
           result.setCode(200);
           result.setData(i+"");
           result.setMessage("添加成功");
           return result;
       }else{
           Result result = new Result();
           result.setCode(500);
           result.setData(i+"");
           result.setMessage("添加失败");
           return result;
       }


   }


    /**
     * 添加课程的的项目
     * @return
     */
   @ApiOperation(value = "添加课程的项目")
   @ApiResponses({
           @ApiResponse(code=200,message = "添加成功"),
           @ApiResponse(code=500,message = "添加失败")
   })
   @PostMapping("addCourseProject")
   @ResponseBody
   public Result addCourseProject(){
        //获取项目的id
       String sproject_id = (String) redisUtil.get("project_id");
       //System.out.println("课程的项目是"+sproject_id);
       String course_id = (String)redisUtil.get("course_id");
       //System.out.println("课程id是"+course_id);
       String[] arr =sproject_id.split(",");
       int a ;
       int i=0;
       Result result = new Result();
       for(a=0;a<arr.length;a++){
           String project_id = arr[a];
            i = service.addCourseProject(project_id, course_id);
       }

       if (i > 0 ){
           result.setCode(200);
           result.setData(i+"");
           result.setMessage("添加成功");
           return result;
       }else{
           result.setCode(500);
           result.setData(i+"");
           result.setMessage("添加失败");
           return result;
       }

   }


    /**
     * 添加课程的适用阶段
     * @return
     */
   @ApiOperation(value = "添加课程的适用阶段")
   @ApiResponses({
           @ApiResponse(code = 200,message = "添加成功"),
           @ApiResponse(code = 500,message = "添加失败")
   })
   @PostMapping("addCourseApplyphase")
   @ResponseBody
   public Result addCourseApplyphase(){
       //适应阶段的id
       String sapply_phase_id = (String)redisUtil.get("apply_phase_id");
       String course_id = (String)redisUtil.get("course_id");
       String[] arr =sapply_phase_id.split(",");
       int a ;
       int i=0;
       Result result = new Result();
       for(a=0;a<arr.length;a++){
           String apply_phase_id = arr[a];
           i = service.addCourseApplyphase(course_id, apply_phase_id);
       }
       if (i > 0 ){
           result.setCode(200);
           result.setData(i+"");
           result.setMessage("添加成功");
           return result;
       }else{
           result.setCode(500);
           result.setData(i+"");
           result.setMessage("添加失败");
           return result;
       }
   }






}
