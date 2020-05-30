package info.luckydog.consumer.consumer;

import info.luckydog.consumer.binding.MySink;
import info.luckydog.consumer.msg.Demo01Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
@Slf4j
public class Demo01Consumer {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @StreamListener(MySink.INPUT)
    public void onMessage(@Payload Demo01Msg msg) {// @Payload 注解，将消息内容反序列化为POJO对象
        threadPoolExecutor.execute(() -> {
            log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getName(), msg);
        });
    }
}
