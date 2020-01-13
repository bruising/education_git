package com.pengyipeng.education.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : djz
 * @date : Created in  2020/1/8 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
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
     * 实际支付价格
     */
    private double payPrice;
    /**
     * 支付方式
     */
    private int payment;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */
    private int status;
}
