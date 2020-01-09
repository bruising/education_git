package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.MyCoursesDao;
import com.pengyipeng.education.model.vo.CourseProjectTeacherStudentVO;
import com.pengyipeng.education.service.MyCoursesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郭新龙
 * @version V1.0
 * @Project education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/8 14:52 星期三
 */
@Service
public class MyCoursesServiceImpl implements MyCoursesService {

    @Resource
    private MyCoursesDao myCoursesDao;

    @Override
    public List<CourseProjectTeacherStudentVO> selectMyCourses(Integer sid) {
        return myCoursesDao.selectMyCourses(sid);
    }
}
