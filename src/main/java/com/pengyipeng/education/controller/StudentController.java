package com.pengyipeng.education.controller;

import com.pengyipeng.education.model.vo.StudentVo;
import com.pengyipeng.education.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author xinhai
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.controller
 * @date 2020/1/8 15:54 星期三
 */

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 账号管理中的(学生)个人信息
     * @param userid
     * @param model
     * @return
     */
    @RequestMapping(value = "/checkStuByUserId")
    public String checkStuByUserId(@RequestParam(value = "mark",required = false,defaultValue = "show")String mark,@RequestParam(value = "userid",defaultValue = "2")int userid, Model model){
        StudentVo studentVo=studentService.checkStuByUserId(userid);
        model.addAttribute("user",studentVo);
        System.out.println(studentVo.getUserPhoto());
        if("update".equals(mark)){
            return "updateInfo";
        }else {
            return "userinfo";
        }
    }
}
