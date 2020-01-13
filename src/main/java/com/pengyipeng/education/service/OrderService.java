package com.pengyipeng.education.service;

import com.pengyipeng.education.model.entity.Order;
import com.pengyipeng.education.model.entity.OrderRefund;
import com.pengyipeng.education.model.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : djz
 * @date : Created in  2020/1/8 15:36
 */
public interface OrderService {
    /**
     * 动态查询分页+课程查询+状态查询+创建订单时间
     */
    Map<String, Object> queryOrder(String courseName, String status, Date createTime, Integer pageNo, Integer pageSize);

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
