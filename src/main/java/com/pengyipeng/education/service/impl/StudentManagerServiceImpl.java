package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.StudentManagerMapper;
import com.pengyipeng.education.model.vo.StudentMangerVo;
import com.pengyipeng.education.model.vo.StudentProjectCourseVo;
import com.pengyipeng.education.service.StudentManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 庞冉
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/6 16:09 星期一
 */
@Service
public class StudentManagerServiceImpl implements StudentManagerService {
@Resource
    StudentManagerMapper studentManagerMapper;
    public List<StudentMangerVo> studentManInforQuery(Map<String,Object> map){
        return studentManagerMapper.studentManInforQuery(map);
    }
    public List<StudentProjectCourseVo> selectProjectNameBySid(int sid){
        return studentManagerMapper.selectProjectNameBySid(sid);
    }
    public List<StudentProjectCourseVo> selectCourseNameBySid(int sid){
        return studentManagerMapper.selectCourseNameBySid(sid);
    }
    public int updateStudentPayStatus(int sid){
        return studentManagerMapper.updateStudentPayStatus(sid);
    }
}
