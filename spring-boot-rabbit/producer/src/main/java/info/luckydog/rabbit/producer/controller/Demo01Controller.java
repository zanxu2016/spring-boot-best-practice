package info.luckydog.rabbit.producer.controller;

import info.luckydog.rabbit.producer.binding.MySource;
import info.luckydog.rabbit.producer.msg.Demo01Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.LongAdder;

@RestController
@RequestMapping("/demo01")
@Slf4j
public class Demo01Controller {

    @Autowired
    private MySource mySource;

    private LongAdder adder = new LongAdder();

    @GetMapping("/send")
    public boolean send() {
        adder.increment();

        Demo01Msg msg = Demo01Msg.builder().id(adder.intValue()).build();

        Message<Demo01Msg> springMsg = MessageBuilder.withPayload(msg).build();

        boolean result = mySource.demo01Output().send(springMsg);
        log.info("[send][发送编号：[{}] 发送成功]", msg.getId());
        return result;
    }
}
