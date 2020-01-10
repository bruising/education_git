package com.pengyipeng.education.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王青
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.model.entity
 * @date 2020/1/10 13:47 星期五
 */
@ApiModel(description = "返回总用户数 新增用户数  新增付费用户数  活跃用户数")
public class UserMangerResult {
    @ApiModelProperty(value = "总用户数")
   private  int   AllUserCount;
    @ApiModelProperty(value = "新增用户数")
   private int addUserUserCountEveyDay;
    @ApiModelProperty(value = "新增付费用户数")
   private int addPaymentUserCountEveryDay;
    @ApiModelProperty(value = "活跃用户数")
   private  int activeUserCount;

    public int getAllUserCount() {
        return AllUserCount;
    }

    public void setAllUserCount(int allUserCount) {
        AllUserCount = allUserCount;
    }

    public int getAddUserUserCountEveyDay() {
        return addUserUserCountEveyDay;
    }

    public void setAddUserUserCountEveyDay(int addUserUserCountEveyDay) {
        this.addUserUserCountEveyDay = addUserUserCountEveyDay;
    }

    public int getAddPaymentUserCountEveryDay() {
        return addPaymentUserCountEveryDay;
    }

    public void setAddPaymentUserCountEveryDay(int addPaymentUserCountEveryDay) {
        this.addPaymentUserCountEveryDay = addPaymentUserCountEveryDay;
    }

    public int getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(int activeUserCount) {
        this.activeUserCount = activeUserCount;
    }
}
