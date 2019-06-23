package cn.luotuoyulang.redis.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Dog implements Serializable {

    private String name;

    private String color;
}
