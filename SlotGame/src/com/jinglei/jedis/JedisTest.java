package com.jinglei.jedis;

import java.util.concurrent.ExecutionException;

public class JedisTest {
    public static void main(String[] args) throws ExecutionException {

        JedisPool jedisPool=JedisPoolUtils.getJedisPopol(0);
        JedisPool jedisPool2=JedisPoolUtils.getJedisPopol(1);
        JedisPool jedisPool3=JedisPoolUtils.getJedisPopol(2);
        JedisTemplate jedisTemplate=new JedisTemplate(jedisPool);
        System.out.println(jedisTemplate.hget("key1","file21"));
        System.out.println(jedisPool);
        System.out.println(jedisPool2);
        System.out.println(jedisPool3);
    }
}
