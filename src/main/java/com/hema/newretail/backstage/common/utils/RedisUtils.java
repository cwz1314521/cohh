package com.hema.newretail.backstage.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.SafeEncoder;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 */
@Component
public class RedisUtils {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 回收jedis(放到finally中)
     *
     * @param jedis Jedis对象
     */
    private void close(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }

    ////////////////////////////////////////////////
    // hash
    ///////////////////////////////////////////////

    /**
     * 设置过期时间
     *
     * @param key     键
     * @param seconds 过期时间 单位是秒
     */
    public void expire(String key, int seconds) {
        if (seconds <= 0) {
            return;
        }
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key, seconds);
        close(jedis);
    }

    /**
     * 从hash中删除指定的存储
     *
     * @param key   键
     * @param fieid 存储的名字
     * @param index 具体的数据库
     * @return 状态码，1成功，0失败
     */
    public long hdel(String key, String fieid, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        long s = jedis.hdel(key, fieid);
        close(jedis);
        return s;
    }

    public long hdel(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        long s = jedis.del(key);
        close(jedis);
        return s;
    }

    /**
     * 测试hash中指定的存储是否存在
     *
     * @param key   键
     * @param fieid 存储的名字
     * @param index 具体的数据库
     * @return 1存在，0不存在
     */
    public boolean hexists(String key, String fieid, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        boolean s = jedis.hexists(key, fieid);
        close(jedis);
        return s;
    }

    /**
     * 判断指定的key是否存在
     *
     * @param key   键
     * @param index 具体的数据库
     * @return true 存在 false 不存在
     */
    public boolean hexists(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        boolean s = jedis.exists(key);
        close(jedis);
        return s;
    }

    /**
     * 返回hash中指定存储位置的值
     *
     * @param key   键
     * @param fieid 存储的名字
     * @param index 具体的数据库
     * @return 存储对应的值
     */
    public String hget(String key, String fieid, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        String s = jedis.hget(key, fieid);
        close(jedis);
        return s;
    }

    public byte[] hget(byte[] key, byte[] fieid, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        byte[] s = jedis.hget(key, fieid);
        close(jedis);
        return s;
    }

    /**
     * 以Map的形式返回hash中的存储和值
     *
     * @param key   键
     * @param index 具体的数据库
     * @return Map
     */
    public Map<String, String> hgetAll(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        Map<String, String> map = jedis.hgetAll(key);
        close(jedis);
        return map;
    }

    /**
     * 添加一个对应关系
     *
     * @param key   键
     * @param fieid 字段
     * @param value 值
     * @param index 具体的数据库
     * @return 状态码 1成功，0失败，fieid已存在将更新，也返回0
     **/
    public long hset(String key, String fieid, String value, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        long s = jedis.hset(key, fieid, value);
        close(jedis);
        return s;
    }

    public long hset(String key, String fieid, byte[] value, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);

        long s = jedis.hset(key.getBytes(StandardCharsets.UTF_8), fieid.getBytes(StandardCharsets.UTF_8), value);
        close(jedis);
        return s;
    }

    /**
     * 添加对应关系，只有在fieid不存在时才执行
     *
     * @param key   键
     * @param fieid 字段
     * @param value 值
     * @param index 具体的数据库
     * @return 状态码 1成功，0失败fieid已存
     **/
    public long hsetnx(String key, String fieid, String value, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        long s = jedis.hsetnx(key, fieid, value);
        close(jedis);
        return s;
    }

    /**
     * 获取hash中value的集合
     *
     * @param key   键
     * @param index 具体的数据库
     * @return list
     */
    public List<String> hvals(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        List<String> list = jedis.hvals(key);
        close(jedis);
        return list;
    }

    /**
     * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
     *
     * @param key   键
     * @param fieid 存储位置
     * @param value 要增加的值,可以是负数
     * @param index 具体的数据库
     * @return 增加指定数字后，存储位置的值
     */
    public long hincrby(String key, String fieid, long value, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        long s = jedis.hincrBy(key, fieid, value);
        close(jedis);
        return s;
    }

    /**
     * 返回指定hash中的所有存储名字,类似Map中的keySet方法
     *
     * @param key   键
     * @param index 具体的数据库
     * @return 存储名称的集合
     */
    public Set<String> hkeys(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        Set<String> set = jedis.hkeys(key);
        close(jedis);
        return set;
    }

    /**
     * 获取hash中存储的个数，类似Map中size方法
     *
     * @param key   键
     * @param index 具体的数据库
     * @return 存储的个数
     */
    public long hlen(String key, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        long len = jedis.hlen(key);
        close(jedis);
        return len;
    }

    /**
     * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
     *
     * @param key    键
     * @param index  具体的数据库
     * @param fieids 存储位置
     * @return List
     */
    public List<String> hmget(int index, String key, String... fieids) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        List<String> list = jedis.hmget(key, fieids);
        close(jedis);
        return list;
    }

    public List<byte[]> hmget(int index, byte[] key, byte[]... fieids) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        List<byte[]> list = jedis.hmget(key, fieids);
        close(jedis);
        return list;
    }

    /**
     * 添加对应关系，如果对应关系已存在，则覆盖
     *
     * @param key   键
     * @param map   对应关系
     * @param index 具体的数据库
     * @return 状态，成功返回OK
     */
    public String hmset(String key, Map<String, String> map, int index) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        String s = jedis.hmset(key, map);
        close(jedis);
        return s;
    }

    ////////////////////////////////////////////////
    // String
    ///////////////////////////////////////////////

    /**
     * 根据key获取记录
     *
     * @param key 键
     * @return 值
     */
    public String get(String key) {
        Jedis sjedis = jedisPool.getResource();
        String value = sjedis.get(key);
        close(sjedis);
        return value;
    }

    /**
     * 根据key获取记录
     *
     * @param key 键
     * @return 值
     */
    public byte[] get(byte[] key) {
        Jedis sjedis = jedisPool.getResource();
        byte[] value = sjedis.get(key);
        close(sjedis);
        return value;
    }

    /**
     * 添加有过期时间的记录
     *
     * @param key     键
     * @param seconds 过期时间，以秒为单位
     * @param value   值
     * @return String 操作状态
     */
    public String setEx(String key, int seconds, String value) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.setex(key, seconds, value);
        close(jedis);
        return str;
    }

    /**
     * 添加有过期时间的记录
     *
     * @param key     键
     * @param seconds 过期时间，以秒为单位
     * @param value   值
     * @return String 操作状态
     */
    public String setEx(byte[] key, int seconds, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.setex(key, seconds, value);
        close(jedis);
        return str;
    }

    /**
     * 添加一条记录，仅当给定的key不存在时才插入
     *
     * @param key   键
     * @param value 值
     * @return long 状态码，1插入成功且key不存在，0未插入，key存在
     */
    public long setnx(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long str = jedis.setnx(key, value);
        close(jedis);
        return str;
    }

    /**
     * 添加记录,如果记录已存在将覆盖原有的value
     *
     * @param key   键
     * @param value 值
     * @return 状态码
     */
    public String set(String key, String value) {
        return set(SafeEncoder.encode(key), SafeEncoder.encode(value));
    }

    /**
     * 添加记录,如果记录已存在将覆盖原有的value
     *
     * @param key   键
     * @param value 值
     * @return 状态码
     */
    public String set(String key, byte[] value) {
        return set(SafeEncoder.encode(key), value);
    }

    /**
     * 添加记录,如果记录已存在将覆盖原有的value
     *
     * @param key   键
     * @param value 值
     * @return 状态码
     */
    public String set(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        String status = jedis.set(key, value);
        close(jedis);
        return status;
    }

    /**
     * 从指定位置开始插入数据，插入的数据会覆盖指定位置以后的数据<br/>
     * 例:String str1="123456789";<br/>
     * 对str1操作后setRange(key,4,0000)，str1="123400009";
     *
     * @param key    键
     * @param offset 偏移量
     * @param value  值
     * @return long value的长度
     */
    public long setRange(String key, long offset, String value) {
        Jedis jedis = jedisPool.getResource();
        long len = jedis.setrange(key, offset, value);
        close(jedis);
        return len;
    }

    /**
     * 在指定的key中追加value
     *
     * @param key   键
     * @param value 值
     * @return long 追加后value的长度
     **/
    public long append(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long len = jedis.append(key, value);
        close(jedis);
        return len;
    }

    /**
     * 将key对应的value减去指定的值，只有value可以转为数字时该方法才可用
     *
     * @param key    键
     * @param number 要减去的值
     * @return long 减指定值后的值
     */
    public long decrBy(String key, long number) {
        Jedis jedis = jedisPool.getResource();
        long len = jedis.decrBy(key, number);
        close(jedis);
        return len;
    }

    /**
     * <b>可以作为获取唯一id的方法</b><br/>
     * 将key对应的value加上指定的值，只有value可以转为数字时该方法才可用
     *
     * @param key    键
     * @param number 要减去的值
     * @return long 相加后的值
     */
    public long incrBy(String key, long number) {
        Jedis jedis = jedisPool.getResource();
        long len = jedis.incrBy(key, number);
        close(jedis);
        return len;
    }

    /**
     * 对指定key对应的value进行截取
     *
     * @param key         键
     * @param startOffset 开始位置(包含)
     * @param endOffset   结束位置(包含)
     * @return String 截取的值
     */
    public String getrange(String key, long startOffset, long endOffset) {

        Jedis sjedis = jedisPool.getResource();
        String value = sjedis.getrange(key, startOffset, endOffset);
        close(sjedis);
        return value;
    }

    /**
     * 获取并设置指定key对应的value<br/>
     * 如果key存在返回之前的value,否则返回null
     *
     * @param key   键
     * @param value 值
     * @return String 原始value或null
     */
    public String getSet(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.getSet(key, value);
        close(jedis);
        return str;
    }

    /**
     * 批量获取记录,如果指定的key不存在返回List的对应位置将是null
     *
     * @param keys 键
     * @return List 值得集合
     */
    public List<String> mget(String... keys) {
        Jedis jedis = jedisPool.getResource();
        List<String> str = jedis.mget(keys);
        close(jedis);
        return str;
    }

    /**
     * 批量存储记录
     *
     * @param keysvalues 例:keysvalues="key1","value1","key2","value2";
     * @return String 状态码
     */
    public String mset(String... keysvalues) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.mset(keysvalues);
        close(jedis);
        return str;
    }

    /**
     * 获取key对应的值的长度
     *
     * @param key 键
     * @return value值得长度
     */
    public long strlen(String key) {
        Jedis jedis = jedisPool.getResource();
        long len = jedis.strlen(key);
        close(jedis);
        return len;
    }

}
