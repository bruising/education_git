package com.pengyipeng.education.service.impl;


import cn.hutool.core.util.PageUtil;
import com.pengyipeng.education.mapper.OrderDao;
import com.pengyipeng.education.model.entity.Order;
import com.pengyipeng.education.model.entity.OrderRefund;
import com.pengyipeng.education.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : djz
 * @date : Created in  2020/1/8 15:36
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 动态查询分页+课程查询+状态查询+创建订单时间
     */
    @Override
    public Map<String, Object> queryOrder(String courseName, String status, Date createTime, Integer pageNo, Integer pageSize) {
        int count = orderDao.countOrder(courseName, status, createTime);
        int start = PageUtil.getStart(pageNo, pageSize);
        int totalPage = PageUtil.totalPage(count, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("data", orderDao.queryOrder(courseName, status, createTime, start, pageSize));
        map.put("count", count);
        map.put("totalPage", totalPage);
        return count > 0 ? map : null;
    }

    /**
     * 增加订单(补录功能)
     *
     * @param order 订单内容 除订单id和订单状态其他都传入
     * @return b
     */
    @Override
    public boolean addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    /**
     * 查询订单详细信息根据id
     *
     * @param orderId id
     * @return order
     */
    @Override
    public Order queryOrderById(int orderId) {
        return orderDao.queryOrderById(orderId);
    }

    /**
     * 查询退费订单详细信息根据id
     *
     * @param orderId id
     * @return OrderRefund
     */
    @Override
    public OrderRefund queryOrderRefundById(int orderId) {
        return orderDao.queryOrderRefundById(orderId);
    }
}
