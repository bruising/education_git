package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.vo.CourseStudentUserVo;

import java.util.List;

/**
 * @author 韩帅龙
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/11 15:20 星期六
 */
public interface StudentInforByCourseID {

    /**
     * 通过课程id 查询报名该课程的学生信息
     * @param courseId
     * @return
     */
    List<CourseStudentUserVo> showStudendinforBycourseId(String courseId);

}
