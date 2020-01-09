package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.vo.ProjectStudentVo;
import com.pengyipeng.education.model.vo.ProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zengli
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/9 15:30 星期四
 */
public interface ProjectStudentVoDao {

    List<ProjectStudentVo> getProject(@Param("studenrId")String studenrId);
}