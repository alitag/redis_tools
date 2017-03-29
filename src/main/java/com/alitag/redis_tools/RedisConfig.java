package com.alitag.redis_tools;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisShardInfo;

/**
 * <p>
 * 该类是一个配置信息类,可以通过这个类中集中设置各种信息,用于初始化对应的redis连接池
 * </p>
 * <p>
 * <b>线程安全</b> 该类非线程安全，因为它是可变类。
 * </p>
 * 
 * @author gchangyi
 * @version 1.0
 */
public class RedisConfig {

	/** 可用连接实例的最大数目,默认值为8. 如果赋值为-1,则表示不限制; 如果pool已经分配了maxTotal个jedis实例,则此时pool的状态为exhausted(耗尽). */
	public int maxTotal = 8;

	/** 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例,默认值是5. */
	public int maxIdle = 5;

	/** 等待可用连接的最大时间,单位毫秒，默认值为-1,表示永不超时.如果超过等待时间,则直接抛出JedisConnectionException. */
	public int maxWait = 10000;

	/** 在borrow一个jedis实例时,是否提前进行validate操作;如果为true,则得到的jedis实例均是可用的. */
	public boolean testOnBorrow = true;

	// 所有redis实例,多台redis主机时可以做集群,通过一致性哈希算法决定把数据存到哪个redis实例上
	private List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();

	public RedisConfig addHost(String host, int port) {
		shards.add(new JedisShardInfo(host, port));
		return this;
	}

	public RedisConfig addHost(String host, int port, String password) {
		JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port);
		jedisShardInfo.setPassword(password);
		shards.add(jedisShardInfo);
		return this;
	}

	public RedisConfig addHost(JedisShardInfo jedisShardInfo) {
		shards.add(jedisShardInfo);
		return this;
	}

	public RedisConfig addHost(String host) {
		shards.add(new JedisShardInfo(host));
		return this;
	}

	public List<JedisShardInfo> getShards() {
		return this.shards;
	}

	public void clearShards() {
		shards.clear();
	}
}
