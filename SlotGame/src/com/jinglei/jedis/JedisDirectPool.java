package com.jinglei.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDirectPool extends JedisPool {
    public JedisDirectPool(String poolName, HostAndPort address, JedisPoolConfig config) {
        this(poolName, address, new ConnectionInfo(), config);
    }

    public JedisDirectPool(String poolName, HostAndPort address, ConnectionInfo connectionInfo, JedisPoolConfig config) {
        initInternalPool(address, connectionInfo, config, poolName);
        this.poolName = poolName;
    }
}
