package com.pengyipeng.education.service.impl;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.mapper.TeacherMapper;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.vo.TeacherVo;
import com.pengyipeng.education.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 胡婷婷
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/6 17:03 星期一
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Result selectTeacherMessage(Map<String, Object> map) {
        List<TeacherVo> teachersInfo = teacherMapper.getTeacherMessage(map);
        Result result = new Result();
        if (teachersInfo!=null && teachersInfo.size()>0){
            result.setCode(200);
            result.setMessage("找到符合条件的信息");
            result.setData(JSON.toJSONString(teachersInfo));
        }else {
            result.setCode(123);
            result.setMessage("未找到符合该条件的信息");
        }
        return result;
    }

    @Override
    public Result updateTeacherStatus(Integer status, String tid) {
        Result result = new Result();
        if(teacherMapper.updateTeacherStatus(status, tid)>0){
            result.setCode(200);
            result.setMessage("教师的状态修改成功");
        }else {
            result.setCode(123);
            result.setMessage("教师的状态修改失败");
        }
        return result;
    }

    @Override
    public Result addTeacher(Map<String, Object> map) {
        Result result = new Result();
        //先确认登录账号是否存在
        int userId = teacherMapper.selectUserIsExist(map.get("email").toString(), map.get("phone").toString());
        if(userId>0){
            map.put("userId", userId);
            //添加用户头像----如果传入头像则添加，没有则不添加
            if (map.get("photo").toString() != null){
                teacherMapper.insertTeacherPhoto(map);
            }
            //添加教师
            int b = teacherMapper.insertTeacher(map);
            //添加中间表
            int c = teacherMapper.insertTeacherAndUser(map);
            if (b>0 && c>0){
                result.setCode(200);
                result.setMessage("新增教师成功");
            }else {
                result.setCode(234);
                result.setMessage("新增失败");
            }
        }else {
            result.setCode(123);
            result.setMessage("该登录账号不存在");
        }
        return result;
    }
}
