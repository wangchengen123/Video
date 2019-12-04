package com.zhiyou.test;

import com.alibaba.fastjson.JSONObject;
import com.zhiyou.model.User;

/**
 * 
 * @author Administrator
 * 对象转json字符串
 * json字符串转对象
 */
public class TestFastjson {
	public static void main(String[] args) {
		
		User user = new User(111,"张三","2323");
		
		//对象转json字符串
		String jsonString = JSONObject.toJSONString(user);
		System.out.println(jsonString);
		
		// json字符串转对象
		User user2 = (User)JSONObject.parseObject(jsonString,User.class);
		System.out.println(user2);
		
	}
}
