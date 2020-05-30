package info.luckydog.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ThreadPoolConfig {

    private static int CORE_SIZE = 16;
    private static final int MAX_SIZE = 16;
    private static final long KEEP_ALIVE = 60 * 1000L;
    private static final TimeUnit TIME_UNIT = TimeUnit.MICROSECONDS;
    private static final String NAME_PREFIX = "thread-pool-";
    private static final AtomicInteger nextId = new AtomicInteger();

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        if (CORE_SIZE > cpuCore) {
            CORE_SIZE = cpuCore;
        }
        System.out.println("thread pool core size: " + CORE_SIZE + "; cpu core num: " + cpuCore);
        return new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_ALIVE, TIME_UNIT, new LinkedBlockingQueue<>(), threadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    @Bean
    public ThreadFactory threadFactory() {
//        return r -> new Thread(r, NAME_PREFIX + nextId.getAndIncrement());
        return Thread::new;
    }
}
