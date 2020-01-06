package com.pengyipeng.education.mapper;


import com.pengyipeng.education.model.vo.CourseStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程搜索
 * 作者 ：韩帅龙
 */
@Mapper
public interface SearchcourseDao {
    /**
     * 查询所有的课程
     * @return
     */
    List<CourseStudentVo> SearchCourse();


    /**
     * 根据条件搜索
     * @param course_name
     * @param course_date
     * @param course_status
     * @return
     */
    List<CourseStudentVo> SearchCourseBycondition(@Param(value = "name") String course_name, @Param(value = "date") String course_date, @Param(value = "status") String course_status);


    /**
     * 根据课程id下架课程
     * @return
     */
    int lshelfBycourse_id(@Param(value = "course_id") String course_id);

}
