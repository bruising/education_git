package com.pengyipeng.education.service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.pengyipeng.education.model.vo.StudentMangerVo;
import com.pengyipeng.education.model.vo.StudentProjectCourseVo;

import java.util.List;
import java.util.Map;

/**
 * @author 庞冉
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/6 16:08 星期一
 */
public interface StudentManagerService {
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
