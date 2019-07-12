package cn.luotuoyulang.redis.service;

import java.util.List;

/**
 * @author liuyuhu
 * @Description
 * @Package cn.luotuoyuang.redis.service
 * CreaterName liuyuhu
 * @Email 17600520726@163.com
 * @Date 2019/6/24
 */
public interface ConnectNumService {

    List<Integer> queryNumList();

    Integer createNum();
}
