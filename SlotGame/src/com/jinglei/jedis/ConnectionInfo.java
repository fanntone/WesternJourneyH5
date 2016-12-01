package com.jinglei.jedis;

import redis.clients.jedis.Protocol;

public class ConnectionInfo {

    private int database = Protocol.DEFAULT_DATABASE;
    private static String password = RedisKeys.DEFAULT_PASSWORD;
    private int timeout = Protocol.DEFAULT_TIMEOUT;

    public ConnectionInfo() {
    }

    public ConnectionInfo(int database, String password, int timeout) {
        this.timeout = timeout;
        ConnectionInfo.password = password;
        this.database = database;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        ConnectionInfo.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "ConnectionInfo [database=" + database + ", password=" + password + ", timeout=" + timeout + "]";
    }
}
