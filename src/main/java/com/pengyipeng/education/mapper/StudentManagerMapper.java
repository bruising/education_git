package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.vo.StudentMangerVo;
import com.pengyipeng.education.model.vo.StudentProjectCourseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 庞冉
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/6 16:00 星期一
 */
@Mapper
public interface StudentManagerMapper {
    /**
     *查询
     */
    public List<StudentMangerVo> studentManInforQuery(Map<String,Object> map);
    /**
     *查询该学生参与项目
     */
    public List<StudentProjectCourseVo> selectProjectNameBySid(int sid);
    /**
     *查询该学生报名课程
     */
    public List<StudentProjectCourseVo> selectCourseNameBySid(int sid);


}
