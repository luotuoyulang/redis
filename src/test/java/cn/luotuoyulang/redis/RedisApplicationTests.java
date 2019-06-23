package cn.luotuoyulang.redis;

import cn.luotuoyulang.redis.entity.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Test
    public void test()  {
        Dog dog = new Dog();
        dog.setColor("红色");
        dog.setName("小花狗");
        // 保存字符串
        redisTemplate.opsForValue().set("bbb", dog);

        Object aaa = redisTemplate.opsForValue().get("bbb");
//        Dog  aaa = (Dog)redisTemplate.opsForValue().get("bbb");
        System.err.println(aaa);

    }
}
