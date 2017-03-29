package com.alitag.redis_tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import redis.clients.jedis.Client;
import redis.clients.jedis.ShardedJedis;

public class RedisTests {

	@Test
	public void test() {
		RedisConfig redisConfig = new RedisConfig();
		redisConfig.addHost("192.168.10.1", 6379);
		redisConfig.addHost("192.168.10.2", 6379, "123456");
		System.out.println(redisConfig.getShards());
		JedisCache jedisCache = new JedisCache(redisConfig);
		ShardedJedis shardedJedis = jedisCache.getShardedJedis();
		System.out.println(shardedJedis);
		for (int i = 0; i < 100; i++) {
			Client client = shardedJedis.getShard(String.valueOf(Thread.currentThread().getId())+"_"+(i++)).getClient();
			// 一致性哈希分片, 从运行结果中可以看到,不同的key被分配到不同的Redis-Server上去(结果与Redis-Server添加的顺序有关)
			System.out.println(client.getHost() + ":" + client.getPort());
		}
	}

	@Test
	public void testMap() {
		RedisConfig redisConfig = new RedisConfig();
		redisConfig.addHost("127.0.0.1", 6379);
		JedisCache jedisCache = new JedisCache(redisConfig);
		// -----添加数据----------
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "testMap");
		map.put("age", "22");
		map.put("qq", "123456");
		jedisCache.hset("user", map);
		// 取出user中的name、age、qq
		// 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
		List<String> rsmap = jedisCache.hmget("user", "name", "age", "qq");
		System.out.println("This map in redis: " + rsmap);
	}
}
