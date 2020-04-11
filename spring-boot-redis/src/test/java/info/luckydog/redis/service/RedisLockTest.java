package info.luckydog.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.*;

/**
 * RedisLockTest
 *
 * @author eric
 * @since 2019/12/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RedisLockTest {

    @Autowired
    private RedisLock redisLock;

    @Test
    public void test() {
        String key = "123456";
        long expireTimeStamp = 500;

        // 并发抢占分布式锁
        concurrencyTryLock(key, expireTimeStamp);
    }

    // 多线程并发尝试加锁（测试用例不好，暂时没有想到更好的）
    private void concurrencyTryLock(String key, long expireTimeStamp) {
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t01").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t02").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t03").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t04").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t05").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t06").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t07").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t08").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t09").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t10").start();
//        this.sleep(expireTimeStamp);// 加上这一句，会导致死循环，原因未知！
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t11").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t12").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t13").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t14").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t15").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t16").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t17").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t18").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t19").start();
        new Thread(() -> this.tryLock(key, expireTimeStamp), "t20").start();
    }

    // 单线程尝试加锁
    private void singleThread(String key, long expireTimeStamp) {
        long value = System.currentTimeMillis() + expireTimeStamp;
        boolean locked = redisLock.lock(key, String.valueOf(value));
        log.info("try lock once: {}", locked);
        locked = redisLock.lock(key, String.valueOf(value));
        log.info("try lock twice: {}", locked);

        try {
            Thread.sleep(expireTimeStamp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        locked = redisLock.lock(key, String.valueOf(value));
        log.info("try lock third time: {}", locked);
    }

    // 尝试加锁
    private void tryLock(String key, long expire) {
        String value = String.valueOf(System.currentTimeMillis() + expire);
        boolean locked = redisLock.lock(key, value);
        this.printMsg(locked, key, value);
    }

    // 打印信息
    private void printMsg(boolean locked, String key, String value) {
        log.info("Thread {} get lock? {}, key: {}, value: {}", Thread.currentThread().getName(), locked, key, value);
    }

    // 线程睡眠
    private void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
            log.info("Thread {} sleep for {} second(s).", Thread.currentThread().getName(), timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(8, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }

}
