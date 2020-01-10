package com.pengyipeng.education.util.PageNto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页工具类
 * @author 宁坤
 */

public class PageNto<T> {
    //总条数
    private long total;
    //当前页
    private Integer pageindex;
    //每页的条数
    private Integer pagecount;
    //总页数
    private Integer pagetotal;
    //每页的数据
    private List<T> data;
    //是否有上一页
    private boolean hasPrevPage=false;
    //是否有下一页
    private boolean hasNextPage=false;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getPageindex() {
        return pageindex;
    }

    public void setPageindex(Integer pageindex) {
        this.pageindex = pageindex;
    }

    public Integer getPagecount() {
        return pagecount;
    }

    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }

    public Integer getPagetotal() {
        return pagetotal;
    }

    public void setPagetotal(Integer pagetotal) {
        this.pagetotal = pagetotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isHasPrevPage() {
        return hasPrevPage;
    }

    public void setHasPrevPage(boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
