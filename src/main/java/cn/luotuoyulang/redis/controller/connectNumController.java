package cn.luotuoyulang.redis.controller;

import cn.luotuoyulang.redis.service.ConnectNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class connectNumController {

    @Autowired
    private ConnectNumService connectNumService;

    private String color;

    @GetMapping("/createNum")
    public void createNum(){
         connectNumService.createNum();
    }


    @GetMapping("/queryNumList")
    public List<Integer> queryNumList(){

        return connectNumService.queryNumList();
    }
}
