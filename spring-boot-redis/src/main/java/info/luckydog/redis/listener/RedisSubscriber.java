package info.luckydog.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * RedisSubscriber
 *
 * @author eric
 * @since 2019/12/16
 */
@Component
@Slf4j
public class RedisSubscriber extends MessageListenerAdapter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {

        log.info("onMessage: {}", message);
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        String topic = redisTemplate.getStringSerializer().deserialize(channel);
        String msg = redisTemplate.getStringSerializer().deserialize(body);
        log.info("监听到 topic 为 {} 的消息：{}", topic, msg);

        String keyPrefix = "redis:expire:notice";
        //message.toString()可以获取失效的key
        String expiredKey = msg.toString();
        if (expiredKey.startsWith(keyPrefix)) {
            // 监控KEY, 在这里处理业务
            log.info("expireKey: {} notice here!");
        }
    }
}
