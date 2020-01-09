package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: test
 * @ClassName: ProjectDao
 * @Description: TODO(项目管理部分的接口)
 * @Author: 牛岩松
 * @Date: 2020/1/8
 */
@Mapper
public interface ProjectDao {
    //查询展示项目
    List<Project> getProgect(@Param("name") String name, @Param("startDate") String startDate, @Param("overDate") String overDate, @Param("flag") Integer flag, @Param("page") Integer page, @Param("limit") Integer limit);
    //查询所需的总数量 （需考虑按条件查询后的）
    Integer getCount(@Param("name") String name, @Param("startDate") String startDate, @Param("overDate") String overDate, @Param("flag") Integer flag, @Param("page") Integer page, @Param("limit") Integer limit);
    //修改项目状态（1 显示 -1 隐藏）
    Integer updateFlag(@Param("id") Integer id, @Param("flag") Integer flag);
    //修改项目顺序
    Integer updateShowOrder(@Param("id") Integer id, @Param("showOrder") Integer showOrder);
    //
}
