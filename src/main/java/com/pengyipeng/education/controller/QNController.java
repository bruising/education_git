package com.pengyipeng.education.controller;

import com.google.gson.Gson;
import com.pengyipeng.education.util.qiniu.QNUtil;
import com.pengyipeng.education.util.redis.RedisUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Controller
public class QNController {

    @Value("${qiniu.path}")
    private String path;

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private QNUtil qnUtil;


    @RequestMapping("/")
    public String init(){
        return "upload";
    }

    /**
     * 文件上传
     * @param file
     * @param model
     * @return
     */
    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file,
                             Model model){
        Response response= null;
        try {
            // 获取七牛上传后的响应
            response = qnUtil.uploadFile(file.getInputStream(), null);
            // 将响应进行gson转码
            DefaultPutRet putRet=new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            // 拼接文件在服务器的路径
            String url =path+"/"+putRet.key;
            // 获取响应状态码为200 上传成功
            if (response.statusCode == 200) {
                model.addAttribute("fileUploadStatus", "上传成功");
            } else {
                model.addAttribute("fileUploadStatus", "失败");
            }
            redisUtil.set(file.getOriginalFilename() + new Date().getTime() + "", url);
        } catch (QiniuException e) {
            // 获取异常信息原因以及异常状态码
            model.addAttribute("error", e.error());
            model.addAttribute("code", e.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "result";
    }
}
