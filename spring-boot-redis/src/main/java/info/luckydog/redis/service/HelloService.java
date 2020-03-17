package info.luckydog.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * HelloService
 *
 * @author eric
 * @since 2019/12/16
 */
@Service
@Slf4j
public class HelloService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set() {
        String key = "test";
        String value = "123";
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setTimeout() {
        String key = "test-timeout";
        String value = "456";
        long timeout = 100;
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void get() {
        String key = "test";
        String value = stringRedisTemplate.opsForValue().get(key);
        log.info("{} : {}", key, value);
        key = "test-timeout";
        value = stringRedisTemplate.opsForValue().get(key);
        log.info("{} : {}", key, value);
    }

    public void delete() {
        String key = "test";
        Boolean hasDelete = stringRedisTemplate.delete(key);
        log.info("{} hasDelete? {}", key, hasDelete);
    }

    public void pubsub() {
        log.info("设置 key 及其过期时间...");
        redisTemplate.convertAndSend("redis:expire:notice:test", "测试键过期事件回调");
    }
}
