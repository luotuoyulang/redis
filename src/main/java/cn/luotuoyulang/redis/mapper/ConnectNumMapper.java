package cn.luotuoyulang.redis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author liuyuhu
 * @Description
 * @Package cn.luotuoyuang.redis.mapper
 * CreaterName liuyuhu
 * @Email 17600520726@163.com
 * @Date 2019/6/24
 */
public interface ConnectNumMapper {

    Integer queryTotalNum();

    Integer createNum();

    Integer  getNum(String date);

    Integer  updateNum(Date date);
}
