package cn.luotuoyulang.redis.controller;

import cn.luotuoyulang.redis.entity.Dog;
import cn.luotuoyulang.redis.service.DogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class DogController {

    @Autowired
    private DogService dogService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${imps.record.exchange.name}")
    private String queueType;

    @Value("${imps.record.order.key.name}")
    private String rootingKing;

    @GetMapping("/findDog")
    public List<Dog> findDog(){
        return dogService.findDog();
    }


    @GetMapping("/sendMsg")
    public String sendRabbitMQ()  {
        try{
            rabbitTemplate.setExchange(queueType);
            rabbitTemplate.setRoutingKey(rootingKing);
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

            Dog dog = new Dog(1, "小米");

            Message msg= MessageBuilder.withBody(objectMapper.writeValueAsBytes(dog)).setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT)
                    .build();
            rabbitTemplate.convertAndSend(msg);
            return "法功成功。。。。。。。。。。。";
        }
        catch (Exception se){
            log.error(se.getMessage());
            throw new RuntimeException("调用失败。。。。。。");
        }
    }
}
