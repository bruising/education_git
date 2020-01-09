package com.pengyipeng.education.model.entity;

//<<<<<<< Updated upstream
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    /**
     * 项目实体类
     * author：牛
     */
    private Integer id;//索引ID
    private String projectNo;//项目ID
    private Integer applyPhaseId;//适用阶段
    private String img;//项目图片
    private String name;//项目名称
    private String intro;//项目简介
    private Integer codeId;//项目代码ID
    private Integer stuCount;//参与学生人数
    private Integer courseCount;//关联课程数量
    private Integer flag;//状态 1-显示 -1隐藏
    private Date createDate;//创建时间
    private Integer showOrder;//显示顺序

}
