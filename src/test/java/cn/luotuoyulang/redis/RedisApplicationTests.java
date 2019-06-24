package cn.luotuoyulang.redis;

import cn.luotuoyulang.redis.entity.Dog;
import cn.luotuoyulang.redis.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    RedisUtils redisUtils;

    @Test
    public void test()  {
        Dog dog = new Dog(1,"小花");

        redisUtils.setObj("bbb",dog);

        Object bbb = redisUtils.getObj("bbb");
        System.err.println(bbb);

    }
}
