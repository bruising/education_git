package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.AddCourseDao;
import com.pengyipeng.education.model.entity.Apply_Phase;
import com.pengyipeng.education.model.entity.Project;
import com.pengyipeng.education.model.entity.Teacher;
import com.pengyipeng.education.service.AddCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/7 10:10 星期二
 */
@Service
public class AddCourseServiceImpl implements AddCourseService {
    @Resource
    private AddCourseDao addCourseDao;
    @Override
    public List<Project> getProject(String pname) {
        List<Project> list=addCourseDao.getProject(pname);
        if (list!=null&& list.size()>0) {
            return list;
        }
        return null;
    }

    @Override
    public List<Apply_Phase> getApply_phase() {
        List<Apply_Phase> list=addCourseDao.getApply_phase();
        if (list!=null&& list.size()>0) {
            return list;
        }
        return null;
    }

    @Override
    public List<Teacher> getTeacher(String tname) {
        List<Teacher> list=addCourseDao.getTeacher(tname);
        if (list!=null&& list.size()>0) {
            return list;
        }
        return null;
    }

    @Override
    public int addCourse(Map<String,Object> map) {
        int status=addCourseDao.addCourse(map);
        if (status>0){
            return 1;
        }
        return -1;
    }

    @Override
    public int addCourse_applyphase(Map<String,Object> map) {
        int status=addCourseDao.addCourse_applyphase(map);
        if (status>0){
            return 1;
        }
        return -1;
    }

    @Override
    public int addCourse_project(Map<String,Object> map) {
        int status=addCourseDao.addCourse_project(map);
        if (status>0){
            return 1;
        }
        return -1;
    }

    @Override
    public int addCourse_teacher(Map<String,Object> map) {
        int status=addCourseDao.addCourse_teacher(map);
        if (status>0){
         return 1;
        }
        return -1;
    }

    @Override
    public int selectCourse_sort() {
        int sort=addCourseDao.selectCourse_sort();
        return sort;
    }
}
