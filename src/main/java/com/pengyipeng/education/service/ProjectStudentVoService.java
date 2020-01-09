package com.pengyipeng.education.service;

import com.pengyipeng.education.model.vo.ProjectStudentVo;
import com.pengyipeng.education.model.vo.ProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zengli
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service
 * @date 2020/1/9 15:46 星期四
 */
public interface ProjectStudentVoService {
    List<ProjectStudentVo> getProject(@Param("studenrId")String studenrId);
}
