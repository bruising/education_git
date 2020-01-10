package com.pengyipeng.education.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : djz
 * @date : Created in  2020/1/8 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private int orderId;
    private String orderTradeNo;
    private String courseName;
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
     * 状态
     */
    private int status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 支付时间
     */
    private Date payTime;
}
