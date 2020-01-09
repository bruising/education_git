package com.pengyipeng.education.util.redis;

/**
 * @author 孙敬轩
 * @version V1.0
 * @Project: redis-demo
 * @Package com.sjx.redisdemo.util.redis
 * @Description: redis工具类
 * @date 2020/1/3 09:58 星期五
 */

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {

    /**
     * 获取redisTemplate对象
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * redis中添加数据
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    public boolean set(String key, String value) {
        try {
            // 将键值序列化
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            // 实例化操作redis的ValueOperations对象
            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            // 调用set方法将键值传入
            vo.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加数据是设置超时时间
     *
     * @param key     键
     * @param value   值
     * @param seconds 有效时长
     * @return
     */
    public boolean set(String key, String value, long seconds) {
        try {
            // 键值序列化
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            // 实例化操作redis的ValueOperations对象
            ValueOperations<String, Object> vo = redisTemplate.opsForValue();
            // 将键值存入redis
            vo.set(key, value);
            // 根据key设置超时时间
            expire(key, seconds);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key设置超时时间
     *
     * @param key        键
     * @param expireTime 有效时长
     * @return
     */
    public boolean expire(final String key, final long expireTime) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            // 重写内部类
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                boolean flag = false;
                try {
                    // 序列化键值对
                    redisTemplate.setKeySerializer(new StringRedisSerializer());
                    redisTemplate.setValueSerializer(new StringRedisSerializer());
                    // 将键转化成byte数组
                    byte[] keys = new StringRedisSerializer().serialize(key);
                    // 根据键设置超时时间
                    flag = redisConnection.expire(keys, expireTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return flag;
            }
        });
    }

    /**
     * 获取到期剩余时间
     *
     * @param key 键
     * @return
     */
    public Long getExpire(String key) {
        // 将键序列化给redis
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 将查询的值进行序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return redisTemplate.getExpire(key);
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return
     */
    public Object get(String key) {
        // 将键序列化给redis
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 将查询的值进行序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 实例化redis操作对象
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        // 返回查询结果
        return vo.get(key);
    }

    /**
     * 删除值
     *
     * @param key 键
     */
    public boolean delete(String key) {
        try {
            // 实例化键
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            // 通过键删除值
            boolean delete = redisTemplate.delete(key);
            if (delete) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 是否存在
     *
     * @param key 键
     * @return
     */
    public boolean exists(String key) {
        // 序列化键
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 将查询的值进行序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 实例化reids操作对象
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        // 获取值
        Object value = vo.get(key);
        if (value == null || value == "") {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 修改值
     *
     * @param key   原键
     * @param value 新值
     * @return
     */
    public boolean update(String key, String value) {
        // 键值序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 实例化reids操作对象
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        // 获取当前key的超时时间
        Long expireTime = redisTemplate.getExpire(key);
        // 如果为空、零或者-2则已过期或不存在
        if (expireTime == null) {
            return false;
        } else if (expireTime == 0 || expireTime == -2) {
            return false;
        }
        // 将新值设置给原键
        vo.set(key, value);
        if (expireTime > 0) {
            // 将大于零的超时时间重新设置给原键
            expire(key, expireTime);
            return true;
        }
        return false;
    }
}