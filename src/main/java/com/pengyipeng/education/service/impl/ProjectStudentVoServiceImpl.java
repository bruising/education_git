package com.pengyipeng.education.service.impl;

import com.pengyipeng.education.mapper.ProjectStudentVoDao;
import com.pengyipeng.education.model.vo.ProjectStudentVo;
import com.pengyipeng.education.model.vo.ProjectVO;
import com.pengyipeng.education.service.ProjectStudentVoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengli
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.service.impl
 * @date 2020/1/9 15:47 星期四
 */
@Service
public class ProjectStudentVoServiceImpl implements ProjectStudentVoService {
    @Resource
    private ProjectStudentVoDao pd;

    @Override
    public List<ProjectStudentVo> getProject(String studenrId) {
        return pd.getProject(studenrId);
    }
}
