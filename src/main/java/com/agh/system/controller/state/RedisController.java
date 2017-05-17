package com.agh.system.controller.state;


import com.agh.system.common.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dayu on 8/27/16.
 */
@RestController
@RequestMapping("/state/redis")
public class RedisController {

    @Resource
    JedisPool jedisPool;

    @RequestMapping(value = "/pool")
    public RestResponse ping() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("numActive", jedisPool.getNumActive());
        data.put("numIdle", jedisPool.getNumIdle());
        data.put("numWaiters",  jedisPool.getNumWaiters());
        return new RestResponse(data);
    }


    @RequestMapping(value = "/test")
    public RestResponse test() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("test", (new Date()).toString());

            Map<String, Object> data = new HashMap<>();
            data.put("state", "Success");
            data.put("testValue", jedis.get("test"));
            return new RestResponse(data);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}
