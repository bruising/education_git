package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Apply_Phase;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.entity.TeacherManage;
import com.pengyipeng.education.service.AddCourseService;
import com.pengyipeng.education.util.redis.RedisUtil;
import com.pengyipeng.education.util.qiniu.QNUtil;
import com.qiniu.http.Response;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/7 10:29 星期二
 */
@Controller
@Api(tags = "添加课程信息，放入缓存-李陈")
public class AddCourseController {


    @Resource
    private AddCourseService addCourseService;
    @Resource
    private RedisUtil redisUtils;
    @Resource
    private QNUtil qnUtil;

    @ApiOperation(value = "输入课程信息",notes = "对了返回true，错了就返回false")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_name", value = "课程名称", dataType = "String", example = "贪吃蛇"),
            @ApiImplicitParam(name = "course_price", value = "课程价格", dataType = "Double", example = "156.9"),
            @ApiImplicitParam(name = "course_introduce", value = "课程简介", dataType = "String", example = "123456"),
            @ApiImplicitParam(name = "course_cycle", value = "教学周期", dataType = "String", example = "8周"),
            @ApiImplicitParam(name = "course_ability_training", value = "能力培养", dataType = "String", example = "动手能力"),
            //@ApiImplicitParam(name = "course_pic", value = "course_pic", dataType = "String", example = "Http://www.budai.com"),
            @ApiImplicitParam(name = "project_id", value = "项目id数组",allowMultiple = true,paramType = "query", dataType = "int", example ="[1,2]"),
            @ApiImplicitParam(name = "apply_phase_id", value = "适应阶段数组",allowMultiple = true, paramType = "query", dataType = "int", example = "[1,2]"),
            @ApiImplicitParam(name = "teacher_id", value = "教师id数组",allowMultiple = true,paramType = "query", dataType = "String", example = "['T2937','T2938']")

            //@ApiImplicitParam(name = "name", value = "name", dataType = "String", example = ""),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "添加课程失败"),
            @ApiResponse(code = 200,message = "成功")

    })

    @PostMapping(value = "/saveCourseByRedis" )
    @ResponseBody
    public Result saveCourseByRedis(

                                  @RequestParam("teacher_id")String[] tid,
                                  @RequestParam("project_id")int[] id,
                                  @RequestParam("apply_phase_id")int[] apply_phase_id,
                                  @RequestParam("course_name")String course_name,
                                  @RequestParam("course_price")double course_price,

                                  @RequestParam("course_introduce")String course_introduce,
                                  @RequestParam("course_cycle")String course_cycle,
                                  @RequestParam("course_ability_training")String course_ability_training
                                  //@RequestParam("course_pic")String course_pic
                                  ){
        redisUtils.set("course_name",course_name);
        redisUtils.set("course_price",course_price+"");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String  date=simpleDateFormat.format(new Date());
        redisUtils.set("course_date",date);
        redisUtils.set("course_introduce",course_introduce);
        redisUtils.set("course_cycle",course_cycle);
        redisUtils.set("course_ability_training",course_ability_training);
        //redisUtils.set("course_pic",course_pic);

        int course_id=cid();
        redisUtils.set("course_id",course_id+"");
        int sort=addCourseService.selectCourse_sort();
        int course_sort=sort+1;
        redisUtils.set("course_sort",course_sort+"");

        //String[] arr = { "0", "1", "2", "3", "4", "5" };
        // 遍历
        StringBuffer str5 = new StringBuffer();
        for (int s :apply_phase_id ) {
            str5.append(s+",");
        }
        System.out.println(str5.toString()); // 012345
        StringBuffer str1 = new StringBuffer();
        for (int s :id ) {
             str1.append(s+",");
        }
        System.out.println(str1.toString()); // 012345
        StringBuffer str2 = new StringBuffer();
        for (String s :tid ) {
            str2.append(s+",");
        }
        System.out.println(str2.toString()); // 012345
        redisUtils.set("project_id",str1.toString());
        redisUtils.set("teacher_id",str2.toString());
        redisUtils.set("apply_phase_id",str5.toString());
        Result result=new Result();
        result.setCode(200);
        result.setMessage("已放入缓存");
        // result.setData("true");
        return result;
    }
    public int cid(){
        int c=createCourse_id();
        while(addCourseService.getCourse(c)==-1){
            c=createCourse_id();
        }
        return c;
    }
    public int createCourse_id(){
        int course_id=0;

        int intFlag = (int)(Math.random() * 100000);

        String flag = String.valueOf(intFlag);
        if (flag.length() == 5 && flag.substring(0, 1).equals("9"))
        {
             course_id=intFlag+181000000;
            //redisUtils.set("course_id",course_id+"");
        }
        else {
            intFlag = intFlag + 10000;
             course_id=intFlag+181000000;
            //redisUtils.set("course_id",course_id+"");
        }
        return course_id;
    }
    //@RequestMapping("/addCourse_applyphase")
//    public void addCourse_applyphase(@RequestParam("course_id")int course_id,@RequestParam("apply_phase_id")int[] apply_phase_id){
//        Map<String,Object> map=new HashMap<>();
//        for (int i=0;i<apply_phase_id.length;i++){
//            map.put("course_id",course_id);
//            map.put("apply_phase_id",apply_phase_id[i]);
//            int status=addCourseService.addCourse_applyphase(map);
//        }
//    }

    /**
     * 查询项目
     * @param pname
     * @return
     */
    @ApiOperation(value = "根据项目名称查询项目信息",notes = "查询成功返回查询结果，错了就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "project_name", value = "项目名称", dataType = "String", example = "街"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "添加项目失败"),
            @ApiResponse(code = 200,message = "成功")

    })
    @PostMapping(value = "/getProject")
    @ResponseBody
    public Result getProject(@RequestParam("project_name") String pname){
        List<Project> list=addCourseService.getProject(pname);
        String result2= JSON.toJSONString(list);
        Result result=new Result();
        result.setCode(200);
        result.setMessage("项目信息");
        result.setData(result2);
        System.out.println(result2);
//        response.setContentType("text/json; charset=utf-8");
//        PrintWriter out;
//        try {
//            out = response.getWriter();
//            out.print(result);
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return result;
    }

    /**
     * 查询适应阶段
     * @param request
     */
    @PostMapping (value = "/getApply_phase")
    public void getApply_phase( HttpServletRequest request){
        List<Apply_Phase> list=addCourseService.getApply_phase();
        request.setAttribute("AList",list);
    }

    /**
     * 查询老师
     * @param tname
     * @return
     */
    @ApiOperation(value = "根据老师姓名查询老师信息",notes = "查询成功返回查询结果，错了就返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacher_name", value = "老师姓名", dataType = "String", example = "王"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "查询老师失败"),
            @ApiResponse(code = 200,message = "成功")

    })

    @PostMapping (value = "/getTeacher")
    @ResponseBody
    public Result getTeacher(@RequestParam("teacher_name") String tname){
        List<TeacherManage> list=addCourseService.getTeacher(tname);
        String result1= JSON.toJSONString(list);
        Result result=new Result();
        result.setCode(200);
        result.setMessage("老师信息");
        result.setData(result1);
        System.out.println(result1);
        return result;
    }

    /**
     * 文件上传
     * @param pcFile
     * @return
     */

    @ApiOperation(value = "文件信息",notes = "查询成功返回url，错了就返回字符串")
    @ApiImplicitParams({
            //@ApiImplicitParam(name = "teacher_name", value = "teacher_name", dataType = "String", example = "王"),
    })
    @ApiResponses({
            @ApiResponse(code = 123,message = "上传失败"),
            @ApiResponse(code = 200,message = "上传成功")

    })
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    @ResponseBody
    public Result upload(@RequestParam(value = "pcFile")MultipartFile pcFile
                         ) {
        Result result=new Result();
        try {
            String url = qnUtil.fileUpload(pcFile.getInputStream(), pcFile.getOriginalFilename());
            redisUtils.set("course_pic",url);
            System.out.println(url);

            result.setCode(200);
            result.setMessage("上传路径信息");
            result.setData(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
