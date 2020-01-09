package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.Project;

import java.util.List;

public interface ProjectDaoService {

    List<Project> getProgect(String name, String startDate, String overDate, Integer flag, Integer page, Integer limit);
    Integer getCount(String name, String startDate, String overDate, Integer flag, Integer page, Integer limit);
    Integer updateFlag(Integer id, Integer flag);
    Integer updateShowOrder(Integer id, Integer showOrder);
}
