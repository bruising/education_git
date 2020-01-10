package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.vo.ProStuUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: test
 * @ClassName: ProjectDao
 * @Description: TODO(项目管理部分的接口)
 * @Author: 牛岩松
 * @Date: 2020/1/8
 */
@Mapper
public interface ProjectDao {
    //查询展示项目
    List<Project> getProgect(@Param("name") String name, @Param("startDate") String startDate, @Param("overDate") String overDate, @Param("flag") Integer flag, @Param("page") Integer page, @Param("limit") Integer limit);
    //查询所需的总数量 （需考虑按条件查询后的）
    Integer getCount(@Param("name") String name, @Param("startDate") String startDate, @Param("overDate") String overDate, @Param("flag") Integer flag);
    //修改项目状态（1 显示 -1 隐藏）
    Integer updateFlag(@Param("id") Integer id, @Param("flag") Integer flag);
    //修改项目顺序
    Integer updateShowOrder(@Param("id") Integer id, @Param("showOrder") Integer showOrder);
    //验证修改的项目顺序是否重复以及该项目是否隐藏
    Project yzShowOrder(@Param("id") Integer id);
    //按照项目ID查询项目信息(与学生相关的)
    List<Project> getProjectById(@Param("id") Integer id);
    //按学生姓名或无条件 查询学生  （模糊查找）
    List<ProStuUserVO> getStuUser(@Param("id") Integer id, @Param("sname") String sname, @Param("page") Integer page, @Param("limit") Integer limit);
    //按学生姓名或无条件 查询学生  （模糊查找）的总数量
    Integer getStuCount(@Param("id") Integer id, @Param("sname") String sname);
    //按 项目ID 查询 项目信息 （与课程相关的）
    List<Project> getProById(@Param("id") Integer id);
    //按课程名称或无条件 查询课程  （模糊查找、需要分页）
    List<Course> getCourseByPro(@Param("id") Integer id, @Param("course_name") String course_name, @Param("page") Integer page, @Param("limit") Integer limit);
    //按课程名称或无条件 查询课程  （模糊查找、需要分页）的总数量
    Integer getCourseCount(@Param("id") Integer id, @Param("course_name") String course_name);
}
