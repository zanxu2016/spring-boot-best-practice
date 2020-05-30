package info.luckydog.rabbit.producer.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 定义binding的input和output
 * 该接口不需要实现，由BindableProxyFactory通过动态代理来实现
 *
 * @see org.springframework.cloud.stream.binding.BindableProxyFactory
 */
public interface MySource {

    String OUTPUT = "demo01-output";// 对应application.yml 中的spring.cloud.stream.bindings配置项

    /**
     * 由@Output注解，该方法会被自动创建返回结果为DirectWithAttributesChannel，MessageChannel的子类
     * @return MessageChannel
     * @see org.springframework.cloud.stream.messaging.DirectWithAttributesChannel
     */
    @Output(OUTPUT)
    MessageChannel demo01Output();

}
