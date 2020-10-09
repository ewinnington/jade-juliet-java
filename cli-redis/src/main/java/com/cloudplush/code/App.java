package com.cloudplush.code;

import redis.clients.jedis.Jedis;

/**
 * Hello world to Redis
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Jedis jedis = new Jedis("localhost");
        jedis.set("key1", "Hello World from Redis!");
        String value = jedis.get("key1");
        System.out.println(value); 
    }
}
