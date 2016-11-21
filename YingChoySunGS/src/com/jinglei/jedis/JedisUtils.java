package com.jinglei.jedis;

import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisException;

public class JedisUtils {

    /**
     * 判斷  返回值是否 OK
     */
    public static boolean isStatusOk(String status) {
        return (status != null) && (RedisKeys.OK_CODE.equals(status) || RedisKeys.OK_MULTI_CODE.equals(status));
    }

    /**
     * 在Pool以外強行銷毀Jedis.
     */
    public static void destroyJedis(Jedis jedis) {
        if ((jedis != null) && jedis.isConnected()) {
            try {
                try {
                    jedis.quit();
                } catch (Exception e) {
                }
                jedis.disconnect();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Ping the jedis instance, return true is the result is PONG.
     */
    public static boolean ping(JedisPool pool) {
        JedisTemplate template = new JedisTemplate(pool);
        try {
            String result = template.execute(new JedisTemplate.JedisAction<String>() {
                @Override
                public String action(Jedis jedis) {
                    return jedis.ping();
                }
            });
            return (result != null) && result.equals("PONG");
        } catch (JedisException e) {
            return false;
        }
    }

}
