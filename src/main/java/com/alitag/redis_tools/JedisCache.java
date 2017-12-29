package com.alitag.redis_tools;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.SerializationUtils;

/**
 * jedis tool
 * 
 * @author gchangyi
 * @version 1.0
 */
public class JedisCache extends RedisExecutor {

	public JedisCache(RedisConfig redisConfig) {
		super(redisConfig);
	}

	/**
	 * @see #setString(String, String)
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(final String key, final String value) {
		return super.setString(key, value);
	}

	/**
	 * @see #setObject(String, Serializable)
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(final String key, final Serializable value) {
		return super.setObject(key, value);
	}

	/**
	 * @see #setString(String, String, int)
	 * @param key
	 * @param value
	 * @param timeout(以秒为单位)。
	 * @return
	 */
	public String set(final String key, final String value, final int timeout) {
		return super.setString(key, value, timeout);
	}

	/**
	 * @see #hashSet(String, String, String)
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public Long hset(final String key, final String field, final String value) {
		return super.hashSet(key, field, value);
	}

	/**
	 * @see #hashSet(String, String, String, int)
	 * @param key
	 * @param field
	 * @param value
	 * @param timeout
	 * @return
	 */
	public Long hset(final String key, final String field, final String value, final int timeout) {
		return super.hashSet(key, field, value, timeout);
	}

	/**
	 * @see #hashMultipleSet(String, Map)
	 * @param key
	 * @param map
	 * @return
	 */
	public String hset(final String key, final Map<String, String> map) {
		return super.hashMultipleSet(key, map);
	}

	/**
	 * @see #hashMultipleSet(String, Map, int)
	 * @param key
	 * @param map
	 * @param timeout
	 * @return
	 */
	public String hset(final String key, Map<String, String> map, final int timeout) {
		return super.hashMultipleSet(key, map, timeout);
	}

	public Long hset(final String key, final String field, final Serializable value) {
		return super.hset(key, field, value);
	}

	public Long hset(final String key, final String field, final Serializable value, int timeout) {
		return super.hset(key, field, value, timeout);
	}

	public boolean exists(final String key, final String field) {
		return super.exists(key, field);
	}

	public boolean exists(final String key) {
		return super.exists(key);
	}

	/**
	 * @see #delKey(String)
	 * @param key
	 * @return
	 */
	public Long del(final String key) {
		return super.delKey(key);
	}

	/**
	 * @see #delKey(String, String...)
	 * @param key
	 * @param fileds
	 * @return
	 */
	public Long del(final String key, final String... fileds) {
		return super.delKey(key, fileds);
	}

	public <T extends Serializable> T get(final String key) {
		return super.get(key);
	}

	public String get(final String key, final String field) {
		return super.hashGet(key, field);
	}

	/**
	 * @see #hashGetAll(String)
	 * @param key
	 * @return
	 */
	public Map<String, String> getAllHash(final String key) {
		return super.hashGetAll(key);
	}

	/**
	 * 返回哈希表 key 中给定域 field 的值的序列化对象
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public Serializable getModel(final String key, final String field) {
		return (Serializable) SerializationUtils.deserialize(super.hashGet(key, field).getBytes());
	}

	/**
	 * @see #listRange(String, long, long)
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<String> getSet(final String key, final long start, final long end) {
		return super.listRange(key, start, end);
	}

	/**
	 * @see #getKeysLike(String)
	 * @param keyStart
	 *            匹配key的开头
	 * @return
	 */
	public Set<String> getKeyStartWith(final String keyStart) {
		return super.getKeysLike(keyStart + "*");
	}

	/**
	 * @see #delKeysLike(String)
	 * @param keyStart
	 *            匹配key的开头
	 * @return
	 */
	public Long delKeyStartWith(final String keyStart) {
		return super.delKeysLike(keyStart + "*");
	}

	/**
	 * @see #hashGet(String, String)
	 * @param key
	 * @param field
	 * @return
	 */
	public String hget(final String key, final String field) {
		return super.hashGet(key, field);
	}

	/**
	 * @see #hashGet(String, String, int)
	 * @param key
	 * @param field
	 * @param timeout
	 * @return
	 */
	public String hget(final String key, final String field, final int timeout) {
		return super.hashGet(key, field, timeout);
	}

	/**
	 * @see #hashMultipleGet(String, String...)
	 * @param key
	 * @param fields
	 * @return
	 */
	public List<String> hmget(String key, String... fields) {
		return super.hashMultipleGet(key, fields);
	}

	/**
	 * @see #hashLen(String)
	 * @param key
	 * @return
	 */
	public Long hcount(String key) {
		return super.hashLen(key);
	}

	public Long sadd(String key, String... members) {
		return super.sadd(key, members);
	}

	public Long srem(String key, String... members) {
		return super.srem(key, members);
	}

	public Set<String> sunion(String... keys) {
		return super.sunion(keys);
	}

	public Set<String> sdiff(String... keys) {
		return super.sdiff(keys);
	}

	public Long scard(String key) {
		return super.scard(key);
	}

	/**
	 * @see #listPushHead(String, String...)
	 * @param key
	 * @param values
	 * @return
	 */
	public Long lpush(String key, String... values) {
		return super.listPushHead(key, values);
	}

	/**
	 * @see #listPushTail(String, String...)
	 * @param key
	 * @param values
	 * @return
	 */
	public Long rpush(String key, String... values) {
		return super.listPushTail(key, values);
	}

	/**
	 * @see #listPushHeadAndTrim(String, String, long)
	 * @param key
	 * @param value
	 * @param size
	 * @return
	 */
	public Long lpushTrim(String key, String value, long size) {
		return super.listPushHeadAndTrim(key, value, size);
	}

	/**
	 * @see #listDel(String, String, int)
	 * @param key
	 * @param value
	 * @return
	 */
	public Long ldel(String key, String value) {
		return super.listDel(key, value, -1);
	}

	/**
	 * @see #listLen(String)
	 * @param key
	 * @return
	 */
	public Long lcount(String key) {
		return super.listLen(key);
	}

	public <T extends Serializable> T hgetObj(String key, String field) {
		return super.hgetObj(key, field);
	}

}
