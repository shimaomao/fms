package cn.com.leadu.fms.oauth2.service.impl;

import cn.com.leadu.fms.oauth2.repository.RedisRepository;
import cn.com.leadu.fms.oauth2.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaomengnan
 * @ClassName: RedisServiceImpl
 * @Description:
 * @date 2018/2/25
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisRepository redisRepository;

    /**
     * @Title:
     * @Description:   保存值进入redis
     * @param key
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:39:03
     */
    public void save(Object key,Object value){
        redisRepository.save(key,value);
    }

    /**
     * @Title:
     * @Description:   值存入redis同时限制时间
     * @param key
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:52:24
     */
    public void save(Object key,Object value,int time){
        redisRepository.save(key, value, time);
    }

    /**
     * @Title:
     * @Description:   通过key获取redis值
     * @param key
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:54:05
     */
    public Object get(Object key){
        return redisRepository.get(key);
    }

}
