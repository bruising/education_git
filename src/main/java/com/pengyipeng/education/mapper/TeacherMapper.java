package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.entity.TeacherManage;
import com.pengyipeng.education.model.vo.TeacherUserVo;
import com.pengyipeng.education.model.vo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 胡婷婷
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/6 15:50 星期一
 */
@Mapper
public interface TeacherMapper {

    /**
     * 根据条件返回教师信息
     * @param map 查询条件
     * @return 教师信息
     */
    List<TeacherVo> getTeacherMessage(Map<String, Object> map);

    /**
     * 修改教师的状态
     * @param status 修改后状态
     * @return 修改是否成功
     */
    int updateTeacherStatus(@Param("status") Integer status, @Param("tid") String tid);

    /**
     * 确认登录账号是否存在
     * @param email 登录账号
     * @param phone 手机号
     * @return 用户信息
     */
    TeacherUserVo selectUserIsExist(@Param("email") String email, @Param("phone") String phone);

    /**
     * 确认教师ID是否存在
     * @param tid 教师ID
     * @return 教师信息
     */
    TeacherManage selectTeacherIsExist(@Param("tid") String tid);

    /**
     * 新增教师头像
     * @param map 教师信息
     * @return 新增结果
     */
    int insertTeacherPhoto(Map<String, Object> map);

    /**
     * 新增教师
     * @param map 教师信息
     * @return 新增结果
     */
    int insertTeacher(Map<String, Object> map);

    /**
     * 新增教师与用户的中间表
     * @param map 教师信息
     * @return 新增结果
     */
    int insertTeacherAndUser(Map<String, Object> map);

    /**
     * 修改教师头像
     * @param map 教师信息
     * @return 修改结果
     */
    int updateTeacherPhoto(Map<String, Object> map);

    /**
     * 修改教师
     * @param map 教师信息
     * @return 修改结果
     */
    int updateTeacher(Map<String, Object> map);
}
