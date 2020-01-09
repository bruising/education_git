package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.vo.ProStuUserVO;
import org.apache.ibatis.annotations.Param;

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
    List<ProStuUserVO> getStuUser(Integer id,String sname,Integer page,Integer limit);
    //按学生姓名或无条件 查询学生  （模糊查找）的总数量
    Integer getStuCount(Integer id,String sname);
}
