package com.pengyipeng.education.controller;

import com.google.gson.Gson;
import com.pengyipeng.education.util.qiniu.QNUtil;
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

import java.io.IOException;

@Controller
public class QNController {

    @Value("${qiniu.path}")
    private String path;

    @RequestMapping("/")
    public String init(){
        return "house";
    }

    /**
     * 文件上传
     * @param file
     * @param model
     * @return
     */
    @PostMapping("/fileUpload")
    public String shangchuan(@RequestParam("file") MultipartFile file,
                             Model model){
        QNUtil qnUtil = new QNUtil();
        Response response= null;
        try {
            // 获取七牛上传后的响应
            response = qnUtil.uploadFile(file.getInputStream(), file.getOriginalFilename());
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
        } catch (QiniuException e) {
            // 获取异常信息原因以及异常状态码
            model.addAttribute(e.error(), e.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "aaa";
    }

}
