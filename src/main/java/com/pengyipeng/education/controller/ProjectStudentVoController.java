package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.vo.ProjectStudentVo;
import com.pengyipeng.education.service.ProjectStudentVoService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengli
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/9 15:48 星期四
 */


@Controller
@Api(tags = "我的学习中心--我都项目列表（zengli）")
public class ProjectStudentVoController {
    @Resource
    private ProjectStudentVoService ps;

    @ApiOperation(value = "根据学生编号studentid,获取当前学生所选项目",notes = "返回所选项目数据")
    @ApiImplicitParam(name = "studentid",value = "studentid",dataType = "String",example = "00001")
    @RequestMapping(value = "getProject",method = RequestMethod.GET)
    @ResponseBody
    public String getProject(@RequestParam(value = "studentid",required = false,defaultValue = "00001") String studentid){
        List<ProjectStudentVo> list=ps.getProject(studentid);
        return JSON.toJSONString(list);
    }

}
