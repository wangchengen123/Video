package com.zhiyou.test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.70.128",6379);
		jedis.set("k1","v1");
		String value = jedis.get("k1");
		System.out.println("从redis中获得值:"+value);
		jedis.close();
	}
	
}
