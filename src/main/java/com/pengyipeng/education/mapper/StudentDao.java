package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.vo.StudentVo;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xinhai
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.mapper
 * @date 2020/1/8 14:26 星期三
 */
@Mapper
public interface StudentDao {
    StudentVo checkStuByUserId(@Param("userid") int userid);

}
