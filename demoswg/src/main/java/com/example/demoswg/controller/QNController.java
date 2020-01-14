package com.example.demoswg.controller;

import com.example.demoswg.service.QNService;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demoswg
 * @Package com.example.demoswg.controller
 * @date 2020/1/8 11:53 星期三
 */
@Controller
public class QNController {
    @Autowired
    private QNService qnService;
    @Value("http://q3rk7n8j4.bkt.clouddn.com")
    private String path;

    @RequestMapping("/init")
    public  String init(){
        return "house";
    }
    @PostMapping("/shangchuan")
    public String shangchuan(@RequestParam("file")MultipartFile file)throws Exception{
        Response response=qnService.uploadFile(file.getInputStream());
        DefaultPutRet putRet=new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        String url=path+"/"+putRet.key;
        System.out.println(url);
        return  "aaa";
    }
}
