package info.luckydog.redis.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class MQService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String QUEUE_NAME = "redis:msg";

    public void produceMsg(Message msg) {
        log.info("produce msg into queue: {}, msg: {}\n", QUEUE_NAME, msg);
        redisTemplate.opsForList().leftPush(QUEUE_NAME, msg.toString());
    }

    public void consumeMsg() {
        while (true) {
            String msg = redisTemplate.opsForList().rightPop(QUEUE_NAME);
            if (StringUtils.hasText(msg)) {
                log.info("consume msg from queue: {}, msg: {}\n", QUEUE_NAME, msg);
            } else {
                log.info("has no msg in queue: {}", QUEUE_NAME);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("thread {} interrupted.", Thread.currentThread().getName());
                }
            }
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Message {
    private long id;
    private String content;
}
