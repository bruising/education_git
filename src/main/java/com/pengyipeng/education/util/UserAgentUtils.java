package com.example.demo.utils;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;

import java.io.IOError;
import java.io.IOException;
/**
 * @author 吕继伟
 * @version V1.0
 * @Project: 11
 * @Package com.example.demo.entity
 * @date 2020/1/6 12:14 星期一
 */
public class UserAgentUtils {

    public static UASparser uaSparser=null;

    static {
        try {
            uaSparser=new UASparser(OnlineUpdater.getVendoredInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String request="";

        try {
            UserAgentInfo userAgentInfo=UserAgentUtils.uaSparser.parse(request);
            System.out.println(userAgentInfo.getDeviceType());
            System.out.println(userAgentInfo.getOsName());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
