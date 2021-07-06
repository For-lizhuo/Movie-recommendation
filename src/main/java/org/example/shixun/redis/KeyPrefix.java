package org.example.shixun.redis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
