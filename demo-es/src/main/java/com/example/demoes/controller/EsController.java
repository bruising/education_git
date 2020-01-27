package com.example.demoes.controller;

import com.example.demoes.dao.StuDao;
import com.example.demoes.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demo-es
 * @Package com.example.demoes.controller
 * @date 2020/1/15 10:50 星期三
 */
@RestController
public class EsController {
    @Autowired
    private StuDao stuDao;
    @GetMapping("save")
    public  String save(Student student){
        stuDao.save(student);
        return "success";
    }
}
