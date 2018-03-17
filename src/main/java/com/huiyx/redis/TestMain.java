package com.huiyx.redis;

import redis.clients.jedis.Jedis;

public class TestMain
{
	public static void main(String[] args)
	{
		Jedis jedis = new Jedis("47.93.220.39",6379);
		jedis.auth("123456");
		System.out.println("连接成功");
		jedis.set("name","zhang san");
		System.out.println(jedis.get("name"));
		jedis.hset("person","name","lixiang");
		jedis.hset("person","adds","中国北京");

		System.out.println(jedis.hget("person","adds"));
	}


}
