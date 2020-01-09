package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Message;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.vo.ProjectVO;
import com.pengyipeng.education.service.ProjectDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "牛岩松")
public class ProjectController {
    @Resource
    private ProjectDaoService projectDaoService;
    @ApiOperation(value = "查询展示项目",notes="返回项目数据")
    @ApiResponses({
            @ApiResponse(code = 120,message = "失败"),
            @ApiResponse(code = 110,message = "成功")
    })
    @RequestMapping(value = "/init")
    public String init(String name,String startDate,String overDate,Integer flag,Integer page,Integer limit){
        System.out.println(flag);
        Message message = new Message();
        List<Project>list=projectDaoService.getProgect(name, startDate, overDate, flag, page, limit);
        Integer count=projectDaoService.getCount(name, startDate, overDate, flag, page, limit);
        ProjectVO projectVO=new ProjectVO(list,count,0,"");

        return JSON.toJSONString(projectVO);
    }
    @RequestMapping(value = "/updateFlag")
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
    @RequestMapping(value = "updateShowOrder")
    public Message updateShowOrder(Integer showOrder,Integer id){
        Message message = new Message();
        if (projectDaoService.updateShowOrder(id,showOrder)>0){
            message.setCode("110");
            message.setMsg("修改成功");
        }else{
            message.setCode("120");
            message.setMsg("修改失败");
        }
        return message;
    }

}
