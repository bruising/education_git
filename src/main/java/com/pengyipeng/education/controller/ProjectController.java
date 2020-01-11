package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.entity.Message;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.vo.*;
import com.pengyipeng.education.service.ProjectDaoService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Niuys
 * @Date: ${DATE} ${TIME}
 * @Describe:
 */
@RestController
@Api(tags = "牛岩松")
public class ProjectController {

    @Resource
    private ProjectDaoService projectDaoService;


    @ApiOperation(value = "查询展示项目",notes="返回项目数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "项目名", dataType = "String"),
            @ApiImplicitParam(name = "startDate", value = "起始时间", dataType = "String"),
            @ApiImplicitParam(name = "overDate", value = "截止时间", dataType = "String"),
            @ApiImplicitParam(name = "flag", value = "状态码（1-显示 -1隐藏）", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", dataType = "String"),
            @ApiImplicitParam(name = "limit", value = "每页数量", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 120,message = "未找到符合该条件的信息"),
            @ApiResponse(code = 110,message = "成功")
    })
    @GetMapping(value = "/init")
    public String init(String name,String startDate,String overDate,Integer flag,Integer page,Integer limit){
        System.out.println(flag);
        Message message = new Message();
        List<Project>list=projectDaoService.getProgect(name, startDate, overDate, flag, page, limit);
        /*if(list.size()==0){
            message.setCode("120");
            message.setMsg("未找到符合该条件的信息");
            return JSON.toJSONString(message);
        }*/
        Integer count=projectDaoService.getCount(name, startDate, overDate, flag);
        ProjectVO projectVO=new ProjectVO(list,count,0,"");

        return JSON.toJSONString(projectVO);
    }
    @ApiOperation(value = "修改项目状态",notes="返回提示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", dataType = "String"),
            @ApiImplicitParam(name = "flag", value = "状态码（1-显示 -1隐藏）", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 120,message = "失败"),
            @ApiResponse(code = 110,message = "成功")
    })
    @PostMapping(value = "/updateFlag")
    public Message updateFlag(Integer id,Integer flag){
        Message message = new Message();

        if (projectDaoService.updateFlag(id, flag)>0){
            message.setCode("110");
            message.setMsg("修改成功");
        }else{
            message.setCode("120");
            message.setMsg("修改失败");
        }
        return message;
    }
    @ApiOperation(value = "修改项目顺序",notes="返回字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", dataType = "String"),
            @ApiImplicitParam(name = "showOrder", value = "显示顺序", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 120,message = "失败"),
            @ApiResponse(code = 110,message = "成功"),
            @ApiResponse(code = 130,message = "隐藏状态，显示顺序无法修改"),
            @ApiResponse(code = 140,message = "已有该顺序，换个顺序再改")
    })
    @PostMapping(value = "updateShowOrder")
    public Message updateShowOrder(Integer showOrder,Integer id){
        Integer integer = projectDaoService.updateShowOrder(id, showOrder);
        Message message = new Message();
        if (integer == 100){
            message.setCode("130");
            message.setMsg("隐藏状态，显示顺序无法修改");
        }else if(integer == 101){
            message.setCode("140");
            message.setMsg("已有该顺序，换个顺序再改");
        }else if (projectDaoService.updateShowOrder(id,showOrder) == 1){
            message.setCode("110");
            message.setMsg("修改成功");
        }else{
            message.setCode("120");
            message.setMsg("修改失败");
        }
        return message;
    }
    @ApiOperation(value = "按 项目ID 查询 项目信息（与学生相关） ",notes="项目数据")
    @PostMapping(value = "getProjectById")
    public String getProjectById(Integer id, HttpServletRequest request){
        List<Project>list=projectDaoService.getProjectById(id);

        return JSON.toJSONString(list);
    }
    @ApiOperation(value = "按学生姓名或无条件查询学生 ",notes="返回该项目报名学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", dataType = "String"),
            @ApiImplicitParam(name = "sname", value = "学生姓名", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", dataType = "String"),
            @ApiImplicitParam(name = "limit", value = "每页数量", dataType = "String")
    })
    @GetMapping(value = "getStuUser")
    public String getStuUser(Integer id,String sname,Integer page,Integer limit){
        List<ProStuUserVO>list=projectDaoService.getStuUser(id, sname,page,limit);
        Integer count = projectDaoService.getStuCount(id, sname);
        ProStuUserMesVO proStuUserMesVO = new ProStuUserMesVO(list,count,0,"");
        return JSON.toJSONString(proStuUserMesVO);
    }
    @ApiOperation(value = "按 项目ID 查询 项目信息(与课程相关) ",notes="项目数据")
    @PostMapping(value = "getProById")
    public String getProById(Integer id){
        List<Project>list=projectDaoService.getProById(id);
        return JSON.toJSONString(list);
    }
    @ApiOperation(value = "按课程名称或无条件 查询课程 ",notes="返回与该项目相关的课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", dataType = "String"),
            @ApiImplicitParam(name = "course_name", value = "课程名", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", dataType = "String"),
            @ApiImplicitParam(name = "limit", value = "每页数量", dataType = "String")
    })
    @GetMapping(value = "getCourseByPro")
    public String getCourseByPro(Integer id,String course_name,Integer page,Integer limit){
        List<CourseVO>list=projectDaoService.getCourseByPro(id, course_name, page, limit);
        Integer count = projectDaoService.getCourseCount(id, course_name);
        ProCourseVO proCourseVO = new ProCourseVO(list,count,0,"");
        System.out.println(JSON.toJSONString(proCourseVO));
        return JSON.toJSONString(proCourseVO);
    }

}
