package com.pengyipeng.education.service.impl;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.mapper.TeacherMapper;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.model.entity.TeacherManage;
import com.pengyipeng.education.model.vo.TeacherUserVo;
import com.pengyipeng.education.model.vo.TeacherVo;
import com.pengyipeng.education.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
            result.setMessage("未找到符合该条件的信息，或教师暂时没有授课");
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
        StringBuilder message = new StringBuilder();
        //先确认登录账号是否存在
        TeacherUserVo teacher = teacherMapper.selectUserIsExist(map.get("email").toString(), map.get("phone").toString());
        if(teacher!=null){
            map.put("userId", teacher.getUserid());
            //添加用户头像----如果传入头像则添加，没有则不添加
            if (map.get("photo").toString() != null){
                teacherMapper.insertTeacherPhoto(map);
            }
            String tid = "";
            TeacherManage teacherExist = null;
            do {
                //生成tid
                tid = "T" + ((int)(Math.random() * 10000) + 1000);
                //判断生成的tid是否已经存在
                teacherExist = teacherMapper.selectTeacherIsExist(tid);
            }while (teacherExist!=null);
            map.put("tid", tid);
            //添加教师
            int b = teacherMapper.insertTeacher(map);
            //添加中间表
            int c = teacherMapper.insertTeacherAndUser(map);
            if (b>0 && c>0){
                if (map.get("uploadStatus").toString().equals("failed")){
                    message.append("头像上传失败，");
                }
                message.append("新增教师成功");
                result.setCode(200);
                result.setMessage(message.toString());
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

    @Override
    public Result updateTeacherInfo(Map<String, Object> map) {
        Result result = new Result();
        StringBuilder message = new StringBuilder();
        //修改用户头像、手机号----如果传入头像则修改，没有则只修改手机号
        int a = teacherMapper.updateTeacherPhoto(map);
        //修改教师信息
        int b = teacherMapper.updateTeacher(map);
        if (a>0 && b>0){
            if (map.get("uploadStatus").toString().equals("failed")){
                message.append("头像修改失败，");
            }
            message.append("修改成功");
            result.setCode(200);
            result.setMessage(message.toString());
        }else {
            result.setCode(123);
            result.setMessage("修改失败");
        }
        return result;
    }
}
