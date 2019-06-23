package cn.luotuoyulang.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public  void setString(String key, String value){
        log.info("--------------------->[Redis set start]");
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public String getString(String key){
        log.info("--------------------->[Redis get start]");
        return  stringRedisTemplate.opsForValue().get(key);
    }

    public void setObj(String key,Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public Object getObj(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}

