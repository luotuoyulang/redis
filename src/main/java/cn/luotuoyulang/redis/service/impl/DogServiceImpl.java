package cn.luotuoyulang.redis.service.impl;

import cn.luotuoyulang.redis.entity.Dog;
import cn.luotuoyulang.redis.mapper.DogMapper;
import cn.luotuoyulang.redis.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyuhu
 * @Description
 * @Package cn.luotuoyuang.redis.service.impl
 * CreaterName liuyuhu
 * @Email 17600520726@163.com
 * @Date 2019/6/24
 */
@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogMapper dogMapper;

    @Override
    public List<Dog> findDog() {
        return dogMapper.findDog();
    }
}
