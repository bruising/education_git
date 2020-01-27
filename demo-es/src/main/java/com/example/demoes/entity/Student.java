package com.example.demoes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demo-es
 * @Package com.example.demoes.entity
 * @date 2020/1/15 09:43 星期三
 */
@Document(indexName = "bd10",type = "students",shards = 1,replicas = 0)
public class Student {
    @Id
    private Long sid;

    private String sname;
    private  int sage;
    private int xuefen;

    private String desc;

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getXuefen() {
        return xuefen;
    }

    public void setXuefen(int xuefen) {
        this.xuefen = xuefen;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
