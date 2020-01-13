package com.pengyipeng.education.util;

import java.text.SimpleDateFormat;

/**
 * @author 姚顺
 * @version V1.0
 * @Project: education
 * @Package com.pengyipeng.education.util.CreateTradeNoUtil
 * @date 2020/1/6 18:36 星期一
 */
public class CreateTradeNoUtil {


	public static String getAccountRandom20() {
		return getGuid();
		
	}
	
	private static volatile int Guid=100;
	private static String getGuid() {
		CreateTradeNoUtil.Guid+=1;
		long now = System.currentTimeMillis();  
		//获取4位年份数字  
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");  
		//获取时间戳  
		String time=dateFormat.format(now);
		String info=now+"";
		//获取三位随机数  
		//int ran=(int) ((Math.random()*9+1)*100); 
		//要是一段时间内的数据连过大会有重复的情况，所以做以下修改
		int ran=0;
		if(CreateTradeNoUtil.Guid>999){
			CreateTradeNoUtil.Guid=100;
		}
		ran= CreateTradeNoUtil.Guid;
		return time+info+ran;
	}

    /**
     * 测试案例
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 2000; i++) {
			System.out.println(getAccountRandom20());
		}
	}
}
