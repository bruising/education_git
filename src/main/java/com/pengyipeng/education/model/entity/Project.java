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
    private String createDate;//创建时间
    private Integer showOrder;//显示顺序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getApplyPhaseId() {
        return applyPhaseId;
    }

    public void setApplyPhaseId(Integer applyPhaseId) {
        this.applyPhaseId = applyPhaseId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public Integer getStuCount() {
        return stuCount;
    }

    public void setStuCount(Integer stuCount) {
        this.stuCount = stuCount;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
}
