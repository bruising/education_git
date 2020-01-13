package com.pengyipeng.education.model.bo;

import lombok.Data;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.bo
 * @date 2020/1/13 17:16 星期一
 */
@Data
public class AddOrder {
    /**
     * 订单id
     */
    private int orderId;
    /**
     * 课程id
     */
    private int courseId;
    /**
     * 订单流水号
     */
    private String orderTradeNo;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 订单价格
     */
    private double orderPrice;
    /**
     * 支付方式
     */
    private int payment;

    public AddOrder() {
    }

    public AddOrder(int courseId, String orderTradeNo, int userId, double orderPrice, int payment) {
        this.courseId = courseId;
        this.orderTradeNo = orderTradeNo;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.payment = payment;
    }
}
