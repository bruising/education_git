package com.pengyipeng.education.mapper;

import com.pengyipeng.education.model.entity.Order;
import com.pengyipeng.education.model.entity.OrderRefund;
import com.pengyipeng.education.model.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author : djz
 * @date : Created in  2020/1/8 14:01
 */
@Mapper
public interface OrderDao {


    /**
     * 动态查询分页+课程查询+状态查询+创建订单时间
     *
     * @param courseName 课程名
     * @param status     状态
     * @param createTime 创建时间
     * @param start      1
     * @param pageSize   1
     * @return list
     */
    List<OrderVo> queryOrder(@Param("courseName") String courseName,
                             @Param("status") String status,
                             @Param("createTime") Date createTime,
                             @Param("start") Integer start,
                             @Param("pageSize") Integer pageSize);

    /**
     * 计算总数
     *
     * @param courseName
     * @param status
     * @param createTime
     * @return
     */
    int countOrder(@Param("courseName") String courseName,
                   @Param("status") String status,
                   @Param("createTime") Date createTime);


    /**
     * 增加订单(补录功能)
     *
     * @param order 订单内容 除订单id和订单状态其他都传入
     * @return b
     */
    boolean addOrder(Order order);


    /**
     * 查询订单详细信息根据id
     *
     * @param orderId id
     * @return order
     */
    Order queryOrderById(int orderId);

    /**
     * 查询退费订单详细信息根据id
     *
     * @param orderId id
     * @return OrderRefund
     */
    OrderRefund queryOrderRefundById(int orderId);
}
