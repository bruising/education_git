package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.vo.CourseProjectTeacherStudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 郭新龙
 * @version V1.0
 * @Project education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/8 14:42 星期三
 */
@Mapper
public interface MyCoursesDao {
    List<CourseProjectTeacherStudentVO> selectMyCourses(@Param("sid") Integer sid);

}
