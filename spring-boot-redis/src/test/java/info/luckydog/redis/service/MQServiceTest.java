package info.luckydog.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MQServiceTest {

    @Autowired
    private MQService mqService;

    @Test
    public void testProduceAndConsumeMsg() {

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Message message = new Message(i, "msg content " + i);
                mqService.produceMsg(message);
                sleep(100);
            }
        });

        Thread consumer = new Thread(() -> mqService.consumeMsg());

        consumer.start();
        sleep(2000);
        producer.start();

        sleep(10000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("thread {} interrupted.", Thread.currentThread().getName());
        }
    }

}