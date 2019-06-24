package cn.luotuoyulang.redis.controller;

import cn.luotuoyulang.redis.entity.Dog;
import cn.luotuoyulang.redis.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuyuhu
 * @Description
 * @Package cn.luotuoyuang.redis.controller
 * CreaterName liuyuhu
 * @Email 17600520726@163.com
 * @Date 2019/6/24
 */
@RestController
public class DogController {

    @Autowired
    private DogService dogService;

//    @Value("${color}")
//    private String color;

    @GetMapping("/findDog")
    public List<Dog> findDog(){
        return dogService.findDog();
    }

//    @GetMapping("/getApollo")
//    public String getApollo(){
//        return color;
//    }
}
