package com.example.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/stringandHash")
    public Map<String,Object> testStringAndHash(){

        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int","1");

        //使用运算
        stringRedisTemplate.opsForValue().increment("int",1);

        //获取底层的redis连接
        Jedis jedis = (Jedis)stringRedisTemplate.getConnectionFactory()
                .getConnection().getNativeConnection();
        //减1操作，这个RedisTemplate不支持,所以先获取底层连接再操作
        jedis.decr("int");
        Map<String,Object> hash = new HashMap<>();
        hash.put("field1","values1");

        hash.put("field2","value2");
        //存入一个散列的数据类型
        stringRedisTemplate.opsForHash().putAll("hash",hash);

        //新增加一个字段
        stringRedisTemplate.opsForHash().put("hash","field3","value3");

        //绑定散列操作的Key,这样对同一个散列数据类型进行操作
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");

        //删除2个字段
        hashOps.delete("field1","field2");

        //新增一个字段
        hashOps.put("field4","value5");

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;










    }

}
