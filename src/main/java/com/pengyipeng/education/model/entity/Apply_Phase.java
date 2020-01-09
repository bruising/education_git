package com.pengyipeng.education.model.entity;
/**
 * @author 李陈
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.vo
 * @date 2020/1/6 19:12 星期一
 */

/**
 * 课程适应阶段实体类（Apply_Phase ）
 */
public class Apply_Phase {
    private  int id;
    /*
    适应阶段
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apply_Phase(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Apply_Phase() {
    }

    @Override
    public String toString() {
        return "Apply_Phase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
