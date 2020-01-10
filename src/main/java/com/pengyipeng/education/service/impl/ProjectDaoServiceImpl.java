package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.ProjectDao;
import com.pengyipeng.education.model.entity.Course;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.vo.ProStuUserVO;
import com.pengyipeng.education.service.ProjectDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectDaoServiceImpl implements ProjectDaoService {
    @Resource
    private ProjectDao projectDao;

    @Override
    public List<Project> getProgect(String name, String startDate, String overDate, Integer flag, Integer page, Integer limit) {
        return projectDao.getProgect(name, startDate, overDate, flag,(page-1)*limit, limit);
    }

    @Override
    public Integer getCount(String name, String startDate, String overDate, Integer flag) {
        return projectDao.getCount(name, startDate, overDate, flag);
    }

    @Override
    public Integer updateFlag(Integer id,Integer flag) {
        return projectDao.updateFlag(id,flag);
    }

    @Override
    public Integer updateShowOrder(Integer id, Integer showOrder) {
        return projectDao.updateShowOrder(id, showOrder);
    }

    @Override
    public List<Project> getProjectById(Integer id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public List<ProStuUserVO> getStuUser(Integer id, String sname,Integer page, Integer limit) {
        return projectDao.getStuUser(id, sname, (page-1)*limit, limit);
    }

    @Override
    public Integer getStuCount(Integer id, String sname) {
        return projectDao.getStuCount(id, sname);
    }

    @Override
    public List<Project> getProById(Integer id) {
        return projectDao.getProById(id);
    }

    @Override
    public List<Course> getCourseByPro(Integer id, String course_name, Integer page, Integer limit) {
        return projectDao.getCourseByPro(id, course_name, (page-1)*limit, limit);
    }

    @Override
    public Integer getCourseCount(Integer id, String course_name) {
        return projectDao.getCourseCount(id, course_name);
    }
}
