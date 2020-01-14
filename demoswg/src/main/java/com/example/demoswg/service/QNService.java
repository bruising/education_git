package com.example.demoswg.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;


import java.io.InputStream;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demoswg
 * @Package com.example.demoswg.service
 * @date 2020/1/8 11:23 星期三
 */
public interface QNService {
    Response uploadFile(InputStream inputStream)throws QiniuException;
}
