package cn.luotuoyulang.redis.service;

import cn.luotuoyulang.redis.entity.Dog;

import java.util.List;

/**
 * @author liuyuhu
 * @Description
 * @Package cn.luotuoyuang.redis.service
 * CreaterName liuyuhu
 * @Email 17600520726@163.com
 * @Date 2019/6/24
 */
public interface DogService {

    List<Dog> findDog();
}
