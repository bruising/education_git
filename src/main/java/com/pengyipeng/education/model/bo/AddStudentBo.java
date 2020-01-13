package com.pengyipeng.education.model.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.entity
 * @date 2020/1/13 09:41 星期一
 */
@Data
public class AddStudentBo {

    private int sid;//新增加的学生id   新增的学生主键将会添加到此处 并且根据该主键完成对 用户——学生——老师三者之间的关系 的添加
    private String sname; //学生姓名

    /**
     * 年龄将会根据日期获得 在sql语句中计算了年龄
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date birth;

    private int userid; //用户id

    public AddStudentBo() {
    }

    public AddStudentBo(String sname, Date birth, int userid) {
        this.sname = sname;
        this.birth = birth;
        this.userid = userid;
    }
}
