package com.pengyipeng.education.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/9 19:06 星期四
 */
public interface AddCourseTime {

    /**
     * 将课次信息存放到数据库中
     * @param classKind 课程类型
     * @param className  课程名称
     * @param classTarget 课程目标
     * @param classVideoAddress  视频地址
     * @return
     */
        int addCourseTime(@Param("courseId") String courseId,@Param("classKind") String classKind,@Param("className") String className,@Param("classTarget") String classTarget,@Param("classVideoAddress") String classVideoAddress);

}
