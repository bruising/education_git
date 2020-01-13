package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.SupplementaryStudentDao;
import com.pengyipeng.education.model.entity.StudentManagement;
import com.pengyipeng.education.model.entity.User_Manager;
import com.pengyipeng.education.service.SupplementaryStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/10 22:00 星期五
 */
@Service
public class SupplementaryStudentServiceImpl implements SupplementaryStudentService {
    @Resource
    private SupplementaryStudentDao supplementaryStudentDao;

    @Override
    public List<User_Manager> getUserByNicknameOrPhone(String nickname, String phone) {
        List<User_Manager> list=supplementaryStudentDao.getUserByNicknameOrPhone(nickname,phone);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public List<StudentManagement> getStudentByUserid(int userid) {
        List<StudentManagement> list=supplementaryStudentDao.getStudentByUserid(userid);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public int addStudentByUserid(int userid, String sname, String birth) throws  Exception{
        int status=supplementaryStudentDao.addStudentByUserid(sname,getAge(parse(birth)),parse(birth));
        supplementaryStudentDao.addUser_stu_teacher(userid,supplementaryStudentDao.getMaxSid());
        if (status>0){
            return 1;
        }
        return -1;
    }

    @Override
    public int addSupplementaryStudentByCourse_id(int course_id, int sid, String payment_method, double payment_price) {
        int status=supplementaryStudentDao.addSupplementaryStudentByCourse_id(course_id,sid,payment_method,payment_price);
        if (status>0){
            return 1;
        }
        return -1;
    }



    public static  Date parse(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=null;
        try{
             d=sdf.parse(strDate);
        } catch (Exception e){
            e.printStackTrace();
        }
        return d;
    }
    public static  int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            }else{
                age--;//当前月份在生日之前，年龄减一
            } } return age; }
}
