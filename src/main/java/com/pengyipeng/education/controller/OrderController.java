package com.pengyipeng.education.controller;

import com.alibaba.fastjson.JSON;
import com.pengyipeng.education.model.entity.Order;
import com.pengyipeng.education.model.entity.OrderRefund;
import com.pengyipeng.education.model.entity.Result;
import com.pengyipeng.education.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * 订单
 *
 * @author : djz
 * @date : Created in  2020/1/4 16:56
 */
@Api(tags = "订单管理 狄建泽")
@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;


    /**
     * 添加订单(补录)
     *
     * @param order 订单内容 除订单id和订单状态其他都传入
     * @return r
     */
    @ApiOperation("增加订单(补录)接口")
    @ApiResponses({
            @ApiResponse(code = 201, message = "无结果"),
            @ApiResponse(code = 200, message = "成功")
    })
    @PostMapping("add")
    public Result add(Order order) {
        Result result = new Result();
        boolean b = orderService.addOrder(order);
        if (b) {
            result.setCode(200);
            result.setData("插入成功");
            result.setMessage("success");
            return result;
        }
        result.setCode(201);
        result.setData("插入失败");
        result.setMessage("fail");
        return result;
    }


    /**
     * 查询订单
     *
     * @param courseName 订单名(模糊)
     * @param status     订单状态(0删除 1待支付 2取消支付 3已过期 4完成支付 5退款中 6完成退款)
     * @param createTime 创建时间
     * @param pageNo     当前页
     * @param pageSize   每页展示
     * @return r
     */
    @ApiOperation("动态查询订单接口")
    @ApiResponses({
            @ApiResponse(code = 201, message = "无结果"),
            @ApiResponse(code = 200, message = "成功")
    })
    @PostMapping("query")
    public Result query(String courseName, String status, Date createTime, Integer pageNo, Integer pageSize) {
        Result result = new Result();
        Map<String, Object> map = orderService.queryOrder(courseName, status, createTime, pageNo, pageSize);
        if (map == null) {
            result.setCode(201);
            result.setData("无结果");
            result.setMessage("fail");
            return result;
        }
        result.setCode(200);
        result.setData(JSON.toJSONString(map));
        result.setMessage("success");
        return result;
    }


    /**
     * 查询订单详细信息根据id
     *
     * @param orderId id
     * @return order
     */
    @ApiOperation("查询订单详细信息根据id接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "orderId", dataType = "int", example = "1"),
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "查询失败"),
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("queryOrderById")
    public Result queryOrderById(int orderId) {
        Result result = new Result();
        Order order = orderService.queryOrderById(orderId);
        if (order == null) {
            result.setCode(201);
            result.setData("查询失败");
            result.setMessage("fail");
            return result;
        }
        result.setCode(200);
        result.setData(JSON.toJSONString(order));
        result.setMessage("success");
        return result;
    }

    /**
     * 查询退费订单详细信息根据id
     *
     * @param orderId id
     * @return order
     */
    @ApiOperation("查询退费订单详细信息根据id接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "orderId", dataType = "int", example = "1"),
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "查询失败"),
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("queryOrderRefundById")
    public Result queryOrderRefundById(int orderId) {
        Result result = new Result();
        OrderRefund orderRefund = orderService.queryOrderRefundById(orderId);
        if (orderRefund == null) {
            result.setCode(201);
            result.setData("查询失败");
            result.setMessage("fail");
            return result;
        }
        result.setCode(200);
        result.setData(JSON.toJSONString(orderRefund));
        result.setMessage("success");
        return result;
    }
}
