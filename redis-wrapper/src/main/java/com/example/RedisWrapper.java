package com.example;

import redis.clients.jedis.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisWrapper {
    private Jedis jedis;

    public RedisWrapper(String host, int port) {
        this.jedis = new Jedis(host, port);
    }

    // String operations
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public String setex(String key, int seconds, String value) {
        return jedis.setex(key, seconds, value);
    }

    public Long del(String... keys) {
        return jedis.del(keys);
    }

    public Boolean exists(String key) {
        return jedis.exists(key);
    }

    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

    public Long ttl(String key) {
        return jedis.ttl(key);
    }

    public Long incr(String key) {
        return jedis.incr(key);
    }

    public Long decr(String key) {
        return jedis.decr(key);
    }

    // Hash operations
    public Long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }

    public Long hdel(String key, String... fields) {
        return jedis.hdel(key, fields);
    }

    public List<String> hmget(String key, String... fields) {
        return jedis.hmget(key, fields);
    }

    public String hmset(String key, Map<String, String> hash) {
        return jedis.hmset(key, hash);
    }

    // List operations
    public Long lpush(String key, String... values) {
        return jedis.lpush(key, values);
    }

    public Long rpush(String key, String... values) {
        return jedis.rpush(key, values);
    }

    public String lpop(String key) {
        return jedis.lpop(key);
    }

    public String rpop(String key) {
        return jedis.rpop(key);
    }

    public List<String> lrange(String key, long start, long stop) {
        return jedis.lrange(key, start, stop);
    }

    // Set operations
    public Long sadd(String key, String... members) {
        return jedis.sadd(key, members);
    }

    public Long srem(String key, String... members) {
        return jedis.srem(key, members);
    }

    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    // Sorted Set operations
    public Long zadd(String key, double score, String member) {
        return jedis.zadd(key, score, member);
    }

    public Set<String> zrange(String key, long start, long stop) {
        return jedis.zrange(key, start, stop);
    }

    public Long zrem(String key, String... members) {
        return jedis.zrem(key, members);
    }

    // Pub/Sub
    public Long publish(String channel, String message) {
        return jedis.publish(channel, message);
    }

    public void subscribe(JedisPubSub listener, String... channels) {
        jedis.subscribe(listener, channels);
    }

    // Connection and misc
    public String ping() {
        return jedis.ping();
    }

    public void close() {
        jedis.close();
    }
}
