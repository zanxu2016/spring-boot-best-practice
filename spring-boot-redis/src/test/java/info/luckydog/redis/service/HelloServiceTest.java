package info.luckydog.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * HelloServiceTest
 *
 * @author eric
 * @since 2019/12/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    public void set() {
        helloService.set();
    }

    @Test
    public void setTimeout() {
        helloService.setTimeout();
    }

    @Test
    public void get() {
        helloService.get();
    }

    @Test
    public void delete() {
        helloService.delete();
    }

    @Test
    public void pubsub() {
        helloService.pubsub();
    }
}
