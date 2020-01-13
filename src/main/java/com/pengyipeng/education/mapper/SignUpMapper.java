package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.bo.AddOrder;
import com.pengyipeng.education.model.bo.AddStudentBo;
import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.vo.CourseVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper.sign_up
 * @date 2020/1/6 20:09 星期一
 */
@Mapper
public interface SignUpMapper {

    public CourseVO getCouseById(@Param("course_id") int course_id);

    public List<StudentManagement> getStudentManagementByUserId(@Param("userid") int userid);

    public StudentManagement getStudentManagementBySId(@Param("sid") int sid);

    public CourseVO getCourseByCId(@Param("cid") int cid);

    public int addStudentManagement(@Param("addStudent") AddStudentBo addStudent);

    public int addUserStuTeacher(@Param("addStudent") AddStudentBo addStudent);

    public int addOrder(@Param("addOrder") AddOrder addOrder);

    public int updateOrder(@Param("status") int status, @Param("orderId") int orderId, @Param("payPrice") double payPrice);

    public int addCourseStudent(@Param("cid") int cid, @Param("sid") int sid, @Param("payPrice") double payPrice);

}
