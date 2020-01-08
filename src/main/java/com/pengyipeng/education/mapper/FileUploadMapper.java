package com.pengyipeng.education.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author 孙敬轩
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @Description:  文件上传
 * @date 2020 年 01 月 08 12:09 星期三
 */
public interface FileUploadMapper {
    Integer insertFilePath(@Param(value = "path")String path, @Param(value = "name")String name);
}