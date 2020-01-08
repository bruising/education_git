package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.ProjectDao;
import com.pengyipeng.education.model.entity.Project;
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
    public Integer getCount(String name, String startDate, String overDate, Integer flag, Integer page, Integer limit) {
        return projectDao.getCount(name, startDate, overDate, flag, page, limit);
    }

    @Override
    public Integer updateFlag(Integer id,Integer flag) {
        return projectDao.updateFlag(id,flag);
    }

    @Override
    public Integer updateShowOrder(Integer id, Integer showOrder) {
        return projectDao.updateShowOrder(id, showOrder);
    }
}
