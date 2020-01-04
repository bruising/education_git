package com.pengyipeng.education.util.upload;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.URLUtils;

/**
 * @author 孙敬轩
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.util.upload
 * @Description: 七牛云对象存储
 * @date 2020/1/4 15:35 星期六
 */
public class Upload {

    /**
     * 生成
     * @return
     */
    public Mac getMac() {
        // 设置	AccessKey
        Config.ACCESS_KEY = "jmoE4b3EUTpzGAM455LFA2HKHK3Vhi_FT27NkCu0";
        // 设置 SecretKey
        Config.SECRET_KEY = "GujMYZPlnYLmXCnsqeDMSnIR-ilc_wYHyjG3t_RE";
        // 创建mac对象
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 返回mac对象
        return mac;
    }
}
