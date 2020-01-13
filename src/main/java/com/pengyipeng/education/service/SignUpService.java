package com.pengyipeng.education.service;

import com.pengyipeng.education.model.bo.AddOrder;
import com.pengyipeng.education.model.bo.AddStudentBo;
import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.vo.CourseVO;

import java.util.List;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.sign_up
 * @date 2020/1/6 18:36 星期一
 */
public interface SignUpService {

    public CourseVO getCouseById(int course_id);

    public List<StudentManagement> getStudentManagementByUserId(int userid);

    public StudentManagement getStudentManagementBySId(int sid);

    public CourseVO getCourseByCId(int cid);

    public AddStudentBo addStudentManagement(AddStudentBo addStudentManagement);

    public AddOrder addOrder(AddOrder addOrder);

    public boolean pay(int orderId, int cid, int sid, double payPrice);
}
