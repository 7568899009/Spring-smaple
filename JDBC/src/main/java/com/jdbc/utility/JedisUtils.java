package com.jdbc.utility;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    //服务地址
    private static String host = null;
    //服务端口号
    private static int port;
    //最大连接数
    private static int maxTotal;
    //最大活动数
    private static int maxIdle;
    //配置对象
    private static JedisPoolConfig jedisPoolConfig = null;
    //连接池
    private static JedisPool jedisPool = null;

    static {
        //读取配置文件，获得参数值
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jedis");
        host = resourceBundle.getString("host");
        port = Integer.parseInt(resourceBundle.getString("port"));
        maxTotal = Integer.parseInt(resourceBundle.getString("maxTotal"));
        maxIdle = Integer.parseInt(resourceBundle.getString("maxIdle"));
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(jedisPoolConfig,host,port);
    }
    //获取连接池
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}