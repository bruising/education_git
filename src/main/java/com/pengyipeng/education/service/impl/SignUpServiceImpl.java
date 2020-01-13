package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.SignUpMapper;
import com.pengyipeng.education.model.bo.AddOrder;
import com.pengyipeng.education.model.bo.AddStudentBo;
import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.vo.CourseVO;
import com.pengyipeng.education.service.SignUpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.sign_up.impl
 * @date 2020/1/6 18:38 星期一
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    @Resource
    private SignUpMapper signUpMapper;

    /**
     * 根据课程id获取到该课程
     * @param course_id
     * @return 课程
     */
    @Override
    public CourseVO getCouseById(int course_id) {
        return signUpMapper.getCouseById(course_id);
    }

    /**
     * 根据用户id获取到与其相关的所有学生信息
     * @param userid
     * @return
     */
    @Override
    public List<StudentManagement> getStudentManagementByUserId(int userid){
        return signUpMapper.getStudentManagementByUserId(userid);
    }

    /**
     * 根据学生id找到学生的信息
     * @param sid
     * @return
     */
    @Override
    public StudentManagement getStudentManagementBySId(int sid) {
        return signUpMapper.getStudentManagementBySId(sid);
    }

    /**
     * 根据课程id找到课程信息
     * @param cid
     * @return
     */
    @Override
    public CourseVO getCourseByCId(int cid) {
        return signUpMapper.getCourseByCId(cid);
    }


    /**
     * 根据添加学生类添加学生 需要添加两个表  利用了事务
     * 返回一个学生编号 如果为0则说明失败
     * @param addStudentManagement
     * @return
     */
    @Override
    @Transactional
    public AddStudentBo addStudentManagement(AddStudentBo addStudentManagement) {
        boolean flag = true;
        try{
            int count = signUpMapper.addStudentManagement(addStudentManagement); //添加了一次学生信息 返回值应该是1
            if(count > 0){
                int sid = addStudentManagement.getSid(); //返回自增主键
                count = signUpMapper.addUserStuTeacher(addStudentManagement); //添加了一次用户、学生、教师三者之间的联系 应该是1
            }
            if(count == 0){
                flag = false;
            }
        }catch (Exception e){
            flag = false;
        }
        if(!flag){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
        return addStudentManagement;
    }

    @Override
    public AddOrder addOrder(AddOrder addOrder){
        int count = signUpMapper.addOrder(addOrder);
        return addOrder;
    }

    /**
     * 假支付
     * @param orderId
     * @param cid
     * @param sid
     * @param payPrice
     * @return
     */
    @Override
    @Transactional
    public boolean pay(int orderId, int cid, int sid, double payPrice) {
        boolean flag = false;
        int count = signUpMapper.updateOrder(4,orderId,payPrice);
        if(count > 0){
            count = signUpMapper.addCourseStudent(cid, sid, payPrice);
        }
        if(count != 0){
            return true;
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return flag;
    }


}
