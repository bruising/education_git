package com.pengyipeng.education.util.PageNto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页工具类
 * @author 宁坤
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
