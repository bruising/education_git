package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.vo.TeacherVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 胡婷婷
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/6 17:03 星期一
 */
public interface TeacherService {

    /**
     * 根据条件返回教师信息
     * @param map 查询条件
     * @return 教师信息
     */
    Result selectTeacherMessage(Map<String, Object> map);

    /**
     * 修改教师的状态
     * @param status 修改后状态
     * @return 修改是否成功
     */
    Result updateTeacherStatus(Integer status, String tid);

    /**
     * 新增教师
     * @param map 教师信息
     * @return 新增结果
     */
    Result addTeacher(Map<String, Object> map);
}
