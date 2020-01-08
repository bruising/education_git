package com.pengyipeng.education.util.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * @author 孙敬轩
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.util.qiniu
 * @Description: 七牛云文件上传
 *               在Controller层实例此对象进行方法调用
 * @date 2020 年 01 月 08 13:13 星期三
 */
public class QNUtil implements InitializingBean {

    /**
     * 获取上传管理对象
     */
    @Resource
    private UploadManager uploadManager;

    /**
     * 获取存储区域管理对象
     */
    @Resource
    private BucketManager bucketManager;

    /**
     * 获取上传对象
     */
    @Resource
    private Auth auth;

    /**
     * 获取文件存储域
     */
    @Value("${qiniu.bucketName}")
    private String bucket;

    /**
     * 文件上传实例
     * 注：StringMap此类在com.qiniu.util包下并不是org.apache.logging.log4j.util包
     */
    private StringMap putPolicy;

    /**
     * 上传文件
     * @param inputStream   文件输入流
     * @param fileName      文件名称， 可为空（null）
     *
     *                      此方法可以的到一个七牛云的Response
     *                      所以可以在Controller中将此方法返回值使用Response接收
     *                      但是必须传入一个带有文件的输入流
     *                      前端浏览器上传文件的话可以在Controller使用MutipartFile接收并直接调getInputStream传入此方法
     *                      之后使用DefaultPutRet类并通过Gson将Response中的bodyString进行格式转换得到想要的信息
     *                      最终的到DefaultPutRet类
     *
     *                      Response对象中可以通过属性statusCode获取上传后的状态码判断是否成功
     *                      也可以通过DefaultPutRet的key、hash属性获取上传之后的服务器存储路径 以及文件名称
     *
     *                      注：一、七牛云存储如果 不指定key的值默认为文件的hash值所以默认通过DefaultPutRet得到的hash是上传文件时的文件hash值
     *                          二、七牛云的Response所在的包在com.qiniu.http包下
     * @return 返回一个七牛云的com.qiniu.http包下的Response对象
     * @throws QiniuException
     *
     *          异常信息可以异常处理中使用QiniuException 获取异常信息
     *          如getMessage() 获取所有异常信息
     *              error()获取具体的错误信息
     *              code() 错误的状态码
     *          等
     */
    public Response uploadFile(InputStream inputStream, String fileName) throws QiniuException {
        // 七牛云的相应信息，
        // 参数（承载文件的输入流， 上传到服务器的文件名， 回传信息）
        Response response = uploadManager.put(inputStream, fileName, getToken(fileName), null, null);
        // 尝试次数
        int tryTimes = 0;
        // needRetry()需要尝试
        while (response.needRetry() && tryTimes < 3) {
            response = uploadManager.put(inputStream, fileName, getToken(fileName), null, null);
            tryTimes++;
        }
        // 返回上传后的相应信息
        return response;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
    }

    private String getToken(String fileName) {
        return this.auth.uploadToken(bucket, fileName, 3600, putPolicy);
    }
}