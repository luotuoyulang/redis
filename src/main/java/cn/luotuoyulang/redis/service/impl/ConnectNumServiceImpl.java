package cn.luotuoyulang.redis.service.impl;

import cn.luotuoyulang.redis.mapper.ConnectNumMapper;
import cn.luotuoyulang.redis.service.ConnectNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@Slf4j
public class ConnectNumServiceImpl implements ConnectNumService {

    @Autowired
    ConnectNumMapper connectNumMapper;


    @Override
    public List<Integer> queryNumList() {
        List<Integer> list = new ArrayList<>();
        list.add(connectNumMapper.queryTotalNum());
        log.info(connectNumMapper.queryTotalNum()+"");
        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd");
        String format = fmt.format(date);
        Integer num = connectNumMapper.getNum(format);
        if(null == num)
        {
            connectNumMapper.createNum();
            num = 1;
            list.add(num);
            return list;
        }
        connectNumMapper.updateNum(new Date());
        list.add(num+1);
        return list;
    }

    @Override
    public Integer createNum() {
        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-DD");
        String format = fmt.format(date);
        if(null == connectNumMapper.getNum(format))
        {
            return connectNumMapper.createNum();
        }
        return connectNumMapper.updateNum(new Date());
    }
}
