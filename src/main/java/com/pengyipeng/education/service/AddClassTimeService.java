package com.pengyipeng.education.service;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/9 19:43 星期四
 */
public interface AddClassTimeService {

    /**
     * service接口
     * @param courseId
     * @param ClassKind
     * @param ClassName
     * @param classTarget
     * @param classVideoAddress
     * @return
     */
    int addClassTime(String courseId,String ClassKind,String ClassName,String classTarget,String classVideoAddress);
}
