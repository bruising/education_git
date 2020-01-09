package com.pengyipeng.education.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zengli
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/9 16:40 星期四
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStudentVo {
    private Integer userid;
    private  String userPhoto,pProgress,name,img,createDate,courseName;

}
