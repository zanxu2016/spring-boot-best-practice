package info.luckydog.consumer.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

    String INPUT = "demo01-input";// 对应application.yml 中的spring.cloud.stream.bindings配置项

    @Input(INPUT)
    SubscribableChannel demo01Input();
}
