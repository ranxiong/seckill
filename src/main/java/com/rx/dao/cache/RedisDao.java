package com.rx.dao.cache;

import com.rx.entity.Seckill;
import com.rx.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016-06-29.
 */
@Service
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    public Boolean hasSeckill(long seckillId) {
        String key = "seckill : " + seckillId;
        return redisUtil.hasKey(key);
    }

    public Seckill getSeckill(long seckillId) {
        //redis操作逻辑
        Seckill seckill = null;
        try {
            String key = "seckill : " + seckillId;
            seckill = (Seckill) redisUtil.get(key);
        } catch (Exception e) {
            logger.error("redis get error!", e);
        }
        return seckill;
    }

    public boolean putSeckill(Seckill seckill) {
        boolean flag;
        try {
            String key = "seckill : " + seckill.getSeckillId();
            flag = redisUtil.set(key, seckill);
        } catch (Exception e) {
            flag = false;
            logger.error("redis put error!", e);
        }
        return flag;
    }
}
