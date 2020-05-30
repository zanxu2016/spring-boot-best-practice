package info.luckydog.rabbit.producer;

import info.luckydog.rabbit.producer.binding.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({MySource.class})// 声明指定接口开启Binding功能，扫描其@Input和@Output注解。
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
