package com.pengyipeng.education.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : djz
 * @date : Created in  2020/1/8 14:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRefund {
    /**
     * id
     */
    private int id;
    /**
     * 订单id
     */
    private int orderId;
    /**
     * 退款操作人id
     */
    private int refundOperatorId;
    /**
     * 退款流水号
     */
    private String refundTradeNo;
    /**
     * 退款备注
     */
    private int refundRemake;
    /**
     * 退款时间
     */
    private Date refundTime;
    /**
     * 退款申请原因
     */
    private String refundReason;
    /**
     * 退回金额
     */
    private double backMoney;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */
    private int refundStatus;

}