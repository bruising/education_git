package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.vo.CourseVO;
import com.pengyipeng.education.model.vo.ProStuUserVO;

import java.util.List;

/**
 * 项目管理 service 接口
 * 作者：牛ys
 */
public interface ProjectDaoService {

    List<Project> getProgect(String name, String startDate, String overDate, Integer flag, Integer page, Integer limit);
    Integer getCount(String name, String startDate, String overDate, Integer flag);
    Integer updateFlag(Integer id, Integer flag);
    Integer updateShowOrder(Integer id, Integer showOrder);
    //按照项目ID查询项目信息
    List<Project> getProjectById(Integer id);
    //按学生姓名或无条件 查询学生  （模糊查找）
    List<ProStuUserVO> getStuUser(Integer id, String sname, Integer page, Integer limit);
    //按学生姓名或无条件 查询学生  （模糊查找）的总数量
    Integer getStuCount(Integer id, String sname);
    //按 项目ID 查询 项目信息 （与课程相关的）
    List<Project> getProById(Integer id);
    //按课程名称或无条件 查询课程  （模糊查找、需要分页）
    List<CourseVO> getCourseByPro(Integer id, String course_name, Integer page, Integer limit);
    //通过项目ID 查询相关的课程信息
    List<CourseVO> queryCourseNameByProjectId(Integer id);
    //按课程名称或无条件 查询课程  （模糊查找、需要分页）的总数量
    Integer getCourseCount(Integer id, String course_name);
}
